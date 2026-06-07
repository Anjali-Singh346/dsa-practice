import java.util.*;

public class Majorirtyel {
    static ArrayList<Integer> getMajority(int arr[]) {
        Arrays.sort(arr);

        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n;) {
            int count = 1;
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            if (count > n / 3) {
                ans.add(arr[i]);
            }

            i++;
        }
        return ans;
    }

    // Optimized
    static ArrayList<Integer> getMajority2(int arr[]) {
        int count1 = 0;
        int count2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el1)
                count1++;

            else if (arr[i] == el2)
                count2++;

            else if (count1 == 0) {
                el1 = arr[i];
                count1 = 1;
            }

            else if (count2 == 0) {
                el2 = arr[i];
                count2 = 1;
            }

            else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el1) {
                count1++;
            } else if (arr[i] == el2) {
                count2++;
            }
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        if (count1 > n / 3) {
            arr1.add(el1);
        }
        if (count2 > n / 3) {
            arr1.add(el2);
        }
        return arr1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 2, 1, 3, 3, 2 };
        System.out.println(getMajority(arr));
        System.out.println(getMajority2(arr));

    }

}
