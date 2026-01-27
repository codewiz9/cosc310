package chapter6;

import java.util.ArrayList;

public class ListRemove extends Target {

    public ListRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        // times how long it takes to remove all numbers in indicesOrnums from list
        // all timing is done in Target class
        int checksum = 0;
        //keept getting index out of bounds errors so I added this to prevent it
        int toRemove = 20_000;
        if (toRemove > list.size())
            toRemove = list.size();

        for (int i = 0; i < toRemove; i++) {
            if (!list.isEmpty()) {
                checksum++;
                list.remove(0);
            }
        }
        // returns num of times remove
        return checksum;
    }
}
