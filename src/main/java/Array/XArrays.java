package Array;


import java.lang.reflect.Array;

public class XArrays {
    // Lab-01 : 배열 복제 생성
    public static int[] copy(int[] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }

        int[] result = new int[source.length];
        for (int i=0; i<source.length; i++) {
            result[i] = source[i];
        }
        return result;
    }

    public static <T> T[] copy(T[] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }
        T[] result = (T[]) Array.newInstance(source.getClass().componentType(), source.length);
        for(int i=0; i<source.length; i++) {
            result[i] = source[i];
        }
        return result;
    }

    // Lab-02 : 배열 부분 복제 생성
    public static int[] copy(int[] source, int startIndex, int length) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }
        if(startIndex < 0) {
            throw new IndexOutOfBoundsException("startIndex is negative");
        }
        if(startIndex + length > source.length) {
            throw new IllegalArgumentException("startIndex + length > source.length");
        }

        int[] result = new int[length];
        for(int i=0; i<length; i++) {
            result[i] = source[startIndex + i];
        }

        return result;
    }
    public static <T> T[] copy(T[] source, int startIndex, int length) {
        if(source == null) {
            throw new IllegalArgumentException("source is null");
        }
        if(startIndex < 0) {
            throw new IndexOutOfBoundsException("startIndex is negative");
        }
        if(startIndex + length > source.length) {
            throw new IllegalArgumentException("startIndex + length > source.length");
        }

        T[] result = (T[]) Array.newInstance(source.getClass().componentType(), length);
        for(int i=0; i<length; i++) {
            result[i] = source[startIndex + i];
        }
        return result;
    }
}
