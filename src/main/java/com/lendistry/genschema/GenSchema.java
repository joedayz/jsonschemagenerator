package com.lendistry.genschema;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Will generate a simple JsonSchema based on a sample data structure. The produced schema is quite simple
 * and branches in different scenarios for each difference found in non-homogeneous arrays
 */

class ComposeProperty {

    private Property parent;

    private Map.Entry<String, Object> child;

    public Property getParent() {
        return parent;
    }

    public void setParent(Property parent) {
        this.parent = parent;
    }

    public Map.Entry<String, Object> getChild() {
        return child;
    }

    public void setChild(Map.Entry<String, Object> child) {
        this.child = child;
    }
}

public class GenSchema {


    private LinkedList<String> depthStack;

    private Queue<ComposeProperty> elementsWithStructureDifferentStack;

    /**
     * Analyzes a piece of data to generate a JSON schema
     *
     * @param data  a piece of data (maps and arrays)
     * @param id    the ID to assign to the JSON schema
     * @param title the title of the schema
     * @return the generated JSON schema
     */
    public Schema analyze(Object data, String id, String title) {

        depthStack = new LinkedList<>();

        elementsWithStructureDifferentStack = new LinkedList<>();

        Schema schema = new Schema(id, title, GenSchemaUtils.determineType(data));

        analyze(data, schema);

        return schema;

    }

    /**
     * Recursive method to bring the analysis in depth
     *
     * @param item           the item of data being analyzed
     * @param currentElement the current element that will hold the analysis result
     * @return the analyzed property
     */
    protected void analyze(Object item, Property currentElement) {

        final String type = GenSchemaUtils.determineType(item);

        switch (type) {

            case GenSchemaUtils.SCHEMA_TYPE_OBJECT: {
                currentElement.setRequired(getRequired((Map<String, Object>) item));

                for (final Map.Entry<String, Object> it : ((Map<String, Object>) item).entrySet()) {

                    final String localType = GenSchemaUtils.determineType(it.getValue());
                    final Property prop = new Property(stackToString(depthStack), localType, GenSchemaUtils.determineDefault(localType));
                    //prop.setDefaultValue(it.getValue());

                    if (it.getKey().equals("format") || it.getKey().equals("value")) {
                        ComposeProperty composeProperty = new ComposeProperty();
                        composeProperty.setParent(prop);
                        composeProperty.setChild(it);
                        elementsWithStructureDifferentStack.offer(composeProperty);
//                        depthStack.addLast("/if/properties/" + it.getKey());
                        continue;
                    } else {
                        depthStack.addLast("/properties/" + it.getKey());
                    }

                    analyze(it.getValue(), prop);
                    currentElement.addChildProperty(it.getKey(), prop);
                    depthStack.removeLast();

                }



//                if (elementsWithStructureDifferentStack.size() > 0) {
//
//
//
//                    Property dataType = currentElement.getProperty("dataType");
//                    Property newDataType = new Property();
//                    newDataType.setId("/if/properties/dataType");
//                    newDataType.setType("string");
//                    newDataType.setConstValue(dataType.getDefaultValue());
//
//                    depthStack.addLast("/if/properties/dataType");
//
//                    ComposeProperty composeProperty = elementsWithStructureDifferentStack.poll();
//                    var childAux = composeProperty.getChild();
//                    Property parentAux = composeProperty.getParent();
//
//
//                    final String localType = GenSchemaUtils.determineType(newDataType.getConstValue());
//                    final Property prop = new Property(stackToString(depthStack), localType, GenSchemaUtils.determineDefault(localType));
//                    prop.setDefaultValue(newDataType.getConstValue()x);
//
//                    analyze(newDataType, currentElement);
//                    currentElement.addChildProperty("dataType", currentElement);
//                    depthStack.removeLast();
//
//
//                }



                break;
            }
            case GenSchemaUtils.SCHEMA_TYPE_ARRAY: {
                List<Property> collectedItems = new LinkedList<>();
                int cnt = 0;

                // First, catalog all items a unique property
                for (final Object localItem : (List) item) {
                    final String localType = GenSchemaUtils.determineType(localItem);
                    depthStack.addLast("/items_" + cnt);
                    final Property prop = new Property(stackToString(depthStack), localType, GenSchemaUtils.determineDefault(localType));
                    analyze(localItem, prop);
                    collectedItems.add(prop);
                    depthStack.removeLast();
                    cnt++;
                }


                // Empty array
                if (collectedItems.size() == 0)
                    return;
                // Identify which properties are equivalent
                List<Property> cont = detectDifferentProps(collectedItems);

                // If only one scenario arises, set it as the "items" property
                if (cont.size() == 1) {




                }
                else {

                    //TODO union of properties in only one
                    //If multiple scenario arise, we add them to the "anyOf" property
                    final Property anyOf = new Property();
                    anyOf.setId(stackToString(depthStack) + "/anyOf");
                    anyOf.setAnyOf(cont);

                    Map<String, Property> itemsAux = cont.get(0).getProperties();

                    String key = itemsAux.keySet().toArray()[0].toString();
                    Property value = itemsAux.get(key);

                    Property propertyPadre = new Property();
                    propertyPadre.setId(cont.get(0).getId());
                    propertyPadre.setType(cont.get(0).getType());
                    propertyPadre.setRequired(cont.get(0).getRequired());
                    propertyPadre.addChildProperty(key, value);


                    currentElement.setItems(propertyPadre);


                    System.out.println(currentElement);

//                    Property ifChild = new Property();
//                    ifChild.setId("#/if/applicationFeatures/items_0");
//                    ifChild.setType(null);
//                    Property propIf = new Property();
//                    propIf.setConstValue("grantDemografic");
//                    ifChild.addChildProperty("dataType", propIf);

                }
                break;
            }
            default:
                currentElement.setExamples(Sets.newHashSet(item));
        }

    }

