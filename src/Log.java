import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Log {

    // objects ->
    File file = new File("passwords.txt");
    Scanner keyboard = new Scanner(System.in);
    Scanner fileInput = new Scanner(file);
    Text menu = new Text();

    // variables ->
    final String masterCode = "123";
    private ArrayList<String> sites = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    // constructor ->
    public Log() throws FileNotFoundException {
    }

    public int readFile() {
        int counter = 0;
        while (fileInput.hasNext()) {
            sites.add(fileInput.next());
            usernames.add(fileInput.next());
            passwords.add(fileInput.next());
            counter++;
        }
        fileInput.close();
        return counter;
    }

    public void runProgram() {
        int counter = readFile();
        System.out.print(menu.printMenuOptions());
        while (keyboard.hasNext()) {
            int userInput = keyboard.nextInt();
            switch (userInput) {
                // CASE 1 = print all the sites that have passwords saved
                case 1:
                    System.out.print(menu.printSitesHeading());
                    for (int i = 0; i < counter; i++) {
                        System.out.printf("%s%s%n", "~ ", sites.get(i));
                    }
                    break;
                // CASE 2 = print all info that is stored
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
                // CASE 3 = retrieve a specific username & password
                case 3:
                    break;
                // CASE 4 = add a new site, username, & password
                case 4:
                    break;
                // CASE 5 = change the master code for encryption and decryption
                case 5:
                    break;
                // CASE 6 = quits the running program
                case 6:
                    quitProgram();
                    break;
                // all other cases
                default:
                    System.out.println("input is not an option ... ");
                    System.out.println("try again ");
            }
            System.out.print(menu.printMenuOptions());
        }
    }

    public void quitProgram() {
        System.out.print(menu.printQuitScreen());
        keyboard.close();
        System.exit(0);
    }
}
