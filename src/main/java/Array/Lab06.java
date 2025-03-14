package Array;

public class Lab06 {
    public static boolean equals(int[][] array1, int[][] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException();
        }


        for(int i=0; i<array1.length; i++) {
            for(int j=0; j<array1[i].length; j++) {
                if(array1[i][j] != array2[i][j])
                    return false;
            }
        }
        return true;
    }
    public static <T> boolean equals(T[][] array1, T[][] array2) {
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException();
        }


        for(int i=0; i<array1.length; i++) {
            for(int j=0; j<array1[i].length; j++) {
                if(array1[i][j] != array2[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] array1= {
                {1, 2, 3},
                {1, 2, 3}
        };

        int[][] array2= {
                {1, 2, 3},
                {1, 2, 3}
        };

        int[][] array3= {
                {1, 2, 3},
                {3, 2, 1}
        };

        System.out.println(equals(array1, array2));
// 출력: true
        System.out.println(equals(array1, array3));
// 출력: false

    }

}
