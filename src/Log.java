import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Log {

    // objects ->
    File file = new File("passwords.txt");
    Scanner keyboard = new Scanner(System.in);
    Scanner fileInput = new Scanner(file);

    // variables ->
    final String masterCode = "123";
    private ArrayList<String> sites = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private String menuOptions;

    // constructor ->
    public Log() throws FileNotFoundException {
        menuOptions =
                "\n\n1.    CHECK ALL SITES\n" +
                "2.    CHECK SPECIFIC SITE\n" +
                "3.    QUIT\n> ";
    }

    public int readFile() {
        int counter = 0;
        while (fileInput.hasNext()) {
            sites.add(fileInput.next());
            passwords.add(fileInput.next());
            counter++;
        }
        fileInput.close();
        return counter;
    }

    public void runProgram() {
        int counter = readFile();
        System.out.print(menuOptions);
        while (keyboard.hasNext()) {
            int userInput = keyboard.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println();
                    for (int i = 0; i < counter; i++) {
                        String encryptedString = AES.encrypt(passwords.get(i), masterCode);
                        System.out.printf("%s%35s%n", sites.get(i), encryptedString);
                    }
                    break;
                case 2:
                    System.out.print("\nSITE: ");
                    String inputSite = keyboard.next();
                    for (int i = 0; i < counter; i++) {
                        if (sites.get(i).equals(inputSite)) {
                            System.out.print("PASSWORD: " + passwords.get(i) + "\n");
                            break;
                        } else
                            System.out.print("SITE NOT FOUND\n");
                    }
                    break;
                case 3:
                    quitProgram();
                    break;
                default:
                    System.out.println("input is not an option ... ");
                    System.out.println("try again ");
            }
            System.out.print(menuOptions);
        }
    }

    public void quitProgram() {
        System.out.println("\n\n....................\n      CLOSING\n" +
                "     PASSWORD\n        LOG\n....................");
        keyboard.close();
        System.exit(0);
    }
}
