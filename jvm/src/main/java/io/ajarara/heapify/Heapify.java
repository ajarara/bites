package io.ajarara.tarjan;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Heapify {

    public static void heapify(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

    private static void siftDown(int[] arr, int i, int bound) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < bound && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < bound && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            siftDown(arr, largest, bound);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    private static Iterator<Integer> values(int[] heap) {
        return new Iterator<Integer>() {
            private int bound = heap.length - 1;

            public boolean hasNext() {
                return bound != -1;
            }

            public Integer next() {
                int next = heap[0];
                swap(heap, 0, bound);
                siftDown(heap, 0, bound);
                bound--;
                return next;
            }
        };
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        heapify(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> sorted = new ArrayList<>();
        values(arr).forEachRemaining(sorted::add);
        System.out.println(sorted);
    }
}
