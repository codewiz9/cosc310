package chapter14;
import java.util.ArrayList;

public class Sorting {

    private static void swap(ArrayList<Comparable> list, int i, int j) {
        Comparable temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public static void selectionSort(ArrayList<Comparable> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
        
    }

}
