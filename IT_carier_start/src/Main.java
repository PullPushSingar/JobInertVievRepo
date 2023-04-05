public class Main {
    public static void main(String[] args) {
       printFibonachi(9);
    }

    public static String buildSubstring(String s){

        char[] stringToCharArray = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : stringToCharArray){
            if (!isContain(result.toString(),c)) {
                result.append(c);
            }
            else result = new StringBuilder();

        }

        return result.toString();

    }

    public static boolean isContain(String s,char character){

        char[] stringToCharArray = s.toCharArray();

        for (char c : stringToCharArray){
            if(c == character) {
                return true;
            }

        }
         return false;

    }

    public  static int recursiveFibonachi(int numberOfElement){
        int value = 0;
        if (numberOfElement <= 1)
            value = numberOfElement;
        else
            value = recursiveFibonachi((numberOfElement - 1)) + recursiveFibonachi(numberOfElement - 2);


        return value;

    }

    public static void printFibonachi(int numberOfElement){

        System.out.println(recursiveFibonachi(numberOfElement));
    }

}


