package com.lendistry.genschema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * The JsonSchema property
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Property implements Cloneable{

    @JsonProperty("$id")
    private String id;

    private Object type;

    private Object defaultValue;

    private Set<Object> examples;

    private List<Property> anyOf;

    private Set<String> required;

    private Map<String,Property> properties;

    private Property items;

    public Property(){
        id = UUID.randomUUID().toString();
    }

    /**
     * Default constructor
     * @param id the ID of the property
     * @param type the type of the object
     * @param defaultValue its default value
     */
    public Property(String id, Object type, Object defaultValue){
        this.id = id;
        this.type = type;
        this.defaultValue = defaultValue;
        setExamples(new HashSet<>());
        if( this.defaultValue != null )
            getExamples().add(this.defaultValue);
    }

    /**
     * Inits the properties map if necessary, and returns it
     * @return the properties map
     */
    private Map<String,Property> initAndGetProperties(){
        if(properties == null)
            properties = new HashMap<>();
        return getProperties();
    }

    /**
     * Adds a child property
     * @param key the key of the property
     * @param property the property
     */
    public void addChildProperty(String key, Property property) {
        initAndGetProperties().put(key, property);
    }

    /**
     * his method does not really represent equality, but a sufficient similarity
     * @param obj the object to compare to
     * @return true if the two objects are similar
     */
    public boolean equivalentTo(Object obj){
        if(obj instanceof Property) {
            Property otherProp = (Property) obj;

            // This happens when we are comparing anyOf properties
            if(this.type == null && otherProp.type == null)
                return true;

            //If types are equal or compatible...
            if(this.typeEquals(otherProp.type)){
                if(this.hasProperties() && otherProp.hasProperties()){
                    // If the names of the child properties are the same...
                    if(this.getPropertiesKeys().equals(otherProp.getPropertiesKeys())){
                        // For each property name...
                        for(final String key : this.getPropertiesKeys()){
                            /*
                             * If the child property from the current object and the proposed object are
                             * not similar, then we can pretty much accept the two objects are not similar
                             */
                            if(!this.getProperty(key).equivalentTo(otherProp.getProperty(key)))
                                return false;
                        }
                        // If the child properties names are not the same
                    } else return false;
                }
                // If the current object and the proposed object have the "items" field
                if(this.hasItems() && otherProp.hasItems()){
                    // ... we verify whether the "items" fields are similar
                    return this.getItems().equivalentTo(otherProp.getItems());
                }
                // If the types are equal, but any other scenario does not trigger, we assume they are similar
                return true;
            }
        }
        // In any other case
        return false;
    }



    /**
     * @return True if the items object is not null
     */
    public boolean hasItems(){
        return items != null;
    }

    public Property getProperty(String key){
        if(hasProperties())
            return getProperties().get(key);
        return null;
    }

    /**
     * @return the keys of all child properties
     */
    @JsonIgnore
    public Set<String> getPropertiesKeys(){
        if(hasProperties())
            return getProperties().keySet();
        else
            return new HashSet<>();
    }

    /**
     * @return true if the properties map is not null and has items in it
     */
    public boolean hasProperties(){
        return properties != null && properties.size() > 0;
    }

    /**
     * Verifies whether the proposed type is equal to the type property, or is present in the type collection
     * @param type the type to verify
     * @return true when the proposed type is equal to the type property, or is present in the type collection
     */
    public boolean typeEquals(Object type){
        /*
         * When the current type is null and the incoming type isn't, they are certainly different.
         */
        if(this.type == null && type != null)
            return false;

        // Both single types, straight comparison
        if(isSingleType() && type instanceof String)
            return this.type.equals(type);
        else
            // Current isn't single type, but the other is. Check whether the provided type is in the current list
            if(!isSingleType() && type instanceof  String)
                return this.getTypeAsSet().contains(type);
            else
                // Comparing the two lists
                return this.type.equals(type);
    }

    /**
     * @return the type as a string
     */
    @JsonIgnore
    public Set<String> getTypeAsSet(){
        return (Set<String>) type;
    }
    /**
     * @return true if the type is actually a single string
     */
    @JsonIgnore
    public boolean isSingleType(){
        return type == null || type instanceof String;
    }

    public Set getExamples(){
        return examples;
    }

    public void setExamples(Set<Object> examples){
        this.examples = examples;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(Object type) {
        this.type = type;
    }


    public Map<String,Property> getProperties(){
        return properties;
    }

    public void setProperties(Map<String,Property> properties){
        this.properties = properties;
    }


    public Property getItems(){
        return items;
    }

    public int hashCode(){
        return id.hashCode();
    }

    public Property clone(){
        Property property = new Property(this.id,this.type,this.defaultValue);
        if(items != null)
            property.items = this.items.clone();
        if(properties != null)
            properties.entrySet().forEach( entry -> property.addChildProperty(entry.getKey(),entry.getValue().clone()));
        return property;
    }

}
