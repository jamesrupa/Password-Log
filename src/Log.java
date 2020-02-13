import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Log {

    // objects ->
    File file = new File("passwords.txt");
    Scanner keyboard = new Scanner(System.in);
    Scanner fileInput = new Scanner(file);
    PrintStream output = new PrintStream(new FileOutputStream(file, true));
    Text menu = new Text();
    AES aes = new AES();

    // variables ->
    String masterKey;
    private ArrayList<String> sites = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    // constructor ->
    public Log() throws FileNotFoundException {
    }

    public int readFile() {
        int counter = 0;
        masterKey = fileInput.next();
        while (fileInput.hasNext()) {
            sites.add(fileInput.next());
            usernames.add(fileInput.next());
            passwords.add(fileInput.next());
            counter++;
        }
        fileInput.close();
        return counter;
    }

    public void runProgram() throws IOException {
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
                    break;
                // CASE 3 = retrieve a specific username & password
                case 3:
                    break;
                // CASE 4 = add a new site, username, & password
                case 4:
                    System.out.print(menu.printHeading());
                    System.out.print("ADD INFO TO LOGBOOK\nSite URL: ");
                    sites.add(keyboard.next());
                    System.out.print("Username: ");
                    usernames.add(keyboard.next());
                    System.out.print("Password: ");
                    passwords.add(aes.encrypt(keyboard.next(), masterKey));
                    int element = sites.size() - 1;
                    output.print("\n" + sites.get(element)+ "                    " + usernames.get(element) +
                            "                    " + passwords.get(element));
                    System.out.printf("%n%s%s", "SUCCESSFULLY LOGGED new user from ", sites.get(element));
                    break;
                // CASE 5 = change the master key for encryption and decryption
                case 5:
                    System.out.print(menu.printHeading());
                    System.out.print("CHANGE MASTER KEY\nCurrent Master Key: ");
                    String inputKey = keyboard.next();
                    if (inputKey.equals(masterKey)) {
                        System.out.print("\nNew Master Key: ");
                        String tempMasterKeyOne = keyboard.next();
                        System.out.print("Re-enter New Master Key: ");
                        String tempMasterKeyTwo = keyboard.next();
                        if (tempMasterKeyOne.equals(tempMasterKeyTwo)) {
                            masterKey = tempMasterKeyOne;
                            aes.setNewMaterkey(1, masterKey);
                            System.out.print("\nMASTER KEY HAS BEEN CHANGED");
                        } else {
                            System.out.print(menu.printIncorrect());
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                    }
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
