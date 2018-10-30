public class Quicksort {
    /**
     * Time complexity : O(n log(n))
     * Space complexity : O(n)
     *
     * @param in
     */
    public static void sort(int[] in) {
        if (in.length == 0) {
            return;
        }

        quickSort(in, 0, in.length - 1);
    }

    private static void quickSort(int[] in, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(in, left, right);

        quickSort(in, left, index - 1);
        quickSort(in, index + 1 , right);
    }

    private static int partition(int[] in, int left, int right) {
        int pivot = in[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (in[j] < pivot) {
                swap(in, i, j);
                i++;
            }
        }

        swap(in, i, right);

        return i;
    }

    private static void swap(int[] in, int a, int b) {
        int tmp = in[a];
        in[a] = in[b];
        in[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 39, 7, 7, 11, 15, 9, 57, 0, 34};

        Quicksort.sort(nums);

        for (int r : nums) {
            System.out.println(r);
        }
    }
}
