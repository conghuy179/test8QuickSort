import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {
    private Scanner sc;
    private int selection;

    public Driver(Scanner sc) {
        this.sc = sc.useDelimiter("\n");
    }

    public void run() {
        do {
            System.out.println("PHAN CONG HUY - FX16513");
            System.out.println("Quick Sort: ");
            System.out.println("Enter number of array (1 to 10): ");
            selection = sc.nextInt();
            if (!isValid(selection)) {
                System.out.println("Only type number from 1 to 10. Try again.");
            }
        } while (!isValid(selection));
        int[] arr = new int[selection];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }

        System.out.println("Unsorted array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }

    public boolean isValid(int selection) {
        for (int i = 1; i < 11; i++) {
            if (selection == i) {
                return true;
            }
        }
        return false;
    }

    public void sort(int[] a)
    {
        Collections StdRandom;
        StdRandom = null;
        StdRandom.shuffle(Collections.singletonList(a)); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }
    private void sort(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }
    private int partition(int[] a, int lo, int hi)
    { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        int v = a[lo]; // partitioning item
        while (true)
        { // Scan right, scan left, check for scan complete, and exchange.
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    private void exch(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }
}
