/*
    There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.

Example



There are  instances of ',  of '' and  of ''. For each query, add an element to the return array, .

Function Description

Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

string strings[n] - an array of strings to search
string queries[q] - an array of query strings
Returns

int[q]: an array of results for each query
Input Format

The first line contains and integer , the size of .
Each of the next  lines contains a string .
The next line contains , the size of .
Each of the next  lines contains a string .

Constraints



 .

Sample Input 1

CopyDownload
4
aba
baba
aba
xzxb
3
aba
xzxb
ab
Sample Output 1

2
1
0

Sample Input 2

CopyDownload
3
def
de
fgh
3
de
lmn
fgh
Sample Output 2

1
0
1

Sample Input 3

CopyDownload
13
abcde
sdaklfj
asdjf
na
basdn
sdaklfj
asdjf
na
asdjf
na
basdn
sdaklfj
asdjf
5
abcde
sdaklfj
asdjf
na
basdn
Sample Output 3

1
3
4
3
2
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SparseArrays {

    class Result {

        /*
         * Complete the 'matchingStrings' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. STRING_ARRAY strings
         *  2. STRING_ARRAY queries
         */

        public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
            // Write your code here
            List<Integer> numQueryOccurrences = new ArrayList<>();
            for(int i=0; i<queries.size(); i++){
                int queryCounts=0;
                for(int j=0; j<strings.size(); j++){
                    if(queries.get(i).equals(strings.get(j))){
                        queryCounts ++;
                    }
                }
                numQueryOccurrences.add(queryCounts);
            }
            return numQueryOccurrences;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            List<Integer> res = Result.matchingStrings(strings, queries);

            bufferedWriter.write(
                    res.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }



}
