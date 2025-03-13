package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lab03 {
    public static void copy(int[] source, int srcIndex, int[] destination, int destIndex, int length) {
        if(source == null || destination == null) {
            throw new NullPointerException();
        }
        if(srcIndex < 0 || destIndex > source.length) {
            throw new IndexOutOfBoundsException();
        }
        if(srcIndex + length > source.length || length < 0) {
            throw new IllegalArgumentException();
        }
        int[] temp = new int[source.length];
        for(int i=0; i<temp.length; i++) {
            temp[i] = source[i];
        }

        for(int i=0; i<length; i++) {
            destination[destIndex + i] = temp[srcIndex + i];
        }
    }
    public static <T> void copy(T[] source, int srcIndex, T[] destination, int destIndex, int length) {
        if(source == null || destination == null) {
            throw new NullPointerException();
        }
        if(srcIndex < 0 || destIndex > source.length) {
            throw new IndexOutOfBoundsException();
        }
        if(srcIndex + length > source.length || length < 0) {
            throw new IllegalArgumentException();
        }

        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) Array.newInstance(componentType, source.length);
        for(int i=0; i<temp.length; i++) {
            temp[i] = source[i];
        }

        for(int i=0; i<length; i++) {
            destination[destIndex + i] = temp[srcIndex + i];
        }
    }

    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5, 6};
        int[] dest = new int[6];

        copy(src, 2, dest, 1, 3);

        System.out.println(Arrays.toString(dest)); // 출력: [0, 3, 4, 5, 0, 0]

    }
}
