package com.hillel.elementary.javageeks.divide_and_conquer;

public final class Sorter {

    private Sorter() { }

    public static int[] mergeSort(int[] array) {
        if (array == null) {
            return null;
        }

        if (array.length < 2) {
            return array;
        } else {
            int[] leftHalf = new int[array.length / 2];
            int[] rightHalf = new int[array.length - leftHalf.length];
            System.arraycopy(array, 0, leftHalf, 0, leftHalf.length);
            System.arraycopy(array, leftHalf.length, rightHalf, 0, rightHalf.length);
            if (leftHalf.length > 1) {
                leftHalf = mergeSort(leftHalf);
            }
            if (rightHalf.length > 1) {
                rightHalf = mergeSort(rightHalf);
            }
            int i = 0;
            int j = 0;
            int[] resultArray = new int[leftHalf.length + rightHalf.length];
            for (int k = 0; k < rightHalf.length + leftHalf.length; k++) {
                if (i < leftHalf.length && j < rightHalf.length) {
                    if (leftHalf[i] < rightHalf[j]) {
                        resultArray[k] = leftHalf[i++];
                    } else {
                        resultArray[k] = rightHalf[j++];
                    }
                } else {
                    if (i < j) {
                        resultArray[k] = leftHalf[i++];
                    } else {
                        resultArray[k] = rightHalf[j++];
                    }
                }
            }
            return resultArray;
        }
    }
}

