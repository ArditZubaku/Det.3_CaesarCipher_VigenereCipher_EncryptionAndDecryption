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
