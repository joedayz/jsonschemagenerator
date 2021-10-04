import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.junit.Test;
import pe.joedayz.jsonschemagenerator.JsonSchemaGenerator;

public class JsonSchemaGeneratorTest {


    @Test
    public void shouldGenerateSchemaUsingSimpleObject() throws Exception {
        String json = "{\"meeting\":{\"hour\":17,\"minute\":15}}";
        String result = JsonSchemaGenerator.outputAsString("Schedule", "Test", json);
        Assert.assertTrue(isValid(json, result));
    }

    @Test
    public void shouldGenerateSchemaUsingArrayOfObjects() throws Exception {
        String json = "{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]}";
        String result = JsonSchemaGenerator.outputAsString("Schedule", "Test",json);
        Assert.assertTrue(isValid(json, result));
    }

    @Test
    public void shouldGenerateAValidSchema() throws Exception {
        String json = "{\"name\": " + "\"Vyom Srivastava\", \"website\": \"geekyhumans.com\", \"address\": { \"city\": \"New York\",\"country\": \"USA\"}}";
        String result = JsonSchemaGenerator.outputAsString("Schedule", "Test",json);
        Assert.assertTrue(isValid(json, result));
    }

    private boolean isValid(String json, String result) {
        boolean isValid = true;

        JSONObject rawSchema = new JSONObject(new JSONTokener(result));
        Schema schema = SchemaLoader.load(rawSchema);

        try {
            schema.validate(new JSONObject(json));
        }
        catch (ValidationException e) {
            isValid = false;
        }

        return isValid;
    }
}
