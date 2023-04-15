import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {

    }

    public static int solution(String S) {

        int upCount = (int) S.chars().filter(ch -> ch == '^').count();
        int downCount = (int) S.chars().filter(ch -> ch == 'v').count();
        int leftCount = (int) S.chars().filter(ch -> ch == '<').count();
        int rightCount = (int) S.chars().filter(ch -> ch == '>').count();


        int maxCount = Math.max(Math.max(upCount, downCount), Math.max(leftCount, rightCount));


        int totalArrows = S.length();


        int minRotations = totalArrows - maxCount;

        return minRotations;
    }

    public static int solution2(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : A) {
            int firstDigit = String.valueOf(num).charAt(0) - '0';
            int lastDigit = num % 10;
            int key = firstDigit * 10 + lastDigit;

            if (map.containsKey(key)) {
                int sum = map.get(key) + num;
                maxSum = Math.max(maxSum, sum);
            }

            map.put(key, Math.max(map.getOrDefault(key, 0), num));
        }

        return maxSum;
    }


}