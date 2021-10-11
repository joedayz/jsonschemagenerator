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
}
