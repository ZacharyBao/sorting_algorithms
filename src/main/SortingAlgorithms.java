package main;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgorithms {
    /**
     * Bubble sort.
     * Average time complexity O(n2).
     * Space complexity O(1).
     * Stable.
     *
     * @param a
     * @return
     */
    public double[] bubbleSort(double[] a) {
        double temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * Selection sort.
     * Average time complexity O(n2).
     * Space complexity O(1).
     * Unstable.
     *
     * @param a
     * @return
     */
    public double[] selectionSort(double[] a) {
        int minId;
        for (int i = 0; i < a.length - 1; i++) {
            minId = i;
            // Each round get the index of smallest value from i+1 to the end.
            for (int j = i + 1; j < a.length; j++) {
                if (a[minId] > a[j]) {
                    minId = j;
                }
            }
            double temp = a[i];
            a[i] = a[minId];
            a[minId] = temp;
        }
        return a;
    }

    /**
     * Insertion sort.
     * Average time complexity O(n2).
     * Space complexity O(1).
     * Stable.
     *
     * @param a
     * @return
     */
    public double[] insertionSort(double[] a) {
        int preIndex;
        double current;
        for (int i = 1; i < a.length; i++) {
            current = a[i];
            preIndex = i - 1;
            while (preIndex >= 0 && a[preIndex] > current) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = current;
        }
        return a;
    }

    /**
     * Shell sort.
     * Average time complexity O(n1.3).
     * Space complexity O(1).
     * Unstable.
     *
     * @param a
     * @return
     */
    public double[] shellSort(double[] a) {
        int gap;
        for (gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    double temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }
            }
        }
        return a;
    }

    /**
     * Merge Sort
     * Average time complexity O(nlogn).
     * Space complexity O(n).
     * Stable.
     *
     * @param a
     * @return
     */
    public double[] mergeSort(double[] a) {
        if (a.length < 2) {
            return a;
        }
        int mid = a.length / 2;
        double[] left = Arrays.copyOfRange(a, 0, mid);
        double[] right = Arrays.copyOfRange(a, mid, a.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0;
        int leftCurrentPosition = 0;
        int rightCurrentPosition = 0;
        while (left.length > leftCurrentPosition && right.length > rightCurrentPosition) {
            if (left[leftCurrentPosition] < right[rightCurrentPosition]) {
                result[i++] = left[leftCurrentPosition++];

            } else {
                result[i++] = right[rightCurrentPosition++];
            }
        }
        while (left.length > leftCurrentPosition) {
            result[i++] = left[leftCurrentPosition++];
        }
        while (right.length > rightCurrentPosition) {
            result[i++] = right[rightCurrentPosition++];
        }
        return result;
    }

    /**
     * Quick sort.
     * Average time complexity O(nlogn).
     * Space complexity O(nlogn).
     * Unstable.
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public double[] quickSort(double[] a, int left, int right) {
        int i = 0, j = 0;
        double t;
        double pivot = 0;
        if (left < right) {//if there is no this judgement, we may come across index out of bounds exception,
            i = left;//cuz left >right is commonly exist in recursion,and sometimes left may be larger than length of array
            j = right;//and then, when we execute 'pivot=a[left]' code, exception happens.
            pivot = a[left];//set first left as pivot
        }
        //use this test case for verifing that left sometimes may be larger than length of array
        //34, 56, 45, 23, 43, 5, 6, 12, 76, 54,678, 324, 22, 45, 123, 5, 7, 23, 45,86785,987,0,23,1,89,234,1345,12,1234,999,-100,-89
        //System.out.println(left+" "+right);
        while (i != j && (left < right)) {//we need to fulfill left<right judgement here, cuz we need to make sure
            //code in this while circulation run correctly,or it will come across array out of bounds exception during recursion.
            while (a[j] >= pivot && i < j) {//scan from right to left util find the number that is smaller than pivot
                j--;
            }
            while (a[i] <= pivot && i < j) {//scan from left to right until find the number that is bigger than pivot
                i++;
            }
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //System.out.println("i" + i + " j" + j);
        if (left < right) {
            a[left] = a[i];
            a[i] = pivot;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
        return a;
    }

    public double[] heapSort(double[] a) {
        return a;
    }

    /**
     * Counting sort.
     * It can only be used to sort integers.
     * Average time complexity O(n+k).
     * Space complexity O(n+k).
     * Stable.
     *
     * @param a
     * @return
     */
    public int[] countingSort(int[] a) {
        int max;
        int min;
        int i, j;
        max = a[0];
        min = a[0];
        for (int num : a) {
            if (num >= max) {
                max = num;
            } else if (num <= min) {
                min = num;
            }
        }
        int[] c = new int[max - min + 1];
        Arrays.fill(c, 0);
        for (i = 0; i < a.length; i++) {
            c[a[i] - min]++;
        }

        for (j = 0, i = 0; j < c.length; j++) {
            if (c[j] != 0) {
                while (c[j] != 0) {
                    a[i++] = min + j;
                    c[j]--;
                }
            }
        }
        return a;
    }

    /**
     * Bucket sort.
     * Average time complexity O(n+k).
     * Space complexity O(n+k).
     * Stable.
     *
     * @param a
     * @param bucketCount
     * @return
     */
    public double[] bucketSort(double[] a, int bucketCount) {
        int len = a.length;
        double max = a[0];
        double min = a[0];
        for (double num : a) {//find the max and min from a
            if (num >= max) {
                max = num;
            } else if (num <= min) {
                min = num;
            }
        }
        double space = (max - min + 1) / bucketCount;
        ArrayList<Double>[] arrayLists = new ArrayList[bucketCount];
        for (double v : a) {
            int index = (int) Math.floor((v - min) / space);
            if (arrayLists[index] == null) {//if this bucket is empty,then add the number to the bucket directly
                arrayLists[index] = new ArrayList<Double>();
                arrayLists[index].add(v);
            } else {
                int k = arrayLists[index].size() - 1;//get the first element subscript in the arraylist
                while (k >= 0 && arrayLists[index].get(k) > v) {//if the first element is larger than a[i]
                    if (k + 1 > arrayLists[index].size() - 1) {
                        arrayLists[index].add(arrayLists[index].get(k));
                    } else {
                        arrayLists[index].set(k + 1, arrayLists[index].get(k));
                    }
                    k--;
                }//if the first element is not larger than a[i],then just add a[i] directly
                if (k + 1 > arrayLists[index].size() - 1) {//if so, it suggests that the first element(actually the biggest in the list)
                    // of the list is smaller than a[i],
                    arrayLists[index].add(v);//so we just add a[i] to the top of the list
                } else {
                    arrayLists[index].set(k + 1, v);
                }
            }
        }
        double[] result = new double[len];
        int count = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (arrayLists[i] != null) {
                for (int j = 0; j < arrayLists[i].size(); j++) {
                    result[count++] = arrayLists[i].get(j);
                }
            }
        }
        return result;
    }

    private int getMax(int[] a) {
        int max = a[0];
        for (int num : a) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int[] radixProcessForPositiveIntegers(int[] a, int exp) {
        int len = a.length;
        int[] output = new int[len];
        int[] buckets = new int[10];
        Arrays.fill(buckets, 0);
        //exp=1, (a[i] / exp) % 10 is the units digit of a[i], e.g. (123/1)%10=3.
        //exp=10, (a[i] / exp) % 10 is the tens digit of a[i], e.g. (123/10)%10=2.
        //exp=100, etc.
        try {
            for (int val : a) {
                buckets[(val / exp) % 10]++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //Since redix sort is sorting array based on number digits.
        //The value of buckets can indicate the number of numbers which share the same digit number.
        //e.g. a=[35,7,58,123,46,68], exp=1. buckets[8]=2, since 58 and 68 share the same units digit.
        //In this case, buckets={0，0，0，1，0，1，1，1，2，0}.
        //After executing the loop, buckets={0,0,0,1,1,2,3,4,6,6}
        //buckets[7] indicate total number of numbers from buckets[0] to buckets[7]
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, a, 0, len);
        return a;
    }

    private int getMaxABS(int[] a) {
        int maxabs = Math.abs(a[0]);
        for (int num : a) {
            if (Math.abs(num) > maxabs) {
                maxabs = Math.abs(num);
            }
        }
        return maxabs;
    }

    public int[] radixProcessForAllIntegers(int[] a, int exp) {
        int len = a.length;
        int[] output = new int[len];
        int[] buckets = new int[20];
        Arrays.fill(buckets, 0);
        //Negative integers use buckets[0] to buckets[9].
        //Positive integers use buckets[10] to buckets[19].
        for (int value : a) {
            //Here we have '9+(value / exp) % 10' to
            //make sure digit with small absolute value to be put in the higher position in th buckets.
            //e.g. a={89,56,-34,4,-9,-23,137,-234} exp=1
            //a[2]=-34, units digit is -4, 9+(-34/1)%10=5, a[2] should be put at buckets[5]
            //a[4]=-9, units digit is -9; 9-9=0, a[4] should be put at buckets[0]
            //a[5]=-23, units digit is -3, etc.
            //buckets 0  1  2  3  4  5  6  7  8  9
            //       -9 -8 -7 -6 -5 -4 -3 -2 -1 -0
            if (value < 0) {
                buckets[9 + (value / exp) % 10]++;
            } else {
                buckets[(value / exp) % 10 + 10]++;
            }
        }
        for (int i = 1; i < 20; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            if (a[i] < 0) {
                output[buckets[9 + (a[i] / exp) % 10] - 1] = a[i];
                buckets[9 + (a[i] / exp) % 10]--;
            } else {
                output[buckets[(a[i] / exp) % 10 + 10] - 1] = a[i];
                buckets[(a[i] / exp) % 10 + 10]--;
            }
        }
        System.arraycopy(output, 0, a, 0, len);
        return a;
    }

    /**
     * Redix sort.
     * It can only be used to sort positive integers, include 0.
     * Average time complexity O(n*k).
     * Space complexity O(n+k).
     * Stable
     *
     * @param a
     * @return
     */
    public int[] radixSortForPositiveIntegers(int[] a) {
        int max = getMax(a);// redix sort need to know the max number first, the get the max digit.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            a = radixProcessForPositiveIntegers(a, exp);
        }
        return a;
    }

    /**
     * Redix sort.
     * It can only be used to sort integers.
     * Average time complexity O(n*k).
     * Space complexity O(n+k).
     * Stable
     *
     * @param a
     * @return
     */
    public int[] radixSortForAllIntegers(int[] a) {
        int max = getMaxABS(a);// redix sort need to know the max number first, the get the max digit.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            a = radixProcessForAllIntegers(a, exp);
        }
        return a;
    }

}
