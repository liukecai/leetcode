package cn.edu.kust.medium;

import java.util.Arrays;

/**
 *
 * 912. Sort an Array
 * pass
 */
public class HeapSort {
    private int heapSize;
    private int length;

    public int[] heapSort(int[] A) {
        length = A.length;
        heapSize = A.length;
        buildMaxHeap(A);
        sort(A);
        return A;
    }

    private void buildMaxHeap(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            maxHeapIfy(A, i);
        }
    }

    private void maxHeapIfy(int[] A, int i) {
        if (i > heapSize) {
            return;
        }

        int leftIndex = 2 * i;
        int rightIndex = 2 * i + 1;
        int largeIndex;

        if (leftIndex < heapSize && A[i] < A[leftIndex]) {
            largeIndex = leftIndex;
        } else {
            largeIndex = i;
        }

        if (rightIndex < heapSize && A[largeIndex] < A[rightIndex]) {
            largeIndex = rightIndex;
        }

        if (largeIndex == i) {
            return;
        }

        int tmp = A[largeIndex];
        A[largeIndex] = A[i];
        A[i] = tmp;

        maxHeapIfy(A, largeIndex);
    }

    private void sort(int[] A) {
        while (heapSize >= 2) {
            int tmp = A[heapSize - 1];
            A[heapSize - 1] = A[0];
            A[0] = tmp;
            heapSize--;
            maxHeapIfy(A, 0);
        }
    }

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();

        int[] A = {3, 4, 45, 67, 23, 13, 65};
        heapSort.heapSort(A);
        System.out.println(Arrays.toString(A));

        int[] B = {5,1,1,2,0,0};
        heapSort.heapSort(B);
        System.out.println(Arrays.toString(B));

    }
}
