import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CaesarC {
    public static void Cezari() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to CaesarCipher");
        System.out.println();
        System.out.println("Enter 1 to Encipher, 2 to Decipher, or -1 to exit");
        int i;
        do  // checks for input to run correct method
        {
            i = input.nextInt();
            if (i == 1) {
                System.out.println("What shift should be used?"); // input shift
                int shift = input.nextInt();
                System.out.println("What is the input file name?"); // input name of file
                String file = input.next();
                System.out.println("What is the output file name?"); // input new file name
                String out = input.next();
                System.out.println(caesarEncipher(file, shift, out));  // run encipher method
            } else if (i == 2) {
                System.out.println("What shift should be used?");  // input shift
                int shift = input.nextInt();
                System.out.println("What is the input file name?"); // input name of file
                String file = input.next();
                System.out.println("What is the output file name?"); // input new file name
                String out = input.next();
                System.out.println(caesarDecipher(file, shift, out)); // run decipher method
            } else if (i == -1) {
                System.out.println("Thank you for using CaesarCipher");  // end program
                break;
            }
        }
        while (i != 1 && i != 2 && i != -1);
    }
