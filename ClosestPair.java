import java.util.Arrays;

public class ClosestPair {

    public static void closestPair(int[] x, int[] y) {
        closestPairHelper(x, y, 0, x.length - 1);
    }

    private static void closestPairHelper(int[] x, int[] y, int left, int right) {
        if (right - left + 1 <= 3) {
            bruteForceClosestPair(x, left, right);
        } else {
            int mid = (left + right) / 2;
            int[] leftX = Arrays.copyOfRange(x, left, mid + 1);
            int[] rightX = Arrays.copyOfRange(x, mid + 1, right + 1);

            closestPairHelper(leftX, y, left, mid);
            closestPairHelper(rightX, y, mid + 1, right);
        }
    }

    private static void bruteForceClosestPair(int[] x, int left, int right) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                int[] y = new int[0];
                double dist = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                minDist = Math.min(minDist, dist);
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 3, 7, 9};
        int[] y = {2, 3, 8, 6, 10};

        closestPair(x, y);
    }
}
