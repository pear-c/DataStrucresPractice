package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

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

        T[][] res = (T[][]) Array.newInstance(source.getClass().getComponentType(), source.length);
        for(int i=0; i<source.length; i++) {
            if(source[i] == null) continue;
            res[i] = (T[]) Array.newInstance(source[i].getClass().getComponentType(), source[i].length);
            for(int j=0; j<source[i].length; j++) {
                res[i][j] = source[i][j];
            }
        }
        return res;
    }

    public static Object[] deepCopy(Object[] source) {
        if (source == null) {
            throw new NullPointerException();
        }

        Object[] copy = new Object[source.length];

        for (int i = 0; i < source.length; i++) {
            Object element = source[i];

            if (element instanceof int[]) {
                int[] original = (int[]) element;
                int[] newArray = new int[original.length];
                for (int j = 0; j < original.length; j++) {
                    newArray[j] = original[j];
                }
                copy[i] = newArray;
            } else if (element instanceof String[]) {
                String[] original = (String[]) element;
                String[] newArray = new String[original.length];
                for (int j = 0; j < original.length; j++) {
                    newArray[j] = original[j];
                }
                copy[i] = newArray;
            } else if (element instanceof Object[]) {
                copy[i] = deepCopy((Object[]) element);
            } else {
                copy[i] = element; // 불변 객체(String, Integer 등) 그대로 할당
            }
        }
        return copy;
    }





    public static void main(String[] args) {
        Object[] innerArray = { "c", "d" };
        Object[] source = { 1, "hello", innerArray };
        Object[] destination = deepCopy(source);

        System.out.println();

    }

}
