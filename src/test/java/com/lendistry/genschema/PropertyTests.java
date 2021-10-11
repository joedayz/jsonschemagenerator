package com.lendistry.genschema;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PropertyTests {


    @Test
    public void testCloneObject(){
        Property p1 = new Property("#/p1","object",null);
        p1.addChildProperty("p2",new Property("#/p1/properties/p2","integer",22));

        Property clonedP1 = p1.clone();
        assertTrue(clonedP1.equivalentTo(p1));
        assertFalse(clonedP1==p1);
        assertFalse(clonedP1.equals(p1));

        Property p2 = p1.getProperty("p2");
        Property clonedP2 = clonedP1.getProperty("p2");
        assertTrue(p2.equivalentTo(clonedP2));
        assertFalse(p2.equals(clonedP2));
        assertFalse(clonedP2.equals(p2));
    }
}
