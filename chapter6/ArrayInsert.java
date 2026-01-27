package chapter6;

import java.util.ArrayList;

public class ArrayInsert extends Target {

    public ArrayInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        // times how long it takes to insert all numbers in indicesOrnums into arr
        // all timing is done in Target class
        int checksum = 0;
        int largerarr[] = new int[arr.length + indicesOrnums.length];
        for (int i = 0; i < indicesOrnums.length; i++) {
            checksum += indicesOrnums[i];
            largerarr[i] = indicesOrnums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            largerarr[i + indicesOrnums.length] = arr[i];
            checksum += arr[i];
        }
        return checksum;
    }
}