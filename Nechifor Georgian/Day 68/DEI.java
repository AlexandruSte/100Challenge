import java.util.Arrays;

public class DEI {

    public static int binarySearch(int[] v, int key, int p, int q) {
        if (p > q)
            return -1;

        int m = (p + q) / 2;
        int pivot = v[m];

        if (pivot < key) {
            return binarySearch(v, key, m + 1, q);
        } else if (pivot > key) {
            return binarySearch(v, key, p, m - 1);
        } else
            return m;
    }

    private static void merge(int[] v, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = v[l + i];

        for (int i = 0; i < n2; i++)
            R[i] = v[m + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                v[k++] = L[i++];
            } else if (L[i] >= R[j]) {
                v[k++] = R[j++];
            }
        }

        while (i < n1)
            v[k++] = L[i++];
        while (j < n2)
            v[k++] = R[j++];
    }

    public static void mergeSort(int[] v, int p, int q) {
        if (p < q) {
            int m = p + (q - p) / 2;
            mergeSort(v, p, m);
            mergeSort(v, m + 1, q);
            merge(v, p, m, q);
        }
    }

    private static int partition(int[] v, int low, int high) {
        int pivot = v[high];
        int sm = low - 1;
        for (int i = low; i < high; i++) {
            if (v[i] <= pivot) {
                sm = sm + 1;

                int aux = v[i];
                v[i] = v[sm];
                v[sm] = aux;
            }
        }
        int aux = v[sm + 1];
        v[sm + 1] = v[high];
        v[high] = aux;

        return sm + 1;
    }

    public static void quickSort(int[] v, int low, int high) {
        if (low < high) {
            int q = partition(v, low, high);
            quickSort(v, low, q - 1);
            quickSort(v, q + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 3, 4, 7, 9, 11, 13};
        int key = 12;

        int indexForKey = binarySearch(v, key, 0, v.length - 1);
        System.out.println("Index for searched key is: " + indexForKey + ", v[" + indexForKey + "] = " + key);


        int[] arr = new int[]{38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, v.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{38, 27, 43, 3, 9, 82, 10};
        quickSort(arr, 0, v.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
