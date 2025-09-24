import java.util.Arrays;

public class ClosestPair {

    // Start function – runs the closest pair search
    public static double closestPair(int[] x, int[] y) {
        return closestPairHelper(x, y, 0, x.length - 1);
    }

    // Recursive function (divide and conquer)
    private static double closestPairHelper(int[] x, int[] y, int left, int right) {
        // If 3 points or less, just brute force
        if (right - left + 1 <= 3) {
            return bruteForceClosestPair(x, y, left, right);
        } else {
            // Find the middle
            int mid = (left + right) / 2;

            // Split the x array into two halves
            int[] leftX = Arrays.copyOfRange(x, left, mid + 1);
            int[] rightX = Arrays.copyOfRange(x, mid + 1, right + 1);

            // Recursively solve left and right halves
            double distLeft = closestPairHelper(leftX, y, left, mid);
            double distRight = closestPairHelper(rightX, y, mid + 1, right);

            // Take the smaller distance from both halves
            return Math.min(distLeft, distRight);
        }
    }

    // Brute force: check every pair of points
    private static double bruteForceClosestPair(int[] x, int[] y, int left, int right) {
        double minDist = Double.MAX_VALUE; // start with "infinity"

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                // Distance formula between (x[i], y[i]) and (x[j], y[j])
                double dist = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));

                // Update min distance if we find smaller
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        // Example set of points
        int[] x = {0, 1, 3, 7, 9};
        int[] y = {2, 3, 8, 6, 10};

        // Run and print result
        double result = closestPair(x, y);
        System.out.println("Closest distance = " + result);
    }
}
