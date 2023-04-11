package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static org.example.AllCombinations.maxSumOfHeights;

class AllCombinations {

    public static int maxSumOfHeights (ArrayList<Integer> heights, ArrayList<Integer> widths, int N, int M, int index, int currentWidth) {
        if (index == N) {
            return 0;
        }


        int exclude = maxSumOfHeights (heights, widths, N, M, index + 1, currentWidth);


        int include = 0;
        if (currentWidth + widths.get (index) <= M) {
            include = heights.get (index) + maxSumOfHeights (heights, widths, N, M, index + 1, currentWidth + widths.get (index));
        }


        return Math.max (exclude, include);
    }
}




public class Main {
    public static void main (String[] args) throws IOException {


        String input;
        String ducksProperties;
        ArrayList<Integer> heights = new ArrayList<> ();
        ArrayList<Integer> widths = new ArrayList<> ();


        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
        input = bufferedReader.readLine ();
        String[] duckInputs = input.split (" ");
        int numbersOfAvailableDucks = Integer.parseInt (duckInputs[0]);
        int maxRowWidth = Integer.valueOf (duckInputs[1]);


        for (int i = 0; i < numbersOfAvailableDucks; i++) {
            ducksProperties = bufferedReader.readLine ();
            String[] heightAndWidth = ducksProperties.split (" ");
            int height = Integer.parseInt (heightAndWidth[0]);
            int width = Integer.parseInt (heightAndWidth[1]);
            widths.add (width);
            heights.add (height);
        }


        int maxSum = maxSumOfHeights (heights, widths, numbersOfAvailableDucks, maxRowWidth, 0, 0);


        System.out.println (maxSum);
    }


}
