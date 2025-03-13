package Array;


import java.lang.reflect.Array;

public class XArrays {
    // Lab-01 : 배열 복제 생성
    public static int[] copy(int[] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }

        int[] result = new int[source.length];
        System.arraycopy(source, 0, result, 0, source.length);

        return result;
    }

    public static <T> T[] copy(T[] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }

        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(componentType, source.length);

        System.arraycopy(source, 0, result, 0, source.length);
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
        System.arraycopy(source, startIndex + 0, result, 0, length);

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

        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(componentType, length);
        if (length >= 0) System.arraycopy(source, startIndex + 0, result, 0, length);
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
        System.arraycopy(source, srcIndex, temp, 0, length);
        System.arraycopy(temp, 0, destination, destIndex, length);
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

        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) Array.newInstance(componentType, length);
        if (length >= 0) System.arraycopy(source, srcIndex , temp, 0, length);
        if (length >= 0) System.arraycopy(temp, 0, destination, destIndex, length);
    }

    // Lab-04 : 다차원 배열 복제
    public static int[][] deepCopy(int[][] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }

        int[][] result = new int[source.length][];

        for(int i=0; i<source.length; i++) {
            if(source[i] != null) {
                result[i] = new int[source[i].length];
                for(int j=0; j<source[i].length; j++) {
                    result[i][j] = source[i][j];
                }
            }
        }
        return result;
    }
    public static <T> T[][] deepCopy(T[][] source) {
        if(source == null) {
            throw new NullPointerException("source is null");
        }
        Class<?> componentType = source.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[][] result = (T[][]) Array.newInstance(componentType, source.length);

        for(int i=0; i<source.length; i++) {
            if (source[i] != null) {
                Class<?> innerComponentType = source[i].getClass().getComponentType();
                @SuppressWarnings("unchecked")
                T[] innerArray = (T[]) Array.newInstance(innerComponentType, source[i].length);
                for(int j=0; j<source[i].length; j++) {
                    innerArray[j] = source[i][j];
                }
                result[i] = innerArray;
            }
        }
        return result;
    }


    // Lab-05 : 배열의 동등 비교
    public static boolean equals(int[] array1, int[] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException("array1 and array2 is null");
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
            throw new IllegalArgumentException("array1 and array2 is null");
        }
        for(int i=0; i<array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    // Lab-06 : 2차원 배열 동등 비교
    public static boolean equals(int[][] array1, int[][] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException("array1 and array2 is null");
        }
        for(int i=0; i<array1.length; i++) {
            if(array1[i] == null || array2[i] == null) {
                throw new IllegalArgumentException("array1 and array2 is null");
            }
            for(int j=0; j<array2[i].length; j++) {
                if(array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static <T> boolean equals(T[][] array1, T[][] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException("array1 and array2 is null");
        }
        for(int i=0; i<array1.length; i++) {
            if(array1[i] == null || array2[i] == null) {
                throw new IllegalArgumentException("array1 and array2 is null");
            }
            for(int j=0; j<array2[i].length; j++) {
                if(array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Lab-07 : 다차원 배열 동등 비교
    public static boolean equals(Object array1, Object array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException("array1 and array2 is null");
        }

        if(array1.getClass().isArray()) {
            if(array1.getClass().getComponentType().isPrimitive()) {
                for(int i=0; i<Array.getLength(array1); i++) {
                    if(!Array.get(array1, i).equals(Array.get(array2, i))) {

                    }
                }
            }
        }


        return false;
    }




    public static void main(String[] args) {
        String[] arr1 = {"a", "b"};
        String[] arr2 = {"c", "d"};
        Object[] source = {arr1, arr2};



    }
}
