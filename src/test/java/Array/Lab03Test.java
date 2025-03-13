package Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab03Test {
    private Lab03 XArrays;

    @Test
    void testCopyIntArrayToAnotherArray() {
        int[] source = { 1, 2, 3, 4, 5 };
        int[] destination = new int[5];
        XArrays.copy(source, 1, destination, 2, 3);
        assertArrayEquals(new int[] { 0, 0, 2, 3, 4 }, destination);
    }

    @Test
    void testCopyIntArrayToSelf() {
        int[] source = { 1, 2, 3, 4, 5 };
        XArrays.copy(source, 1, source, 2, 3);
        assertArrayEquals(new int[] { 1, 2, 2, 3, 4 }, source);

        XArrays.copy(source, 2, source, 0, 3);
        assertArrayEquals(new int[] { 2, 3, 4, 3, 4 }, source);
    }

    @Test
    void testCopyIntArrayToAnotherArray_NullSourceOrDestination() {
        int[] source = { 1, 2, 3, 4, 5 };
        int[] destination = new int[5];
        assertThrows(NullPointerException.class, () -> XArrays.copy((int[]) null, 0, destination, 0, 0));
        assertThrows(NullPointerException.class, () -> XArrays.copy(source, 0, (int[]) null, 0, 0));
    }

    @Test
    void testCopyIntArrayToAnotherArray_InvalidParams() {
        int[] source = { 1, 2, 3, 4, 5 };
        int[] destination = new int[5];
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, -1, destination, 0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, 0, destination, -1, 3));
        assertThrows(IllegalArgumentException.class, () -> XArrays.copy(source, 2, destination, 1, 10));
    }

    // copy(T[] source, int srcIndex, T[] destination, int destIndex, int length)
    // 테스트
    @Test
    void testCopyGenericArrayToAnotherArray() {
        String[] source = { "a", "b", "c", "d", "e" };
        String[] destination = new String[5];
        XArrays.copy(source, 1, destination, 2, 3);
        assertArrayEquals(new String[] { null, null, "b", "c", "d" }, destination);
    }

    @Test
    void testCopyGenericArrayToSelf() {
        String[] source = { "a", "b", "c", "d", "e" };
        XArrays.copy(source, 1, source, 2, 3);
        assertArrayEquals(new String[] { "a", "b", "b", "c", "d" }, source);

        XArrays.copy(source, 2, source, 0, 3);
        assertArrayEquals(new String[] { "b", "c", "d", "c", "d" }, source);
    }

    @Test
    void testCopyGenericArrayToAnotherArray_NullSourceOrDestination() {
        String[] source = { "a", "b", "c", "d", "e" };
        String[] destination = new String[5];
        assertThrows(NullPointerException.class, () -> XArrays.copy((String[]) null, 0, destination, 0, 0));
        assertThrows(NullPointerException.class, () -> XArrays.copy(source, 0, (String[]) null, 0, 0));
    }

    @Test
    void testCopyGenericArrayToAnotherArray_InvalidParams() {
        String[] source = { "a", "b", "c", "d", "e" };
        String[] destination = new String[5];
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, -1, destination, 0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, 0, destination, -1, 3));
        assertThrows(IllegalArgumentException.class, () -> XArrays.copy(source, 2, destination, 1, 10));
    }

}