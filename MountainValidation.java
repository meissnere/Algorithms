//Given an array of integers arr, return true if and only if it is a valid mountain array.
//
//Recall that arr is a mountain array if and only if:
//
//    arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//    arr[0] < arr[1] < ... < arr[i - 1] < A[i]
//    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

public class MountainValidation {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};

        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int decreaseStart = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] > arr[i]) {
                continue;
            } else if (arr[i+1] == arr[i]) {
                return false;
            } else if (arr[i+1] < arr[i]) {
                decreaseStart = i;
                break;
            }
        }

        if (decreaseStart == 0) {
            return false;
        }

        for (int j = decreaseStart; j < arr.length - 1; j++) {
            if (arr[j+1] > arr[j]) {
                return false;
            } else if (arr[j+1] == arr[j]) {
                return false;
            } else if (arr[j+1] < arr[j]) {
                continue;
            }
        }

        return true;

    }
}
