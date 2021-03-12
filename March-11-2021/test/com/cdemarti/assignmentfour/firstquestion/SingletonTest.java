package com.cdemarti.assignmentfour.firstquestion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {
    @Test
    public void notNullSingleton() {
        Singleton testInstance = new Singleton();
        assertNotNull(testInstance);
    }
}