public class Sorting {

private void buildMaxHeap(int[] arr, int n, int i) {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < n && arr[l] > arr[max]) {
            max = l;
        }
        if(r < n && arr[r] > arr[max]) {
            max = r;
        }

        if(max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            buildMaxHeap(arr, n, max);
        }
    }

    public void heapSort(int[] arr) {
        int n = arr.length;

        //build max heap
        for(int i = n / 2 - 1; i >= 0; i--) {
            buildMaxHeap(arr, n, i);
        }


        //swap first and last then remove last node and rebuild maxheap
        for(int i = n - 1; i>=0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            buildMaxHeap(arr, i, 0);
        }

    }
}
