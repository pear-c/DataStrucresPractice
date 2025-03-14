package Array;

import java.lang.reflect.Array;

public class Lab05 {
    public static boolean equals(int[] array1, int[] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException();
        }

        if(array1.length != array2.length) {
            return false;
        }

        for(int i=0; i<array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
    public static <T> boolean equals(T[] array1, T[] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException();
        }

        if(array1.length != array2.length) {
            return false;
        }

        for(int i=0; i<array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] array1= {1, 2, 3};
        int[] array2= {1, 2, 3};
        int[] array3= {3, 2, 1};

        System.out.println(equals(array1, array2));
        // 출력: true
        System.out.println(equals(array1, array3));
        // 출력: false

    }


}
