import java.io.FileNotFoundException;

public class PasswordLog {
    public static void main(String[] args) throws FileNotFoundException {
        // Objects ->
        TitleScreen menu = new TitleScreen();
        Log logbook = new Log();
        AES aes = new AES();

        menu.printScreen();
        logbook.runProgram();

        /*
        final String secretKey = "jamesrupa";

        String originalString = "23912344";
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
        */
    }
}
