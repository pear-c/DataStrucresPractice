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
}
