public class Sorting {

private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for(int j = l; j < r; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i + 1;
    }

    public void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = partition(arr, l, r);
            quickSort(arr, l, m-1);
            quickSort(arr, m+1, r);
        }
    }
}
