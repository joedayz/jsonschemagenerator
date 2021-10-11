package com.lendistry.genschema;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SampleTests {

    @Test
    public void testValidationSamples() throws Exception {
        File[] files = new File("samples").listFiles((dir, name) -> name.endsWith(".json"));
        for(File f : files) {
            runTest(f);
        }
    }

    private void runTest(File f) throws IOException {
        Object data = GenSchemaUtils.deserializeJsonPayload(f);
        GenSchema genSchema = new GenSchema();
        Schema generatedSchema = genSchema.analyze(data,"foo","bar");

        org.everit.json.schema.Schema schema = SchemaLoader.load(new JSONObject(GenSchemaUtils.serializeJsonPayload(generatedSchema)));
        String text = GenSchemaUtils.load(f);
        System.out.println(f.getName());




    }
}
