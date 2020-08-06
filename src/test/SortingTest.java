package test;

import main.SortingAlgorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by baodong on 2020/8/3.
 */

public class SortingTest {
    private double[] testArr1 = {34, 56, 45, 23, 43, 5, 6, 23, -111, 12, 4, 1345, -12, 1234, 999, -100, -89, -111, -1, 0};
    private double[] expectedTestArr1 = {-111.0, -111.0, -100.0, -89.0, -12.0, -1.0, 0.0, 4.0, 5.0, 6.0, 12.0, 23.0, 23.0, 34.0, 43.0, 45.0, 56.0, 999.0, 1234.0, 1345.0};
    private int[] testArr2 = {34, 56, 45, 23, 43, 5, 6, 23, -111, 12, 4, 1345, -12, 1234, 999, -100, -89, -111, -1, 0};
    private int[] expectedTestArr2 = {-111, -111, -100, -89, -12, -1, 0, 4, 5, 6, 12, 23, 23, 34, 43, 45, 56, 999, 1234, 1345};
    private int[] testArr3 = {34, 56, 45, 23, 43, 5, 6, 12, 76, 54, 86785, 987, 0, 23, 1, 89, 234, 1345, 12, 1234, 9990};
    private int[] expectedTestArr3 = {0, 1, 5, 6, 12, 12, 23, 23, 34, 43, 45, 54, 56, 76, 89, 234, 987, 1234, 1345, 9990, 86785};
    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
    private long startTime;
    private long endTime;
    private long costTime;

    @Test
    public void bubbleSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.bubbleSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("BubbleSort-O(n2) running time:" + costTime + "ns");
    }

    @Test
    public void selectionSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.selectionSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("SelectionSort-O(n2) running time:" + costTime + "ns");
    }

    @Test
    public void insertionSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.insertionSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("InsertionSort-O(n2) running time:" + costTime + "ns");
    }

    @Test
    public void shellSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.shellSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("ShellSort-O(n1.3) running time:" + costTime + "ns");
    }

    @Test
    public void mergeSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.mergeSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("MergeSort-O(nlogn) running time:" + costTime + "ns");
    }

    @Test
    public void quickSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.quickSort(test, 0, test.length - 1);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("QuickSort-O(nlogn) running time:" + costTime + "ns");
    }

    @Test
    public void heapSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.heapSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("HeapSort-O(nlogn) running time:" + costTime + "ns");
    }

    @Test
    public void countingSortTest() {
        int len = testArr2.length;
        int[] test = new int[len];
        System.arraycopy(testArr2, 0, test, 0, len);
        startTime = System.nanoTime();
        int[] result = sortingAlgorithms.countingSort(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr2, result);
        System.out.println("CountingSort-O(n+k) running time:" + costTime + "ns");
    }

    @Test
    public void bucketSortTest() {
        int len = testArr1.length;
        double[] test = new double[len];
        System.arraycopy(testArr1, 0, test, 0, len);
        startTime = System.nanoTime();
        double[] result = sortingAlgorithms.bucketSort(test, 5);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr1, result);
        System.out.println("BucketSort-O(n+k) running time:" + costTime + "ns");
    }

    @Test
    public void radixSortPositiveTest() {
        int len = testArr3.length;
        int[] test = new int[len];
        System.arraycopy(testArr3, 0, test, 0, len);
        startTime = System.nanoTime();
        int[] result = sortingAlgorithms.radixSortForPositiveIntegers(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr3, result);
        System.out.println("RadixSortPositive-O(n+k) running time:" + costTime + "ns");
    }

    @Test
    public void radixSortAllTest() {
        int len = testArr2.length;
        int[] test = new int[len];
        System.arraycopy(testArr2, 0, test, 0, len);
        startTime = System.nanoTime();
        int[] result = sortingAlgorithms.radixSortForAllIntegers(test);
        endTime = System.nanoTime();
        costTime = endTime - startTime;
        Assertions.assertArrayEquals(expectedTestArr2, result);
        System.out.println("RadixSortAll-O(n+k) running time:" + costTime + "ns");
    }

}
