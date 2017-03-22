package com.linsh.circleprogress.utils;

/**
 * Created by Senh Linsh on 17/3/16.
 */
public class LshArrayUtils {

    public static void copy(int[] srcArray, int[] destArray) {
        if (srcArray == null) {
            destArray = null;
            return;
        }
        if (destArray == null || destArray.length != srcArray.length) {
            destArray = (int[]) new int[srcArray.length];
        }
        for (int i = 0; i < srcArray.length; i++) {
            destArray[i] = srcArray[i];
        }
    }

    public static int[] getCopy(int[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        return getCopy(srcArray, srcArray.length);
    }

    public static int[] getCopy(int[] srcArray, int newLength) {
        int[] destArray = new int[newLength];

        if (srcArray != null && srcArray.length > 0) {
            for (int i = 0; i < srcArray.length; i++) {
                destArray[i] = srcArray[i];
            }
        }
        return destArray;
    }
}
