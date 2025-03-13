package Array;

import java.lang.reflect.Array;

public class Lab04 {
    public static int[][] deepCopy(int[][] source) {
        if(source == null) {
            throw new NullPointerException();
        }

        int[][] res = new int[source.length][];
        for(int i=0; i<source.length; i++) {
            res[i] = new int[source[i].length];
            for(int j=0; j<source[i].length; j++) {
                res[i][j] = source[i][j];
            }
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[][] deepCopy(T[][] source) {
        if(source == null) {
            throw new NullPointerException();
        }

        Class<?> componentType = source.getClass().getComponentType();
        T[][] res = (T[][]) Array.newInstance(componentType, source.length);
        for(int i=0; i<source.length; i++) {
            res[i] = (T[]) Array.newInstance(componentType, source[i].length);
            for(int j=0; j<source[j].length; j++) {
                res[i][j] = source[i][j];
            }
        }
        return res;
    }

    public static Object[] deepCopy(Object[] source) {
        if (source == null) {
            throw new NullPointerException("Source array cannot be null");
        }

        Object[] res = new Object[source.length];

        for (int i = 0; i < source.length; i++) {
            if (source[i] == null) {
                res[i] = null; // null 값 복사 허용
            } else if (source[i] instanceof Object[][]) {
                res[i] = deepCopy((Object[][]) source[i]); // 다차원 배열 복사
            } else if (source[i] instanceof int[][]) {
                res[i] = deepCopy((int[][]) source[i]); // int[][] 복사
            } else if (source[i] instanceof Object[]) {
                res[i] = deepCopy((Object[]) source[i]); // 1차원 배열 재귀 복사
            } else if (source[i] instanceof int[]) {
                int[] original = (int[]) source[i];
                int[] newArray = new int[original.length];
                for (int j = 0; j < original.length; j++) {
                    newArray[j] = original[j];
                }
                res[i] = newArray;
            } else {
                res[i] = source[i]; // Immutable 객체 직접 복사
            }
        }

        return res;
    }





    public static void main(String[] args) {
        Object[] innerArray = { "c", "d" };
        Object[] source = { 1, "hello", innerArray };
        Object[] destination = deepCopy(source);

        System.out.println();

    }

}
