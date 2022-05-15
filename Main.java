import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        int cipher;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("1 - Caesar Cipher\n2 - Vigenere Cipher\n0 - per te perfunduar");
            System.out.println("Zgjedhni cilin cipher deshironi: ");

            cipher = input.nextInt();

            if (cipher == 1) {
                CaesarC.Cezari();
            } else if (cipher == 2) {
                VigenereC.Vigenere();
            } else break;
        }
        while (cipher != 0);

    }
}

