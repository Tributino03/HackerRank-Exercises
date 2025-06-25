/*
Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter, with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).

Your task is to write a program that creates or splits Camel Case variable, method, and class names.

Input Format

Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
The operation will either be S (split) or C (combine)
M indicates method, C indicates class, and V indicates variable
In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.
Output Format

For each input line, your program should print either the space-delimited list of words (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
Sample Input

S;M;plasticCup()

C;V;mobile phone

C;C;coffee machine

S;C;LargeSoftwareBook

C;M;white sheet of paper

S;V;pictureFrame

Sample Output

plastic cup

mobilePhone

CoffeeMachine

large software book

whiteSheetOfPaper()

picture frame

Explanation

Use Scanner to read in all information as if it were coming from the keyboard.

Print all information to the console using standard output (System.out.print() or System.out.println()).

Outputs must be exact (exact spaces and casing).
 */
import java.util.*;

public class CamelCase4 {



    public class Solution {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc  = new Scanner(System.in);

            while (sc.hasNextLine()) {
                String words = sc.nextLine();
                String[] separetionsInstructions = words.split(";");

                if (separetionsInstructions.length != 3) continue;

                if (separetionsInstructions[0].equals("S")) {
                    if (separetionsInstructions[1].equals("M")) {
                        separetionsInstructions[2] = separetionsInstructions[2].replace("()", "");
                        String word = separetionsInstructions[2].replaceAll("(?=[A-Z])", " ");
                        word = word.toLowerCase().trim();
                        System.out.println(word);
                    } else if (separetionsInstructions[1].equals("C") || separetionsInstructions[1].equals("V")) {
                        String word = separetionsInstructions[2].replaceAll("(?=[A-Z])", " ");
                        word = word.toLowerCase().trim();
                        System.out.println(word);
                    }
                } else if (separetionsInstructions[0].equals("C")) {
                    String[] word = separetionsInstructions[2].split(" ");
                    StringBuilder formattedWord = new StringBuilder();

                    if (separetionsInstructions[1].equals("M")) {
                        formattedWord.append(word[0].toLowerCase());
                        for (int c = 1; c < word.length; c++) {
                            formattedWord.append(word[c].substring(0, 1).toUpperCase());
                            formattedWord.append(word[c].substring(1).toLowerCase());
                        }
                        formattedWord.append("()");
                        System.out.println(formattedWord);
                    } else if (separetionsInstructions[1].equals("C")) {
                        for (String valueWord : word) {
                            formattedWord.append(valueWord.substring(0, 1).toUpperCase());
                            formattedWord.append(valueWord.substring(1).toLowerCase());
                        }
                        System.out.println(formattedWord);
                    } else if (separetionsInstructions[1].equals("V")) {
                        formattedWord.append(word[0].toLowerCase());
                        for (int c = 1; c < word.length; c++) {
                            formattedWord.append(word[c].substring(0, 1).toUpperCase());
                            formattedWord.append(word[c].substring(1).toLowerCase());
                        }
                        System.out.println(formattedWord);
                    }
                }
            }
        }
    }
}
