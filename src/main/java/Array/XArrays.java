package Array;


import java.lang.reflect.Array;
import java.util.Arrays;

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

    // Lab-03 : 배열 부분 복사 - 배열 1) -> 배열 2) 로 내용 복사
    public static void copy(int[] source, int srcIndex, int[] destination, int destIndex, int length) {
        if(source == null || destination == null) {
            throw new NullPointerException("source and destination is null");
        }
        if(srcIndex < 0 || destIndex < 0) {
            throw new IndexOutOfBoundsException("srcIndex or destIndex is negative");
        }
        if(srcIndex + length > source.length || destIndex + length > destination.length) {
            throw new IllegalArgumentException("srcIndex + length > destIndex + length");
        }

        int[] temp = new int[length];
        for(int i=0; i<length; i++) {
            temp[i] = source[srcIndex + i];
        }
        for(int i=0; i<length; i++) {
            destination[destIndex + i] = temp[i];
        }
    }
    public static <T> void copy(T[] source, int srcIndex, T[] destination, int destIndex, int length) {
        if(source == null || destination == null) {
            throw new NullPointerException("source and destination is null");
        }
        if(srcIndex < 0 || destIndex < 0) {
            throw new IndexOutOfBoundsException("srcIndex or destIndex is negative");
        }
        if(srcIndex + length > source.length || destIndex + length > destination.length) {
            throw new IllegalArgumentException("srcIndex + length > destIndex + length");
        }
        T[] temp = (T[]) Array.newInstance(source.getClass().componentType(), length);
        for(int i=0; i<length; i++) {
            temp[i] = source[srcIndex + i];
        }
        for(int i=0; i<length; i++) {
            destination[destIndex + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5};

        copy(src, 1, src, 2, 3);

        System.out.println(Arrays.toString(src)); // 출력: [0, 3, 4, 5, 0, 0]
    }
}
