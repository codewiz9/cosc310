package chapter6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ArrayVsArrayListLab {

    protected static int arrayRanndomAccess(int indcies[], int arr[]){
        int finnal = 0;
        for(int i = 0; i < indcies.length; i++){
            finnal += arr[indcies[i]];
        }

        return finnal;

    }
     protected static int listRanndomAccess(int indcies[], ArrayList<Integer> list){
        int finnal = 0;
        for(int i = 0; i < indcies.length; i++){
            finnal += list.get(indcies[i]);
        }

        return finnal;

    }
    public static void main(String[] args) throws IOException {
        // long start = System.nanoTime();
        // System.out.println("Hello World");
        // long finsih = System.nanoTime();
        // long elapsed = finsih - start;
        // System.out.println("println took: " + elapsed);

        // start = System.nanoTime();
        // arrayTest(30_000);
        // finsih = System.nanoTime();
        // elapsed = finsih - start;
        // System.out.println("array test took: " + elapsed);
        int arr[]= DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indcies[] = new int[100];
        for(int i = 0; i < indcies.length; i++){
            indcies[i] = r.nextInt(arr.length);

        }

        //time test array
        long start = System.nanoTime();
        int result = arrayRanndomAccess(indcies, arr);
        long finnish = System.nanoTime();
        long elapsed = finnish - start;
        System.out.println(result);
        System.out.println("array took: " + elapsed);

        //time test list
        start = System.nanoTime();
        result = listRanndomAccess(indcies, list);
        finnish = System.nanoTime();
        elapsed = finnish - start;
        System.out.println(result);
        System.out.println("list took: " + elapsed);
    }


    
}
