import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] A = {1, 5, 6};
        int F = 4;
        int M = 3;

        int[] result = solution(A, F, M);

        for (int i = 0; i <result.length ; i ++){
            System.out.println(result[i]);
        }




    }

    public static int solutiontest(int[] A) {

        Arrays.sort(A);
        int max = A[A.length - 1];
        int index = 0;
        int[] numbersfrom1Tomax = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            numbersfrom1Tomax[i] = i;

        }
        boolean isOvenPlus1;
        for (int i = 0; i < A.length; i++) {
            ;
            isOvenPlus1 = numbersfrom1Tomax[i] == A[i];
            System.out.println(isOvenPlus1);
            if (!isOvenPlus1) {
                index = i;
            }

        }
        System.out.println(A[index]);


        return max + 1;
    }

    public static int solutiontest2(int A, int B, int C, int D) {
        int[] numbers = new int[4];
        numbers[0] = A;
        numbers[1] = B;
        numbers[2] = C;
        numbers[3] = D;
        int numbersOfHours = 0;
        List<Integer> h = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        StringBuilder hourToString = new StringBuilder();
        List<String> hours = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < numbers.length; k++) {
                    if (i == k || j == k) continue;
                    for (int l = 0; l < numbers.length; l++) {
                        if (i == l || j == l || k == l) continue;
                        int hour = numbers[i] * 10 + numbers[j];
                        int minute = numbers[k] * 10 + numbers[l];
                        if (hour < 24 && minute < 60) {
                            hourToString.append(String.valueOf(hour)).append(":").append(String.valueOf(minute));
                            if (!hours.contains(hourToString.toString())) {
                                hours.add(hourToString.toString());

                                numbersOfHours++;
                            }
                            hourToString = new StringBuilder();


                        }
                    }
                }
            }
        }
        return numbersOfHours;

    }

    public static int solutiontest3(String coins) {
        int numberOfB = 0;
        int numberOfS = 0;
        int numberOfG = 0;

        char[] coinsToCharArray = coins.toCharArray();

        for (char c : coinsToCharArray) {
            if (c == 'G') {
                numberOfG += 1;
            } else if (c == 'S') {
                numberOfS += 1;
            } else if (c == 'B') {
                numberOfB += 1;
            }
        }

        int bronzeToSilverCoins = (int) (numberOfB / 3);
        int numberOfSilverCoins = numberOfS + bronzeToSilverCoins;
        int silverToGoldCoins = (int) (numberOfSilverCoins / 3);
        int goldenCoins = numberOfG + silverToGoldCoins;
        return goldenCoins;


    }

    public static List<List<Integer>> sumOfFNumbers(int n, int f) {
        List<List<Integer>> result = new ArrayList<>();
        if (f == 1) {
            if (n <= 6) {  // Warunek, żeby n było mniejsze lub równe 6
                List<Integer> list = new ArrayList<>();
                list.add(n);
                result.add(list);
            }
        } else {
            for (int i = 1; i <= n - f + 1; i++) {
                if (i <= 6) {  // Warunek, żeby i było mniejsze lub równe 6
                    for (List<Integer> list : sumOfFNumbers(n - i, f - 1)) {
                        list.add(0, i);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    public static int[] solution(int[] A, int F, int M) {
        int sumKnowThrows = 0;
        for (int i : A) {
            sumKnowThrows += i;
        }
        int sumOfAllThrows = M * (A.length + F);

        int meanForggotThrows = sumOfAllThrows - sumKnowThrows;
        boolean checkThatCanBePossible = (meanForggotThrows >= F) && (meanForggotThrows <= F * 6);
        if (!checkThatCanBePossible) {
            return new int[]{0};
        }
        int iterator = 0;
        int[] result = new int[F];

        int remainingThrows = F;

        List<List<Integer>> resultList = new ArrayList<>(sumOfFNumbers(meanForggotThrows, F));

        //Arrays.sort(resultList.get(0));

        for (int i = 0; i < F; i++) {
                result[i] = resultList.get(0).get(i);



        }


        return result;


    }

    //        while (iterator != F){
//            if (meanForggotThrows >= 6){
//                result[iterator] = 6;
//                meanForggotThrows -=6;
//            } else if (meanForggotThrows == 5 && remainingThrows == 1) {
//                result[iterator] = 5;
//                meanForggotThrows -= 5;
//            }
//            else if (meanForggotThrows == 4 && remainingThrows == 1) {
//                result[iterator] = 4;
//                meanForggotThrows -= 4;
//            }
//            else if (meanForggotThrows == 3 && remainingThrows == 1) {
//                result[iterator] = 3;
//                meanForggotThrows -= 3;
//            } else if (meanForggotThrows == 2 && remainingThrows == 1) {
//                result[iterator] = 2;
//                meanForggotThrows -= 2;
//            }
//            else if (meanForggotThrows == 1) {
//                result[iterator] = 1;
//                meanForggotThrows -= 1;
//
//            }
}
