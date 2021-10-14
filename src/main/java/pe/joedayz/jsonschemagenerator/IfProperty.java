package pe.joedayz.jsonschemagenerator;

import com.fasterxml.jackson.databind.JsonNode;

public class IfProperty {

    JsonNode dataType;
    JsonNode itemType;
    JsonNode name;

    public JsonNode getDataType() {
        return dataType;
    }

    public void setDataType(JsonNode dataType) {
        this.dataType = dataType;
    }

    public JsonNode getItemType() {
        return itemType;
    }

    public void setItemType(JsonNode itemType) {
        this.itemType = itemType;
    }

    public JsonNode getName() {
        return name;
    }

    public void setName(JsonNode name) {
        this.name = name;
    }
}
