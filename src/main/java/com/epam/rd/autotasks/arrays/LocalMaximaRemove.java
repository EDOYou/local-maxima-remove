package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, 8};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    // Method to remove an element at specific index
    public static int[] removeElem(int[] arr, int atIndex) {
        int[] auxArr = new int[arr.length - 1];

        int cnt = 0;
        for (int i = 0; i < arr.length; i++){
            if (i != atIndex) {
                auxArr[cnt] = arr[i];
                cnt++;
            }
        }

        return auxArr;
    }

    public static int[] removeLocalMaxima(int[] array){

        //put your code here
        int numRemoved = 0;
        int[] result;
        int[] helper;
        if (array[0] > array[1] && (array[array.length - 1] > array[array.length - 2])) {
            result = removeElem(array, 0);
            helper = result;
            result = removeElem(helper, helper.length - 1);
            numRemoved++;
        } else if (array[0] > array[1]) {
            result = removeElem(array, 0);
            numRemoved++;
        } else if (array[array.length - 1] > array[array.length - 2]) {
            result = removeElem(array, array.length - 1);
            numRemoved++;
        } else
            result = array;


        for (int i = 1; i < array.length - 1; i++) {
            // Check if the number is greater than both its neighbours
            if ((array[i - 1] < array[i]) && (array[i] > array[i + 1])) {
                helper = result;
                // Cases to manage with the indexes of array helper
                if (array[0] > array[1] && (array[array.length - 1] > array[array.length - 2])) {
                    result = removeElem(helper, i - numRemoved);
                    numRemoved++;
                } else if (array[0] > array[1]) {
                    result = removeElem(helper, i - numRemoved);
                    numRemoved++;
                } else if (array[array.length - 1] > array[array.length - 2]) {
                    result = removeElem(helper, i);
                    numRemoved++;
                } else {
                    result = removeElem(helper, i - numRemoved);
                    numRemoved++;
                }
            }
        }

        return result;
    }
}
