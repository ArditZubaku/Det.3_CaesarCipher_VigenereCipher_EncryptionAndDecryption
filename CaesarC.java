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
    public static String caesarEncipher(String input, int shift, String out) throws FileNotFoundException {
        File newfile = new File(out);
        PrintStream encoded = new PrintStream(newfile);  // creates new file
        File reader = new File(input);  // creates file to scan
        Scanner in = new Scanner(reader); // creates scanner
        while (in.hasNextLine())  // runs while the file has another line
        {
            String word = in.nextLine();            // gets next line of file
            String cipher = word.toUpperCase();     // makes all letters uppercase
            String encipher = "";                   // String to be written into new file
            int loop;
            for (loop = 0; loop < cipher.length(); loop++) // loops through the line to check each character
            {
                char curr = cipher.charAt(loop);  // current character
                char newChar = crypt(curr, shift);  // runs through crypt method (Below)
                encipher = encipher + newChar; // adds the new character to outgoing string
            }
            encoded.println(encipher);
        }
        encoded.close();
        return "DONE";
    }
      public static String caesarDecipher(String input, int shift, String out) throws FileNotFoundException {
        PrintStream decoded = new PrintStream(out);
        File read = new File(input);
        Scanner in = new Scanner(read);
        while (in.hasNextLine()) {
            String word = in.nextLine();
            word = word.toUpperCase();
            String cipher = word;
            String decipher = "";
            int loop;
            for (loop = 0; loop < cipher.length(); loop++) {
                char curr = cipher.charAt(loop);
                char newChar = decrypt(curr, shift);
                decipher = decipher + newChar;
            }
            decoded.println(decipher);
        }
        decoded.close();
        return "DONE";
    }

       public static char crypt(char c, int shift) {
        char encrypted = c;  // character passed in from for loop
        int alter = shift; // shift passed in
        if (Character.isLetter(encrypted)) // checks for only letters
        {
            int enc;
            if ((int) encrypted + alter > 91) // if ASCII value after altering is beyond 'Z' value, run this to loop back to 'A'
            {
                enc = encrypted - 65;
                enc += alter;
                enc = enc % 26;
                enc += 65;
                encrypted = (char) enc;
            } else enc = encrypted + alter;
            encrypted = (char) enc;
        }
        return encrypted;
    }

    public static char decrypt(char c, int shift) {
        char decrypted = c;
        int alter = -shift;
        if (Character.isLetter(decrypted)) {
            int dec;
            if ((int) decrypted + alter < 65)  // if ASCII value after altering is below 'A' value, run this to correct overflow
            {
                dec = decrypted + 65;
                dec += alter;
                dec = dec % 26;
                dec += 65;
                decrypted = (char) dec;
            } else dec = decrypted + alter;
            decrypted = (char) dec;
        }
        return decrypted;
    }
}
