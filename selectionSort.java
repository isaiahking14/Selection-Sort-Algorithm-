import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class selectionSort {
    static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        load();
        selectionSorted(arr);
        
    }
    
    private static void load() throws FileNotFoundException {
        File number = new File("numbers-1.txt");
        Scanner scan = new Scanner(number);
        int index_count = 0;
        // count amount of index's needed to create array
        while (scan.hasNextInt()){
            index_count++;
            scan.nextInt();
        }
        arr = new int[index_count];
        scan.close();
        // make new scanner to load file into array
        Scanner scan2 = new Scanner(number);
        index_count = -1;
        while (scan2.hasNextInt()){
            index_count++;
            arr[index_count] = scan2.nextInt();
        }
        scan2.close();
    }

    public static void selectionSorted(int[] arr) {
        int n = arr.length;

        // traverse through the array
        for (int i = 0; i < n - 1; i++) {
            // find the index of the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap the minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
