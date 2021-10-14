package pe.joedayz.jsonschemagenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.FileUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class JsonSchemaGenerator {

    private static final Logger LOGGER = Logger.getLogger(JsonSchemaGenerator.class.getName());
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Map<String, JsonNodeType> map = new HashMap<>();

    public static String outputAsString(String title, String description, String json) throws IOException {
        return cleanup(outputAsString(title, description, json, null));
    }


    public static void outputAsFile(String title, String description,
                                    String json, String filename) throws IOException {
        FileUtils.writeStringToFile(
                new File(filename),
                cleanup(outputAsString(title, description, json)),
                "utf8");
    }

    private static String outputAsString(String title, String description,
                                         String json, JsonNodeType type) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(json);
        StringBuilder output = new StringBuilder();
        output.append("{");

        if (type == null) output.append(
                "\"title\": \"" +
                        title + "\", \"description\": \"" +
                        description + "\", \"type\": \"object\", \"properties\": {");

        for (Iterator<String> iterator = jsonNode.fieldNames(); iterator.hasNext(); ) {
            String fieldName = iterator.next();
            LOGGER.info("processing " + fieldName + "...");

            JsonNodeType nodeType = jsonNode.get(fieldName).getNodeType();

            output.append(convertNodeToStringSchemaNode(jsonNode, nodeType, fieldName));
        }

        if (type == null) output.append("}");

        output.append("}");

        LOGGER.info("generated schema = " + output.toString());
        return output.toString();
    }

    private static String convertNodeToStringSchemaNode(
            JsonNode jsonNode, JsonNodeType nodeType, String key) throws IOException {
        StringBuilder result = new StringBuilder("\"" + key + "\": { \"type\": \"");

        LOGGER.info(key + " node type " + nodeType + " with value " + jsonNode.get(key));
        JsonNode node = null;
        switch (nodeType) {
            case ARRAY:

                if (key.equals("applicationFeatures")) {

                    Map<String, Object> properties = new HashMap<>();
                    LinkedList<IfThen> ifThenStack = new LinkedList<>();

                    builtPropertiesForApplicationFeatures(jsonNode, key, result, properties, ifThenStack);

                    ObjectNode objectNode = objectMapper.createObjectNode();

                    properties.forEach((k, v) -> {
                        if (!(k.equals("format") || k.equals("value"))) {
                            objectNode.set(k, (JsonNode) v);
                        }
                    });

                    result.append(outputAsString(null, null, objectNode.toString(), JsonNodeType.ARRAY));
                    result.append(",");

                    result.append("\"allOf\": [");

                    ifThenStack.stream().forEach( (it) ->{

                        IfThen ifThen = it;

                        builtIfThenBlockForApplicationFeatures(result, ifThen);
                    });

                    int charInd = result.lastIndexOf(",");
                    if(charInd!=-1) result.deleteCharAt(charInd);

                    result.append("]}},");

                } else {
                    node = jsonNode.get(key).get(0);
                    LOGGER.info(key + " is an array with value of " + node.toString());
                    result.append("array\", \"items\": { \"properties\":");
                    result.append(outputAsString(null, null, node.toString(), JsonNodeType.ARRAY));
                    result.append("}},");
                }
                break;
            case BOOLEAN:
                result.append("boolean\" },");
                break;
            case NUMBER:
                result.append("number\" },");
                break;
            case OBJECT:
                node = jsonNode.get(key);
                result.append("object\", \"properties\": ");
                result.append(outputAsString(null, null, node.toString(), JsonNodeType.OBJECT));
                result.append("},");
                break;
            case NULL:
                result.append("null\" },");
                break;
            case STRING:
                result.append("string\" },");
                break;
        }

        return result.toString();
    }

    private static void builtPropertiesForApplicationFeatures(JsonNode jsonNode, String key, StringBuilder result, Map<String, Object> properties, LinkedList<IfThen> ifThenStack) {
        for (int i = 0; i < jsonNode.get(key).size(); i++) {

            IfThen ifThen = new IfThen();

            if (i == 0) {
                result.append("array\", \"items\": { \"properties\":");
            }


            for (Iterator<String> iterator = jsonNode.get(key).get(i).fieldNames(); iterator.hasNext(); ) {

                String fieldName = iterator.next();


                if (properties.get(fieldName) == null) {
                    JsonNode field = jsonNode.get(key).get(i).get(fieldName);
                    properties.put(fieldName, field);

                    generateIfThenAccordingDataTypeItemTypeAndName(ifThen, fieldName, field);

                } else {

                    JsonNode field = jsonNode.get(key).get(i).get(fieldName);

                    generateIfThenAccordingDataTypeItemTypeAndName(ifThen, fieldName, field);
                }


            }

            ifThenStack.addLast(ifThen);
        }
    }

    private static void builtIfThenBlockForApplicationFeatures(StringBuilder result, IfThen ifThen) {
        result.append("{");
        result.append("\"if\" : { \"properties\": {");

        String constValue = ifThen.getIfProperty().getDataType().toString();
        result.append("\"dataType\" : {");
        result.append("\"const\" : ").append(constValue).append("");
        result.append("},");

        constValue = ifThen.getIfProperty().getItemType().toString();
        result.append("\"itemType\" : {");
        result.append("\"const\" : ").append(constValue).append("");
        result.append("},");

        constValue = ifThen.getIfProperty().getName().toString();
        result.append("\"name\" : {");
        result.append("\"const\" : ").append(constValue).append("");
        result.append("}");

        result.append("}},");

        result.append("\"then\" : { \"properties\": {");

        result.append("\"format\" : { \"type\": \"object\", \"properties\": ");

        JsonNode formatThen = ifThen.getThenProperty().getFormat();

        try {
            result.append(outputAsString(null, null, formatThen.toString(), JsonNodeType.ARRAY));
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.append("}, ");

        result.append("\"value\" : { \"type\": \"object\", \"properties\": ");


        JsonNode valueThen = ifThen.getThenProperty().getValue();

        try {
            result.append(outputAsString(null, null, valueThen.toString(), JsonNodeType.ARRAY));
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.append("}}}  }," );
    }

    private static void generateIfThenAccordingDataTypeItemTypeAndName(IfThen ifThen, String fieldName, JsonNode field) {
        if (fieldName.equals("dataType")) {
            ifThen.getIfProperty().setDataType(field);
        }
        if (fieldName.equals("itemType")) {
            ifThen.getIfProperty().setItemType(field);
        }
        if (fieldName.equals("name")) {
            ifThen.getIfProperty().setName(field);
        }

        if (fieldName.equals("format")) {
            ifThen.getThenProperty().setFormat(field);
        }

        if (fieldName.equals("value")) {
            ifThen.getThenProperty().setValue(field);
        }
    }

    private static String cleanup(String dirty) {
        JSONObject rawSchema = new JSONObject(new JSONTokener(dirty));
        Schema schema = SchemaLoader.load(rawSchema);
        return schema.toString();
    }
}
