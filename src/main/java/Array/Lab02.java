package Array;

import java.lang.reflect.Array;
import java.util.Objects;

public class Lab02 {
    public static int[] copy(int[] source, int startIndex, int length) {
        if(source == null) {
            throw new NullPointerException();
        }
        if(startIndex < 0 || startIndex > source.length) {
            throw new IndexOutOfBoundsException();
        }
        if(startIndex + length > source.length || length < 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[length];
        for(int i=0; i<length; i++) {
            result[i] = source[startIndex+i];
        }
        return result;
    }

    public static <T> T[] copy(T[] source, int startIndex, int length) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (startIndex < 0 || startIndex > source.length) {
            throw new IndexOutOfBoundsException();
        }
        if (startIndex + length > source.length || length < 0) {
            throw new IllegalArgumentException();
        }

        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] res = (T[]) Array.newInstance(componentType, length);
        for (int i = 0; i < length; i++) {
            res[i] = source[startIndex + i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
