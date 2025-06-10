import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float qauntityPositives = 0;
        float qauntityNegatives = 0;
        float quantityZero = 0;

        for(Integer valor : arr){
            if(valor > 0){
                qauntityPositives += 1;
            }
            else if(valor < 0){
                qauntityNegatives += 1;
            }
            else{
                quantityZero += 1;
            }
        }

        qauntityPositives = qauntityPositives / arr.size();
        qauntityNegatives = qauntityNegatives / arr.size();
        quantityZero = quantityZero / arr.size();

        System.out.printf("%.6f%n", qauntityPositives);
        System.out.printf("%.6f%n", qauntityNegatives);
        System.out.printf("%.6f%n", quantityZero);

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
