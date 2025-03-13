package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lab01 {
    public static int[] copy(int[] source) {
        int[] res = new int[source.length];
        for(int i=0; i<source.length; i++) {
            res[i] = source[i];
        }
        return res;
    }

    public static <T> T[] copy(T[] source) {
        Class <?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] res = (T[]) Array.newInstance(componentType, source.length);
        for(int i=0; i<res.length; i++) {
            res[i] = source[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] copied = copy(arr);
        System.out.println(Arrays.toString(copied)); // 출력: [1, 2, 3, 4, 5, 6]
    }
}
