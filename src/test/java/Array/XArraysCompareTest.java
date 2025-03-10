package Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XArraysCompareTest {

    @Test
    void testEqualsIntArray() {
        int[] arr1 = {1, 2 ,3};
        int[] arr2 = {1, 2 ,3};
        assertTrue(XArrays.equals(arr1, arr2));
    }

    @Test
    void testEqualsGenericTypeArray() {
    }
}