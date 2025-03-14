package Array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab01Test {

    private Lab01 XArrays;

    // copy(int[] source) 테스트
    @Test
    void testCopyIntArray() {
        int[] source = { 1, 2, 3, 4, 5 };
        int[] destination = XArrays.copy(source);
        assertArrayEquals(source, destination);
    }

    @Test
    void testCopyIntArray_NullSource() {
        assertThrows(NullPointerException.class, () -> XArrays.copy((int[]) null));
    }

    // copy(T[] source) 테스트
    @Test
    void testCopyGenericArray() {
        String[] source = { "a", "b", "c" };
        String[] destination = XArrays.copy(source);
        assertArrayEquals(source, destination);
    }

    @Test
    void testCopyGenericArray_NullSource() {
        assertThrows(NullPointerException.class, () -> XArrays.copy((String[]) null));
    }
}
