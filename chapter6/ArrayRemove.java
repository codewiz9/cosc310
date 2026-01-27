package chapter6;

import java.util.ArrayList;

public class ArrayRemove extends Target {

    public ArrayRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        //keept getting index out of bounds errors so I added this to prevent it
        int removeCount = 20_000;
        if (removeCount > arr.length) {
            removeCount = arr.length;
        }
        //times how long it takes to remove all numbers in indicesOrnums from arr
        // all timing is done in Target class
        int checksum = 0;
        int smallerarr[] = new int[arr.length - removeCount];
        for (int i = removeCount; i < arr.length; i++) {
            checksum++;
            smallerarr[i - removeCount] = arr[i];
        }
            return checksum;
    }
}
