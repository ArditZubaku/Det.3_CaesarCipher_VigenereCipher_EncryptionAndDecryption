import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class VigenereC {

    public static void Vigenere() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vigenere");
        System.out.println();
        System.out.println("Enter 1 to Encipher, 2 to Decipher, or -1 to exit");
        int i;
        do  // checks for input to run correct method
        {
            i = input.nextInt();
            if (i == 1) {
                System.out.println("Enter the key in UPPER case?"); // input key
                String key = input.next();
                System.out.println("What is the input file name?"); // input name of file
                String file1 = input.next();
                System.out.println("What is the output file name?"); // input new file name
                String out = input.next();
                System.out.println(vigenereEncipher(file1, key, out));  // run encipher method
            } else if (i == 2) {
                System.out.println("Enter the key in UPPER case?"); // input key
                String key = input.next();
                System.out.println("What is the input file name?"); // input name of file
                String file1 = input.next();
                System.out.println("What is the output file name?"); // input new file name
                String out = input.next();
                System.out.println(vigenereDecipher(file1, key, out)); // run decipher method
            } else if (i == -1) {
                System.out.println("Thank you for using VigenereCipher");  // end program
                break;
            }
        }
        while (i != 1 && i != 2 && i != -1);
    }
    
public static String vigenereEncipher(String input, String key, String out) throws FileNotFoundException {
        File newfile1 = new File(out);
        PrintStream encoded = new PrintStream(newfile1);  // creates new file
        File reader = new File(input);  // creates file to scan
        Scanner in = new Scanner(reader); // creates scanner
        while (in.hasNextLine())  // runs while the file has another line
        {
            String word = in.nextLine();            // gets next line of file
            String cipher = word.toUpperCase();     // makes all letters uppercase
            String encipher = "";                   // String to be written into new file
            for (int loop = 0, j = 0; loop < cipher.length(); loop++) // loops through the line to check each character
            {
                char letter = cipher.charAt(loop);// current character
                if (letter == ' ') {
                    encipher = encipher + ' ';
                    continue;
                }
                if (letter < 'A' || letter > 'Z') continue;
                int asciiValue = (((letter - 65) + (key.charAt(j) - 65)) % 26 + 65);
                char newChar = (char) asciiValue;
                j = ++j % key.length();
                encipher += newChar; // adds the new character to outgoing string
            }
            encoded.println(encipher);
        }
        encoded.close();
        return "DONE";
    }
public static String vigenereDecipher(String input, String key, String out) throws FileNotFoundException {
        PrintStream decoded = new PrintStream(out);
        File read = new File(input);
        Scanner in = new Scanner(read);
        while (in.hasNextLine()) {
            String word = in.nextLine();
            word = word.toUpperCase();
            String cipher = word;
            String decipher = "";
            for (int loop = 0, j = 0; loop < cipher.length(); loop++) {
                char letter = cipher.charAt(loop);
                if (letter == ' ') {
                    decipher += ' ';
                    continue;
                }
if (letter < 'A' || letter > 'Z') continue;
                int asciiValue = ((letter - key.charAt(j) + 26) % 26 + 65);
                char newChar = (char) (asciiValue);
                j = ++j % key.length();
                decipher += newChar;
            }
            decoded.println(decipher);
        }
        decoded.close();
        return "DONE";
    }
}
