package com.lendistry.genschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class GenSchemaUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

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
}
