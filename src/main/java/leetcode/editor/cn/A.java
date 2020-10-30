package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.List;

public class A {
    public static int[] range(int i, int j) {
        int size = Math.abs(i - j) + 1;
        if (size >100) {
            throw new RuntimeException("范围过大");
        }
        int[] ints = new int[size];
        if (i > j) {
            for (int k = 0; k < size; k++) {
                ints[k] = i - k;
            }
        } else {
            for (int k = 0; k < size; k++) {
                ints[k] = k + i;
            }
        }
        return ints;
    }

    public static void p(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print("," + arr[i]);
            }
        }
        System.out.println("]");
    }

    public static void p(Object[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(getString(arr[i]));
            } else {
                System.out.print("," + getString(arr[i]));
            }
        }
        System.out.println("]");
    }

    private static String getString(Object o) {
        if (o == null) {
            return null;
        }else if (o.getClass().isArray()) {
            int length = Array.getLength(o);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    sb.append(Array.get(o, i));
                } else {
                    sb.append(",").append(Array.get(o, i));
                }
            }
            sb.append("]");
            return sb.toString();
        } else {
            return o.toString();
        }
    }

    public static void p(List arr){
        System.out.print("[");
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                System.out.print(arr.get(0));
            } else {
                System.out.print("," + arr.get(i));
            }
        }
        System.out.println("]");
    }

    public static void p(List arr,String split,String startToken){
        System.out.print("["+startToken);
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                System.out.print(arr.get(0));
            } else {
                System.out.print(split + arr.get(i));
            }
        }
        System.out.println(startToken + "]");
    }


    public static void main(String[] args) {
        int[] range = A.range(1, 2);
        int[] range2 = A.range(3, 0);
        A.p(range);
    }
}