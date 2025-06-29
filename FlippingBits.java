/*
    You will be given a list of 32 bit unsigned integers. Flip all the bits ( and ) and return the result as an unsigned integer.

Example

. We're working with 32 bits, so:



Return .

Function Description

Complete the flippingBits function in the editor below.

flippingBits has the following parameter(s):

int n: an integer
Returns

int: the unsigned decimal integer result
Input Format

The first line of the input contains , the number of queries.
Each of the next  lines contain an integer, , to process.

Constraints



Sample Input

3
2147483647
1
0
Sample Output

2147483648
4294967294
4294967295
Explanation

Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and doing the flipping we get 11111111111111111111111111111110 which in turn is 4294967294.
 */

import java.io.*;
import java.util.stream.IntStream;

public class FlippingBits {

    class Result {

        /*
         * Complete the 'flippingBits' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static long flippingBits(long n) {
            // Write your code here
            String binary = Long.toBinaryString(n);
            int lenghtBinary = binary.length();
            lenghtBinary = 32 - lenghtBinary;
            String leftZero = "";
            for(int i=0; i<lenghtBinary; i++){
                leftZero = leftZero.concat("0");
            }
            leftZero = leftZero.concat(binary);
            String newBinary = "";
            for(int i=0; i<leftZero.length(); i++){
                if(leftZero.charAt(i) == '0'){
                    newBinary = newBinary + "1";
                }else{
                    newBinary = newBinary + "0";
                }
            }
            long newDecimal = Long.parseLong(newBinary,2);
            return newDecimal;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    long n = Long.parseLong(bufferedReader.readLine().trim());

                    long result = Result.flippingBits(n);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
