package chapter6;

import java.util.ArrayList;

public class ListAppend extends Target {
    public ListAppend(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        // times how long it takes to append all numbers in indicesOrnums into arr
        // all timing is done in Target class
        int checksum = 0;
        for (int i = 0; i < indicesOrnums.length; i++) {
            checksum += indicesOrnums[i];
            list.add(indicesOrnums[i]);
        }
        return checksum;
    }
}
