package com.lendistry.genschema;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.io.IOException;

/**
 * The JSON schema
 */
public class Schema extends Property{

    private String title;

    @JsonProperty("$schema")
    private final String schema = "http://json-schema.org/draft-07/schema#";

    public Schema(){
        super();
    }

    /**
     * Default constructor
     * @param id the id of the schema
     * @param title the title of the schema
     * @param type the type of the root object
     */
    public Schema(String id, String title,String type){
        this.setId(id);
        this.title = title;
        this.setType(type);
    }

    /**
     * Creates a schema from a JSON string
     * @param schemaString a JSON string representing a JsonSchema
     * @return a Schema
     * @throws IOException
     */
    public static Schema create(String schemaString) throws IOException {
        return GenSchemaUtils.deserializeSchema(schemaString);
    }

    /**
     * Creates a schema froma JSON file
     * @param schema a file containing JSON representing a JsonSchema
     * @return a Schema
     * @throws IOException
     */
    public static Schema create(File schema) throws IOException {
        return GenSchemaUtils.deserializeSchema(schema);
    }
}
