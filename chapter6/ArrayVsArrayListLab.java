package chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    protected static int listRandomAccess(int indices[], ArrayList<Integer> list) {
        int result = 0;
        for (int i = 0; i < indices.length; i++) {
            result += list.get(indices[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        /*
         * long start = System.nanoTime();
         * System.out.println("hello, world");
         * long finish = System.nanoTime();
         * long elapsed = finish - start;
         * System.out.println("println: " + elapsed + "ns");
         * start = System.nanoTime();
         * arrayTest(30_000);
         * finish = System.nanoTime();
         * elapsed = finish - start;
         * System.out.println("arrayTest: " + elapsed + "ns");
         */
        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indices[] = new int[100_000];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        // creates all the different Target objects for the different tests
        Target tests[] = new Target[8];
        double test_avg[] = new double[8];

        // creates the instances of each test
        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array, random_access");
        tests[1] = new ListRandom(arr, new ArrayList<>(list), "arraylist, random_access");
        tests[2] = new ArrayAppend(arr, new ArrayList<>(list), "array, append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array, insert");
        tests[5] = new ListInsert(arr, new ArrayList<>(list), "arraylist, insert");
        tests[3] = new ListAppend(arr, new ArrayList<>(list), "arraylist, append");
        tests[6] = new ListRemove(arr, new ArrayList<>(list), "arraylist, remove");
        tests[7] = new ArrayRemove(arr, new ArrayList<>(list), "array, remove");

        for (int i = 0; i < tests.length; i++) {
            Target target = tests[i];
            if (target != null) {
                test_avg[i] = target.runTests(indices);
                target.writeResults(fileOut);
            }
        }
        //print the average times for each test and wich one won
        for (int i = 0; i < tests.length; i+=2) {
            if (test_avg[i] < test_avg[i+1]) {
                System.out.println(tests[i].getName() + " won");
            } else {
                System.out.println(tests[i+1].getName() + " won" );
            }
        }
        fileOut.close();

    }
}