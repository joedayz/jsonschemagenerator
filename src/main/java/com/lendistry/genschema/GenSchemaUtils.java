package com.lendistry.genschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class GenSchemaUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static final String SCHEMA_TYPE_BOOLEAN = "boolean";
    public static final String SCHEMA_TYPE_STRING = "string";
    public static final String SCHEMA_TYPE_NUMBER = "number";
    public static final String SCHEMA_TYPE_INTEGER = "integer";
    public static final String SCHEMA_TYPE_NULL = "null";


    /**
     * The base, unstructured data types
     */
    public static final List<String> BASE_TYPES = ImmutableList.of(SCHEMA_TYPE_BOOLEAN,
            SCHEMA_TYPE_INTEGER,
            SCHEMA_TYPE_NUMBER,
            SCHEMA_TYPE_STRING,
            SCHEMA_TYPE_NULL);

    /**
     * Deserializes a JSON-stringified JsonSchema to a "Schema" object
     * @param schemaString a JSON-stringified JsonSchema
     * @return a Schema object
     * @throws IOException
     */
    public static Schema deserializeSchema(String schemaString) throws IOException {
        return objectMapper.readValue(schemaString,Schema.class);
    }

    /**
     * Deserializes a JSON-stringified JsonSchema saved in a file, to a "Schema" object
     * @param schema a file reference
     * @return a Schema object
     * @throws IOException
     */
    public static Schema deserializeSchema(File schema) throws IOException {
        return objectMapper.readValue(schema,Schema.class);
    }

    /**
     * Merges two properties. This function will merge the attributes and properties of two Property
     * instances in a non-recursive fashion. It will also ignore the "items" sub-property, so array definitions
     * will not be merged
     * @param prop1 property to merge
     * @param prop2 property to merge
     * @return the merged property
     */
    public static Property merge(Property prop1, Property prop2){
        prop1 = prop1.clone();
        prop2 = prop2.clone();


        final Property property = new Property(prop1.getId(),prop1.getType(),prop1.getDefaultValue());

        /*
         * We will use this to collect every item that is not present in both properties so that we can compose
         * a proper "required" field
         */
        Set<String> removeFromRequired = new HashSet<>();

        // Going through all child-property keys from both properties...
        for(String key : Sets.union(prop1.getPropertiesKeys(),prop2.getPropertiesKeys())){
            Property child1 = prop1.getProperty(key);
            Property child2 = prop2.getProperty(key);
            // key is present in prop2 but not prop1
            if(child1 == null){
                // Add child2, and add this to the list of the properties that are not resent in both
                property.addChildProperty(key,child2);
                removeFromRequired.add(key);
            }else
                //key is present in prop2 but not prop1
                if(child2 == null){
                    // Add child1, and add this to the list of the properties that are not resent in both
                    property.addChildProperty(key,child1);
                    removeFromRequired.add(key);
                } else
                    // If the two children are basically the same. We pick one.
                    if(child1.equivalentTo(child2)) {
                        child1.setExamples(mergeExamples(child1.getExamples(),child2.getExamples()));
                        property.addChildProperty(key, child1);
                    }
                    else {
                        // If the two children are made of base types, we can merge them
                        if(GenSchemaUtils.isBaseType(child1.getType()) && GenSchemaUtils.isBaseType(child2.getType()) && !child1.typeEquals(child2.getType())){
                            Set<String> newType = GenSchemaUtils.mergeTypes(child1.getType(),child2.getType());
                            child1.setType(newType);
                            child1.setExamples(GenSchemaUtils.mergeExamples(child1.getExamples(),child2.getExamples()));
                            property.addChildProperty(key,child1);
                        }else {
                            // The two children represent different scenarios, then we do an anyOf
                            Property anyOf = new Property();
                            LinkedList<Property> props = new LinkedList<>();
                            props.add(child1);
                            props.add(child2);
                            anyOf.setAnyOf(props);
                            property.addChildProperty(key, anyOf);
                        }
                    }
        }
        // Composing the required field
        property.setRequired(Sets.newHashSet(property.getPropertiesKeys()));
        property.getRequired().removeAll(removeFromRequired);
        if(!prop1.getType().equals(prop2.getType()))
            property.setType(GenSchemaUtils.mergeTypes(prop1.getType(),prop2.getType()));
        property.setExamples(GenSchemaUtils.mergeExamples(prop1.getExamples(),prop2.getExamples()));
        return property;
    }

    /**
     * Merges two "type" field values into a set
     * @param t1 type field1
     * @param t2 type field2
     * @return the merged "type" field
     */
    public static Set<String> mergeTypes(Object t1, Object t2){
        Set<String> types = new HashSet<>();
        if(t1 instanceof String)
            types.add(t1.toString());
        else
            types.addAll((Collection<? extends String>) t1);
        if(t2 instanceof String)
            types.add(t2.toString());
        else
            types.addAll((Collection<? extends String>) t2);
        return types;
    }
    /**
     * Provided a JsonSchema "type" definition (either a string or a set of types), it will
     * determine whether the type is considered a base type or not. In case of a set, if even one is not a base
     * type, false will be returned.
     * @param type a JsonSchema type, or a set of JsonSchema types
     * @return true if the provided type is a base type
     */
    public static boolean isBaseType(Object type){
        // Null is a base type
        if(type == null)
            return false;
        Set<String> types = new HashSet<>();
        //If the proposed type is a string
        if(type instanceof String)
            types.add(type.toString());
        else
            //If the proposed type is a collection of types
            types = (Set<String>) type;

        // If even one of the types is not a base type, return false
        for(String t : types)
            if(!BASE_TYPES.contains(t))
                return false;

        return true;
    }

    public static Set mergeExamples(Set examples1, Set examples2){
        Set examples = new HashSet<>();
        if(examples1 != null)
            examples.addAll(examples1);
        if(examples2 != null)
            examples.addAll(examples2);
        return examples;
    }
}
