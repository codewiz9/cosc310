package chapter6;

import java.util.ArrayList;

public class ListInsert extends Target {

    public ListInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }    

    @Override
    public int method(int[] indicesOrnums) {
        //times how long it takes to insert all numbers in indicesOrnums into list
        //all timing is done in Target class
        int result = 0;
        for (int i = 0; i < indicesOrnums.length; i++) {
            result += list.get(indicesOrnums[i]);
            list.add(indicesOrnums[i]);
        }
        return result;
    }

}
