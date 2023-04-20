import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println (Result.func(3,5));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.maxMagicSums(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'maxMagicSums' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int maxMagicSums(List<Integer> arr) {
        Collections.sort(arr);

        int maxPositiveCount = 0;
        int currentSum = 0;



            List<Integer> magicSumList = new ArrayList<> ();

            Collections.sort (arr);


            for (int i = 0; i < arr.size (); i++) {
                currentSum += arr.get (i);
                System.out.println (arr.get (i));
                magicSumList.add (currentSum);

            }

            for (Integer i : magicSumList){
                System.out.println (i);
                if (i >= 0){
                    maxPositiveCount +=1;
                }
            }


    return  maxPositiveCount;


    }

    public static int func(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int temp = func(a, b / 2);
        if (b % 2 != 0) {
            return temp * temp * a;
        } else {
            return temp * temp;
        }
    }

}