
public class array {

    public static void main(String[] args) {
        int data[] = {1, 80, 22, 134, 0, 33, 93, 45, 33, 12};
        int sum = 0;
        float mean;
        int minimal = data[0];
        int maximal = data[0];
        // Count value from index of array
        for (int i : data) {
            sum += i;
            if (i <= minimal) {
                minimal = i;
            }
            if (i > maximal) {
                maximal = i;
            }
        }
        mean = (float) sum / data.length;
        System.out.println("Sum = " + sum);
        System.out.println("Mean = " + mean);
        System.out.println("Minimal = " + minimal);
        System.out.println("Maximal = " + maximal);
    }
}
