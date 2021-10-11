package com.lendistry.genschema;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenSchemaUtilsTests {

    @Test
    public void simplePropertyMergeTest(){
        Property p1 = new Property("#/p1","string","foobar");
        Property p2 = new Property("#/p1","string","dog");
        Property p3 = GenSchemaUtils.merge(p1,p2);
        assertEquals("#/p1",p3.getId());
        assertEquals("string",p3.getType());
        assertTrue(p3.getExamples().contains("dog"));
        assertTrue(p3.getExamples().contains("foobar"));
    }

    @Test
    public void differentTypesPropertyMergeTest(){
        Property p1 = new Property("#/p1","string","foobar");
        Property p2 = new Property("#/p1","integer",22);
        Property p3 = GenSchemaUtils.merge(p1,p2);
        assertEquals("#/p1",p3.getId());
        assertTrue(p3.typeEquals("string"));
        assertTrue(p3.typeEquals("integer"));
        assertTrue(p3.getExamples().contains("foobar"));
        assertTrue(p3.getExamples().contains(22));
    }

    @Test
    public void deeperPropertyMergeTestSymmetric(){
        Property p1 = new Property("#/p1","object",null);
        Property p2 = new Property("#/p1","object",null);
        p1.addChildProperty("p2",new Property("#/p1/properties/p2","string","foobar2"));
        p2.addChildProperty("p2",new Property("#/p1/properties/p2","string","dog2"));
        Property p3 = GenSchemaUtils.merge(p1,p2);
        assertEquals("#/p1",p3.getId());
        assertEquals("object",p3.getType());
        assertEquals(1,p3.getProperties().size());
        assertEquals("#/p1/properties/p2",p3.getProperty("p2").getId());
        assertTrue(p3.getProperty("p2").getExamples().contains("foobar2"));
        assertTrue(p3.getProperty("p2").getExamples().contains("dog2"));
    }
}
