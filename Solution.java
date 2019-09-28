import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No arguments provided");
        }

        try {
            List<Integer> numbers = Arrays.stream(args[0].split(",")).map(Integer::parseInt).collect(Collectors.toList());        
            System.out.println("Min swaps: " + result(numbers));
            System.out.print("Resulting list: " + numbers.toString());
        }
        catch (Exception e) {
            System.err.println("Provide valid argument eg: 2,4,5,3,9");
        }
    }

    public static int result(List<Integer> a) {
        int left = 0;
        int right = a.size() - 1;
        int swaps = 0;
        while (left <= right) {
            if (a.get(left)%2 == 0) {
                left++;
                continue;
            }
            if (a.get(right)%2 != 0) {
                right--;
                continue;
            }
            Collections.swap(a, left, right);
            swaps++;
        }
        return swaps;
    }
}