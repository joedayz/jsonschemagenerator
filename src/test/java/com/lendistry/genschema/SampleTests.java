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
        for (File f : files) {
            runTest(f);
        }
    }


    @Test
    public void testRealWorld() throws Exception {
        File[] files = new File("samples" + File.separator + "lendistry").listFiles((dir, name) -> name.endsWith(".json"));
        for (File f : files) {
            runTest(f);
        }
    }

    private void runTest(File f) throws IOException {
        Object data = GenSchemaUtils.deserializeJsonPayload(f);
        GenSchema genSchema = new GenSchema();
        Schema generatedSchema = genSchema.analyze(data, "foo", "bar");

        String serializeJsonPayload = GenSchemaUtils.serializeJsonPayload(generatedSchema);

//        serializeJsonPayload = serializeJsonPayload.replaceAll("ifProperty", "if");
//        serializeJsonPayload = serializeJsonPayload.replaceAll("constValue", "const");

        org.everit.json.schema.Schema schema = SchemaLoader.load(new JSONObject(serializeJsonPayload));

        String text = GenSchemaUtils.load(f);
        System.out.println(f.getName());

//        if(text.startsWith("{"))
//            schema.validate(new JSONObject(text));
//        else
//            schema.validate(new JSONArray(text));

//        GenSchemaSimplifier simplifier = new GenSchemaSimplifier();
//        generatedSchema = simplifier.analyze(generatedSchema);
//        schema = SchemaLoader.load(new JSONObject(GenSchemaUtils.serializeJsonPayload(generatedSchema)));
//        if(text.startsWith("{"))
//            schema.validate(new JSONObject(text));
//        else
//            schema.validate(new JSONArray(text));

        System.out.println(schema.toString());
    }

    private void runTest2(File f) throws IOException {
        //Object data = GenSchemaUtils.deserializeJsonPayload(f);
        //GenSchema genSchema = new GenSchema();
        //Schema generatedSchema = genSchema.analyze(data, "foo", "bar");


        Schema schema = GenSchemaUtils.deserializeSchema("{\n" +
                "\t\"type\": \"object\",\n" +
                "\t\"required\": [\"partnerStatus\", \"updateDate\", \"updatedBy\", \"propertySequence\", \"version\", \"createdDate\", \"applicationFeatures\", \"createdBy\", \"sectionSequence\", \"tenantId\", \"id\", \"validations\", \"applicationId\", \"loanProductId\", \"status\"],\n" +
                "\t\"properties\": {\n" +
                "\t\t\"partnerStatus\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"c5b817cb-7886-424d-9cee-e69606c2bd85\"\n" +
                "\t\t},\n" +
                "\t\t\"updateDate\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"fd9f11a2-83ed-4191-8f79-6e6796d7690b\"\n" +
                "\t\t},\n" +
                "\t\t\"comments\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"29da8cff-2010-4a3d-8f98-f4c31f656e7a\"\n" +
                "\t\t},\n" +
                "\t\t\"updatedBy\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"69a24b50-788e-4eb3-8ba0-bd35b9d70b31\"\n" +
                "\t\t},\n" +
                "\t\t\"endDate\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"2ea71fbb-63ed-4ab9-ba85-2e3a16f6799f\"\n" +
                "\t\t},\n" +
                "\t\t\"updateReason\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"3faaf78c-47da-46a3-9090-a949e3be4e99\"\n" +
                "\t\t},\n" +
                "\t\t\"propertySequence\": {\n" +
                "\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\"items\": {\n" +
                "\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\"$id\": \"24bb4c07-2113-4485-92c1-108b82448e58\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"a52702f9-9d57-495f-a5f9-b1955538bb92\"\n" +
                "\t\t},\n" +
                "\t\t\"version\": {\n" +
                "\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"59fce75b-7e37-4e47-9dcf-fb29521922fd\"\n" +
                "\t\t},\n" +
                "\t\t\"assignedTo\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"ac472d9d-3d6b-4f25-be5b-b89e0b8c8faa\"\n" +
                "\t\t},\n" +
                "\t\t\"abandonDuration\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"a6874ee7-c181-4ced-87d4-50f4f93495ae\"\n" +
                "\t\t},\n" +
                "\t\t\"createdDate\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"7ffa763f-826f-4bc0-a246-559e4e5ab5b1\"\n" +
                "\t\t},\n" +
                "\t\t\"applicationFeatures\": {\n" +
                "\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\"items\": {\n" +
                "\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\"required\": [\"valueValidated\", \"itemType\", \"dataType\", \"format\", \"encryptionRequired\", \"section\", \"title\", \"required\", \"valid\", \"encrypted\", \"subTitle\", \"validated\", \"demoLink\", \"requiredValidated\", \"name\", \"value\"],\n" +
                "\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\"displayProperties\": {\n" +
                "\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"9f3f1ecb-26e3-4988-be99-7099af48bce8\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"allOf\": [{\n" +
                "\t\t\t\t\t\"ifProperty\": {\n" +
                "\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\"dataType\": {\n" +
                "\t\t\t\t\t\t\t\t\"constValue\": \"grantDemographic\",\n" +
                "\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\"$id\": \"bb24a331-426b-49af-ab66-c865aeef86a4\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"itemType\": {\n" +
                "\t\t\t\t\t\t\t\t\"constValue\": \"FormDataProperty\",\n" +
                "\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\"$id\": \"73907715-0397-4e55-9206-7c7cfbbe225e\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"name\": {\n" +
                "\t\t\t\t\t\t\t\t\"constValue\": \"demographic\",\n" +
                "\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\"$id\": \"14135af8-ef8f-4e54-8c43-66aa38ce8fc3\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"9fd73f6e-a9e5-4ec1-b345-c712b82fbcff\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"thenProperty\": {\n" +
                "\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\"format\": {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\"required\": [\"moreAboutBusiness\", \"ethnicity\", \"race\", \"isRural\", \"whatBusinessDo\", \"isWomenOwned\", \"isDisabledOwned\", \"isVeteranOwned\", \"typeOfBusiness\", \"naics\", \"businessBase\", \"isFranchise\"],\n" +
                "\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"businessBase\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Who is your customer base?\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Who is your customer base?\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c1d33595-aafc-4495-a92e-f35c4fe76b8a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 80,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [80],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"87bf3d83-72c8-4b6a-8797-0222267b69e7\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [1],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"437b5978-9931-4f59-a863-6dfeb3e344db\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ad8b0ac4-132b-449c-90d0-a90377ec31ef\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"7000a73c-bdb5-46db-a96e-4514805fa0c8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"B2B\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"B2B\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"1705789c-602d-4c3b-85b4-c36c076cd36a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"B2B\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"B2B\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"f6c1abf7-8826-4e82-ba6d-1e71ae0d8d28\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"da50499d-52a0-4750-a41c-900f594eb613\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"600dc515-475a-44cf-ac1d-810302575d44\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [1],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"5c5a1b42-5f86-460e-a915-b438990fc4c5\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"B2B (Business to Business) | B2C (Business to Customer)\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"B2B (Business to Business) | B2C (Business to Customer)\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"01aa9b29-4e43-4b40-a895-fa69acc110ae\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4c3ac432-903c-48e6-a66e-d671e000ac06\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"a7fe09a4-8e24-41fc-a91c-fc904daf3abd\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"ethnicity\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Ethnicity\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Ethnicity\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e59cecc6-b09d-49c3-90a3-dfa157394f1c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 25,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [25],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"60f08ab8-9d63-4580-92ac-a5be1d2f790b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"3c7bde1b-c8cc-4aca-b234-8333f4c40dea\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c0571fc8-d805-4bec-b909-8be3f64a4d69\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"36ca9172-ad40-431e-98d3-a72bba12b496\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Hispanic or Latino\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Hispanic or Latino\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e1fb4368-a02b-45fe-b1a8-82549768b8bd\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Hispanic or Latino\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Hispanic or Latino\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0c07d11a-060a-4ceb-9a7b-fa27ed5dfce3\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4a6ea6e9-ab5d-4e0c-a23c-794cfba494fe\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e840fb59-7a9f-4866-b845-189a809ec69e\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 9,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [9],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"424a81d3-182d-4274-818b-88219e889714\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Provide information for the majority owner of the business or the primary owner.\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Provide information for the majority owner of the business or the primary owner.\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c38943ae-f740-4223-90d9-7317783a7ac4\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ae359125-67c2-4c60-9b9b-e19a7b21fd3d\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"65d18d16-e560-4f1f-9a83-1113659e10b9\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isDisabledOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Disabled Owned\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Disabled Owned\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"dcfbeceb-f121-4f2a-ab05-5e5b988f8d10\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"d28162a1-a56b-43a4-ac27-d1d0968d6891\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"1096abb4-d0b2-4850-abbb-30ad47ceae4a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"5ac82d5a-c856-40e0-b6c7-2445ef44c6f7\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c296910e-626f-43b2-9be5-db06095c5000\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"d8912751-c986-4d80-8645-68ba362a4b81\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"161bbba4-0c61-4682-8c9f-d91fc73f794c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e147856e-1cd0-4dbb-b5d9-396325f1cd2b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"d8746a14-2168-4298-98bf-a26c67d8a2ce\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 8,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [8],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"b62fb050-4d49-4142-99e3-7e64e8909962\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Individuals directly own and control more than 50% of the business.\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Individuals directly own and control more than 50% of the business.\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"314a4840-1f64-4d0a-8886-0b619cd1959f\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ef14e628-b19a-4109-9a42-da42544c031c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"2748b702-10fb-4699-bac8-29fee72265a5\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isFranchise\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Franchise\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Franchise\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"498dd4c7-60fb-4f5f-af1b-5091f9f1c58c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"babad1a2-5363-42c7-8a91-66cedb190a01\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4315ada5-8685-452f-9079-ef6c6dd227b8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"af0dd4bd-5484-4ec9-baf5-ab3130221ba7\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"42b34198-1910-4a04-a3d3-105c68b9eb81\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"9a006c3a-23ee-4d93-ba2a-36db312a92bc\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"cce2a3e1-973b-4e0d-9c88-244be450f2b2\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"1a08b7a3-b621-46c8-8778-8161454641db\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"50fdfb4e-bf42-4c86-8f4a-30d648da9517\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 10,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [10],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"af70db40-05ab-43e8-9598-10568f9ac343\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e7a70d55-0b71-4493-b246-96b5a9025f89\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"9cf9f414-731e-4853-bed5-fd3614319293\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isRural\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Rural\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Rural\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"1ce26775-ff22-4449-a41a-1d00a6bc5efd\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e19c6c55-8464-4399-8d91-7ecbb101eed7\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"61687655-dca7-4e54-a087-dba21b1acd96\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0ecdb710-b8db-4993-9e61-c5dc6213e674\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ce64f8d0-3383-4959-8684-9d9c319124a0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e0547365-450a-4a68-a09b-e31103b2306e\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"82c2aa0a-de80-4bcd-9f13-366dcc678c5a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"b41bf1d7-1db1-4f48-ae91-34ca281a07b9\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"9a5ee8a2-cab4-4eaf-88c9-e0df5e991652\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 11,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [11],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e6342e31-1181-459d-8bdf-6eb4c222f85e\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"bbd46d4b-bb12-4991-8743-333e67427ba2\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"71a03cad-82f0-47da-9900-92d36947f40e\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isVeteranOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Veteran Owned\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Veteran Owned\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"2f3b88a3-7f2c-404c-823c-97720e8c5936\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"f9d1ca3f-1180-487d-9a02-cf52b81da249\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"49af5d42-3935-4fd8-97fc-eacc00a7f47c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"eed437fe-2252-4dfc-b157-52f5fbf0574d\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c2ae04f4-677c-4e94-8840-8629ea0456fe\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"71a434cc-f148-468f-a29a-ffe5dec0c818\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"40533626-f0ce-42a1-8448-ea23b3540301\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8a58879a-5a14-4099-84b6-d54611af8b1f\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c4d26595-fb05-4625-9b79-b9076f77a5d5\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 7,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [7],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"2061ef1a-af01-43d3-ae99-228a5ab3deb3\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Greater than 50% of the business is owned by Veteran(s).\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Greater than 50% of the business is owned by Veteran(s).\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e7ec5014-21bc-49f1-9d65-5a6dbe8d063a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"6018b93a-79ce-4f17-9217-3760b3641421\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"56748a76-65de-456e-a2a9-7c99fdf190b5\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isWomenOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Women Owned\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Women Owned\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"5be5e3f9-e18b-4af9-a360-a860785bbc98\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"6cb7f4e9-6628-4738-9172-8c40af5f3c41\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"eab5244a-a6a7-4136-9ac9-4892714c8251\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c07e20f1-69be-4e31-a794-405bc6a733a3\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"744b7b47-058a-4d86-9f69-78744b98b769\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4634e0bd-05ed-4531-972d-169c7264bae1\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"7dddb3ca-46cc-4b1c-b64f-4e4539fa9d77\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"d9e5ba8c-5f89-4683-804c-bf221944d412\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"bad7f2f6-1878-4ff8-9221-de49b3def3ba\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 6,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [6],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ffa3030d-8313-4a69-baa2-066e257527f8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Greater than 50% of the business is owned by a Woman (Women).\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Greater than 50% of the business is owned by a Woman (Women).\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"585d6e8f-2f8b-437e-8a5a-64a65d1c392b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"93fb04bc-8f5f-4515-8cac-b9c112da5804\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"cf8f4b2e-131c-4f37-bd6f-75e2fc4d4257\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"moreAboutBusiness\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"options\", \"label\", \"type\", \"limits\", \"linked\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Tell us more.\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Tell us more.\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"650f9b3d-e1f3-4d5b-9e21-b791e17d90fd\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 80,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [80],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4c461c28-0180-4701-9c69-b7f9bcc433a1\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [1],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"05524748-e02f-4651-b529-9d8ed5341d56\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0bed3682-22fd-44e4-9309-f6fd7bee991d\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"linked\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"typeOfBusiness\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"typeOfBusiness\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"f113fc35-5c19-42f5-a016-dd2ec2aca7d9\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"General Contractor\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"General Contractor\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c899940e-569f-43c2-a51c-3afc7aa8ece7\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Industrial/Warehouse\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Industrial/Warehouse\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"5de6d3a8-9f5f-4e8c-ad81-bbc50c0b474b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Industrial/Warehouse\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Industrial/Warehouse\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"574d081a-d397-4c4f-9e13-38d6b8d1fba0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8373eaf2-fd3c-4aff-930f-b811ce68d78c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"06114ddf-9463-464f-99ae-865824ef3b81\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [4],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"9131bc2a-d941-4d58-a404-41761ce9c8be\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8a519460-9813-4190-ad86-bcded75b406a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"f976ee8a-cc3b-4cc6-a80a-e2cf577aae03\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"naics\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"externalReference\", \"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"externalReference\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"<a href=\\\"https://www.naics.com\\\" target=\\\"_blank\\\">Click</a> here to find your NAICS code\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"<a href=\\\"https://www.naics.com\\\" target=\\\"_blank\\\">Click</a> here to find your NAICS code\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"bfc976e0-8a50-4db3-b699-fb66db2c6dd8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"NAICS code\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"NAICS code\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"db969882-59a4-45e0-be3e-4343382120e3\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 6,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [6],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"c874b7f4-0caa-4b8a-9a38-d65fdcec06df\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8a239b05-116f-43b6-ba98-056607a87586\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"5993d710-f66d-4124-a166-de19f2b6fac8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ea18abed-d7d0-49e0-8ee4-cd945ffbb3a2\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"711120 - Dance Companies\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"711120 - Dance Companies\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0bcb2f23-27f6-4389-80eb-3fefe412d279\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"711120\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"711120\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"1f9a6458-4767-4df1-b731-49a496abd6f2\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"dece7445-f093-467c-b98c-a3a6bf89645b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"e99da7ff-99bd-4b42-a4ea-409bc8a4cc0e\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 5,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [5],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8037c5f5-b7d3-45cb-8586-74de06a9094b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"The NAICS Code System is used by Federal Statistical Agencies to collect, analyze, and publish statistical data related to the U.S. Economy.<br /> NAICS is a Self-Assigned System; no one assigns you a NAICS Code.<br />  What this means is a company selects the code that best depicts their primary business activity and then uses it when asked for their code.\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"The NAICS Code System is used by Federal Statistical Agencies to collect, analyze, and publish statistical data related to the U.S. Economy.<br /> NAICS is a Self-Assigned System; no one assigns you a NAICS Code.<br />  What this means is a company selects the code that best depicts their primary business activity and then uses it when asked for their code.\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"35d63808-4ad7-4368-ab8f-b913929e23ef\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"b866e600-9a28-4b4f-8b30-732ce701c752\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"9d242091-99cc-43c5-bf76-56042d1b8323\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"race\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"tooltipText\", \"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Race\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Race\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"28ac277e-86e5-46e7-8f80-baaa72812d0c\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 25,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [25],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"a255bc43-6875-4567-8e0d-668d64dfd19f\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"f4c570f0-1f10-4a63-ac9a-34c6fcab7fd0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"12e1648e-1e7c-45a2-ba24-4d2bee921d7b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"cfd31c96-72d6-48ef-b4e0-e58db59f9b48\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"African American\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"African American\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"940cfa78-9189-4596-804f-46369484de72\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"African American\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"African American\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"4d27cdf0-1596-471c-83a6-a6073b1a9250\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"90c40b64-3314-4992-b00e-87373cb8bf52\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0f1924aa-5d92-416f-b847-f87ee46b58b6\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 9,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [9],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"7b857df7-0c52-4d8a-84e2-454ab0d93de5\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"tooltipText\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Provide information for the majority owner of the business or the primary owner.\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Provide information for the majority owner of the business or the primary owner.\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"fda1f3e0-d472-41af-95fd-3177d8019fd4\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"646ad349-26c1-46a3-9ad0-770b74ffba77\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"acea4cc2-2a35-49c5-a040-ce2a1a637e39\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"typeOfBusiness\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"options\", \"label\", \"type\", \"limits\", \"linked\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"What type of business is it?\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"What type of business is it?\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"fc3d73e3-469c-46d3-934a-cfd398d7ed31\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 80,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [80],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"2eb9ef46-c752-4040-878d-171b673cef38\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [1],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"521bcbc8-59c1-47f0-847c-43dabaebe82f\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"fdffad6c-b4f1-49a5-86ad-9e1db398b89a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"linked\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"whatBusinessDo\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"whatBusinessDo\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"0d420069-a998-4046-ab84-c788ebe73519\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Construction Business\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Construction Business\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"91c31a8a-7e72-4809-b99a-20cab8c50459\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"General Contractor\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"General Contractor\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"31c250f0-488e-4e7f-9549-410bd44e3f15\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"General Contractor\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"General Contractor\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"8b4ffb49-1f97-4ccf-8bf7-faed0cbfe0e5\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"44322870-3e9b-49fd-9187-9d138e23f5a8\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"2836f608-f404-4ebe-bac3-6168664b1263\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 3,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [3],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"7e5ec8c1-4ad1-4919-bf9f-e17c4760350e\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"512d7399-df14-4e3d-9e2a-8a914ad6dc2f\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"c1554822-5ba9-40ec-a5aa-4ed5eda0b1c3\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"whatBusinessDo\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"required\": [\"options\", \"label\", \"type\", \"limits\", \"order\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"What does your business do?\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"What does your business do?\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"491cf256-95a5-40a7-94c3-0280b7b61eee\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"limits\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"maximum\", \"minimum\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"maximum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 80,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [80],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"19c1bb6a-cea0-4f38-8fa4-c53a5fd5b506\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"minimum\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [1],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"3dd757e6-4bf5-4149-a0a1-8d22cd5b9d76\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"b470d3ee-c907-48a8-865e-9ba743e88b06\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"items\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"required\": [\"displayForValue\", \"label\", \"value\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"displayForValue\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"b44ec430-1c81-4b9a-8289-d982b6afe6b6\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Construction Business\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Construction Business\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"febb357f-37ea-4626-8129-24c6bd6f45d2\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Construction Business\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Construction Business\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"df43d63c-9bfb-45cf-9cb2-7866ca889ad9\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"ae999ee0-69d2-4174-809b-42bb996ed0fb\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"21b53a6f-c2aa-4a7e-8ac3-fa946c43b6a0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"order\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": 2,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [2],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"56a76750-d75f-4312-84e4-46ba7cc0735a\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"selectOne\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"examples\": [\"selectOne\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"$id\": \"a814bee0-d180-48ef-9d95-1c5207387d3d\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"99f0a6da-bd14-4963-ab45-b4488a0d52d3\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"additionalProperties\": true,\n" +
                "\t\t\t\t\t\t\t\t\"$id\": \"461bcd6d-f2ee-47e6-84e1-94e5a0327f2d\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"value\": {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\t\t\t\t\"required\": [\"moreAboutBusiness\", \"ethnicity\", \"race\", \"isRural\", \"whatBusinessDo\", \"isWomenOwned\", \"isDisabledOwned\", \"isVeteranOwned\", \"typeOfBusiness\", \"naics\", \"businessBase\", \"isFranchise\"],\n" +
                "\t\t\t\t\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"businessBase\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"B2B\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"B2B\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"a0a165f0-5616-4aaa-b488-870a3dd4617e\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"ethnicity\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Hispanic or Latino\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Hispanic or Latino\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"644602b0-3e26-4a22-846c-ca1d3b03c8e5\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isDisabledOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"7a20f1c9-8aa0-4005-b67c-f782087a6ca7\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isFranchise\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"7967c153-3496-482b-8ed3-1ef0a8e4e662\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isRural\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"ae7da9a7-2d4b-449f-88cb-d034e62dc4e9\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isVeteranOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"f82c560a-89d1-4017-be5f-4fe66edecc90\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"isWomenOwned\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Yes\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Yes\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"860fed50-eaf8-49eb-aa20-973dcb889661\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"moreAboutBusiness\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Industrial/Warehouse\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Industrial/Warehouse\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"52db21c3-b8c9-4a15-9788-b3bcd1cb0c84\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"naics\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"711120\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"711120\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"0bec1efb-ce15-4715-bfb3-0aeeac6c5212\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"race\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"African American\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"African American\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"62f3a784-6c7f-489a-a152-e5bc49759cbf\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"typeOfBusiness\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"General Contractor\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"General Contractor\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"d64090eb-c3d3-4558-829b-258c8c6a7cc6\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"whatBusinessDo\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"defaultValue\": \"Construction Business\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"examples\": [\"Construction Business\"],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"$id\": \"918eee92-f79f-48b6-8e21-0ce49cdd307f\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\t\t\"$id\": \"4a76e2d4-328a-460b-96f8-6377c5e64a80\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"6d076502-f6dd-4b4d-9511-12000d933684\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\"$id\": \"c18dd27c-5171-4fda-abce-052c1abcf984\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\"$id\": \"445da823-5187-4d0a-8fde-a78b71bade39\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"07af10b6-cf9d-41ff-b0a7-93ccd5c4f5ec\"\n" +
                "\t\t},\n" +
                "\t\t\"createdBy\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"0b637415-add2-4cef-a47a-ca203880ed83\"\n" +
                "\t\t},\n" +
                "\t\t\"sectionSequence\": {\n" +
                "\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\"items\": {\n" +
                "\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\"$id\": \"91f2b93c-5491-424c-b0c3-851daf04bfb8\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"37e1abd0-aafc-4d36-a55a-825c6aa8f008\"\n" +
                "\t\t},\n" +
                "\t\t\"tenantId\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"01ec4855-19c3-4668-bf4f-e627ce8864f3\"\n" +
                "\t\t},\n" +
                "\t\t\"id\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"0e129b66-ef9b-4cb9-95e4-83bb0719d81f\"\n" +
                "\t\t},\n" +
                "\t\t\"validations\": {\n" +
                "\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\"items\": {\n" +
                "\t\t\t\t\"type\": \"object\",\n" +
                "\t\t\t\t\"required\": [\"validated\", \"name\"],\n" +
                "\t\t\t\t\"properties\": {\n" +
                "\t\t\t\t\t\"allowedStateTransitions\": {\n" +
                "\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"80b0c0bb-a1ce-4345-856f-fc3f91a81f46\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"validated\": {\n" +
                "\t\t\t\t\t\t\"type\": \"boolean\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"4aef4b09-0d7a-48b3-883f-56c817fd5829\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"name\": {\n" +
                "\t\t\t\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"8d324386-46ac-4526-a39e-6d2dbf2b2c2b\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"allowedFeatureTypeChanges\": {\n" +
                "\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"f27c87ea-d7d2-4482-8936-6ffc67cf8b7f\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"allowedStatusChanges\": {\n" +
                "\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"75c88346-4beb-4357-9adb-4346e2b5db77\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"requiredFeatureTypes\": {\n" +
                "\t\t\t\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\t\t\"$id\": \"acbad5e3-c490-458d-98bc-b17569276fb9\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\t\"$id\": \"f47d4b76-c911-4f8e-8800-9ef7fef1287c\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"546435af-fd6a-4773-875a-065eb60aa351\"\n" +
                "\t\t},\n" +
                "\t\t\"applicationId\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"374ca3d8-fb30-4ba5-b18c-fa0102e0af17\"\n" +
                "\t\t},\n" +
                "\t\t\"loanProductId\": {\n" +
                "\t\t\t\"type\": \"integer\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"806f1e7c-5984-4d26-903a-1435a0c6629d\"\n" +
                "\t\t},\n" +
                "\t\t\"startDate\": {\n" +
                "\t\t\t\"type\": \"null\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"c38cf3dc-abb8-4423-b2a1-41056d0e341a\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"additionalProperties\": false,\n" +
                "\t\t\t\"$id\": \"10321e68-0aed-491c-b125-550866297ee8\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"additionalProperties\": false,\n" +
                "\t\"$id\": \"e63a8888-1a19-49a6-91aa-6b30c947f34c\",\n" +
                "\t\"$schema\": \"http://json-schema.org/draft-07/schema#\"\n" +
                "}");

//        if(text.startsWith("{"))
//            schema.validate(new JSONObject(text));
//        else
//            schema.validate(new JSONArray(text));

//        GenSchemaSimplifier simplifier = new GenSchemaSimplifier();
//        generatedSchema = simplifier.analyze(generatedSchema);
//        schema = SchemaLoader.load(new JSONObject(GenSchemaUtils.serializeJsonPayload(generatedSchema)));
//        if(text.startsWith("{"))
//            schema.validate(new JSONObject(text));
//        else
//            schema.validate(new JSONArray(text));
        System.out.println(schema);

    }
}