    private void analyzeValue(Object value, Property currentElement) {

    }

    private void analyzeFormat(Object value, Property currentElement) {
//        final String localType = GenSchemaUtils.determineType(value);
//        final Property prop = new Property(stackToString(depthStack), localType, GenSchemaUtils.determineDefault(localType));
//        analyze(value, prop);
//        Property formatProperty = new Property("format", localType, null);
//        IfCondition ifCondition = new IfCondition();
//        ifCondition.setProperties(
//                Map.of(
//                        "itemType",
//                        currentElement.getProperties().get("itemType"),
//                        "dataType",
//                        currentElement.getProperties().get("dataType"),
//                        "name",
//                        currentElement.getProperties().get("name")
//                )
//        );
//        currentElement.addChildProperty("format", formatProperty);
    }

    /**
     * Give a list of properties, detect which ones are equivalent
     *
     * @param props a list of properties
     * @return a list of the essential properties
     */
    public static List<Property> detectDifferentProps(List<Property> props) {
        List<Property> propertyTypes = Lists.newArrayList(props.get(0));
        /*
         * For each item of the props, if the current prop is not equivalent to a prop
         * previously collected, add it to the collected props
         */
        for (final Property currentItem : props) {
            boolean compareSuccess = false;
            for (Property savedItem : propertyTypes) {
                if (currentItem.equivalentTo(savedItem)) {
                    compareSuccess = true;
                    // if it's a base type
                    if (GenSchemaUtils.isBaseType(currentItem.getType()))
                        // add the examples to the collected ones
                        savedItem.addExamples(currentItem.getExamples());
                    else
                        // otherwise find which requirements are shared
                        savedItem.intersectRequires(currentItem.getRequired());
                }
            } // if no similar item
            if (!compareSuccess)
                propertyTypes.add(currentItem);
        }
        return propertyTypes;
    }

    /**
     * Transform a depthStack list to a string to be used as a property ID
     *
     * @param depthStack a depthStack list
     * @return the generated ID
     */
    protected static String stackToString(LinkedList<String> depthStack) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        depthStack.forEach(sb::append);

        return sb.toString();
    }

    /**
     * Given a data object, collect all the keys to be used as a "required" field
     *
     * @param values the data object
     * @return the keys
     */
    protected static Set<String> getRequired(Map<String, Object> values) {

        // TODO: Add required from required property for applicationFeatures. E.g.
        // `itemType: CompanyProperty` has a `required: true`
        return values.entrySet().stream().filter(item -> item.getValue() != null).map(Map.Entry::getKey).collect(Collectors.toSet());
    }
}
