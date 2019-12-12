import java.util.Arrays;
public class Sorting {
    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for(int i = 0; i < n2; i++)
            right[i] = arr[m + 1 + i];
            
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else
                arr[k++] = right[j++];
        }

        while(i < n1)
            arr[k++] = left[i++];
        while(j < n2)
            arr[k++] = right[j++];
    }

    public void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
    
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n - 1; i++) {
            swapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) //daca nu s a facut nicio interschimbare in prima iteratie, atunci vectorul e sortat
                break;
        }
    }

    public void insertionSort(int[] arr) {
        int minIndex;
        for(int i = 0; i < arr.length; i++) {
            //get index of minim
            minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //put min on first position of unsorted array
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            //current element
            int current = arr[i];
            int j = i - 1;
            //search for his correct place
            while(j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
