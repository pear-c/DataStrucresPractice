package Array;

import java.lang.reflect.Array;

public class Lab07 {
    public static boolean equals(Object array1, Object array2) {
        // 같은 참조 일때
        if(array1 == array2) {
            return true;
        }
        // 하나가 null 이면 false
        if(array1 == null || array2 == null) {
            throw new IllegalArgumentException();
        }
        // 배열이 아니면 false
        if(!array1.getClass().isArray() || !array2.getClass().isArray()) {
            return false;
        }

        int length1 = Array.getLength(array1);
        int length2 = Array.getLength(array2);
        if(length1 != length2) {
            return false;
        }

        for(int i=0; i<length1; i++) {
            Object element1 = Array.get(array1, i);
            Object element2 = Array.get(array2, i);

            if(element1 instanceof Object[] && element2 instanceof Object[]) {
                if(!equals(element1, element2)) {
                    return false;
                }
            }
            else if(!equals(element1, element2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[][] array1= {
                {1, 2, 3},
                {1, 2, 3}
        };

        Integer[][] array2= {
                {1, 2, 3},
                {1, 2, 3}
        };

        Integer[][] array3= {
                {1, 2, 3},
                {3, 2, 1}
        };

        System.out.println(equals(array1, array2));
// 출력: true
        System.out.println(equals(array1, array3));
// 출력: false

    }

}
