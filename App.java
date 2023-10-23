import java.util.ArrayList;

public class SortingComparison {
    public static void main(String[] args) {
        ArrayList<Integer> listToSort = new ArrayList<>();
        listToSort.add(5);
        listToSort.add(2);
        listToSort.add(9);
        listToSort.add(3);
        listToSort.add(6);

        System.out.println("Original List: " + listToSort);

        ArrayList<Integer> bubbleSorted = bubbleSort(new ArrayList<>(listToSort));
        System.out.println("Bubble Sorted: " + bubbleSorted);

        ArrayList<Integer> mergeSorted = mergeSort(new ArrayList<>(listToSort));
        System.out.println("Merge Sorted: " + mergeSorted);
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return list;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        int n = list.size();
        if (n <= 1) {
            return list;
        }

        int mid = n / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, n));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}

