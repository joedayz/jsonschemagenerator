package pe.joedayz.jsonschemagenerator;

import com.fasterxml.jackson.databind.JsonNode;

public class ThenProperty {

    JsonNode format;
    JsonNode value;

    public JsonNode getFormat() {
        return format;
    }

    public void setFormat(JsonNode format) {
        this.format = format;
    }

    public JsonNode getValue() {
        return value;
    }

    public void setValue(JsonNode value) {
        this.value = value;
    }
}
