import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Log {

    // objects ->
    File file = new File("passwords.txt");
    Scanner keyboard = new Scanner(System.in);
    Scanner fileInput = new Scanner(file);
    PrintStream output = new PrintStream(new FileOutputStream(file, true));
    Text menu = new Text();

    // variables ->
    String masterKey, masterKeyAttempt;
    public int counter = 0;
    private ArrayList<String> sites = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    // constructor ->
    public Log() throws FileNotFoundException {
    }

    public int readFile() {
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
                    System.out.print(menu.printHeading());
                    System.out.print("ALL INFO STORED\nEnter Master Key: ");
                    masterKeyAttempt = keyboard.next();
                    if (masterKeyAttempt.equals(masterKey)) {
                        System.out.print("ALL STORED INFORMATION\n");
                        for (int i = 0; i < counter; i++) {
                            System.out.printf("%s%s%25s%25s%n", "~ ", sites.get(i), usernames.get(i), AES.decrypt(passwords.get(i), masterKey));
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                    }
                    break;
                // CASE 3 = retrieve a specific username & password
                case 3:
                    System.out.print(menu.printHeading());
                    System.out.print("PASSWORD FINDER\nEnter Master Key: ");
                    masterKeyAttempt = keyboard.next();
                    if (masterKeyAttempt.equals(masterKey)) {
                        System.out.print("Enter site: ");
                        String siteInput = keyboard.next();
                        for (int i = 0; i < counter; i++) {
                            if (siteInput.equals(sites.get(i))) {
                                System.out.printf("%s%s%n%s%s", "Username: ", usernames.get(i), "Password: ", AES.decrypt(passwords.get(i), masterKey));
                            }
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                        break;
                    }
                    break;
                // CASE 4 = add a new site, username, & password
                case 4:
                    System.out.print(menu.printHeading());
                    System.out.print("ADD INFO TO LOGBOOK\nSite URL: ");
                    sites.add(keyboard.next());
                    System.out.print("Username: ");
                    usernames.add(keyboard.next());
                    System.out.print("Password: ");
                    passwords.add(AES.encrypt(keyboard.next(), masterKey));
                    int element = sites.size() - 1;
                    counter++;
                    output.print("\n" + sites.get(element)+ "                    " + usernames.get(element) +
                            "                    " + passwords.get(element));
                    System.out.printf("%n%s%s", "SUCCESSFULLY LOGGED new user from ", sites.get(element));
                    break;
                // CASE 5 = change a site, username, & password
                case 5:
                    int lineNumber = 0;
                    System.out.print(menu.printHeading());
                    System.out.print("CHANGE STORED INFO\nEnter Master Key: ");
                    masterKeyAttempt = keyboard.next();
                    if (masterKeyAttempt.equals(masterKey)) {
                        System.out.print("Enter site: ");
                        String siteInput = keyboard.next();
                        for (int i = 0; i < counter; i++) {
                            lineNumber++;
                            if (siteInput.equals(sites.get(i))) {
                                System.out.print("Enter new username: ");
                                String newUser = keyboard.next();
                                System.out.print("Enter new password: ");
                                String newPass = AES.encrypt(keyboard.next(), masterKey);
                                usernames.set(i, newUser);
                                passwords.set(i, newPass);
                                Path path = Paths.get("passwords.txt");
                                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                                lines.set(lineNumber, sites.get(i) + "                    "+ usernames.get(i) + "                    " + passwords.get(i));
                                Files.write(path, lines, StandardCharsets.UTF_8);
                                System.out.print("Succesfully changed info about " + siteInput);
                                break;
                            }
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                        break;
                    }
                    break;
                // CASE 6 = remove a site, username, & password
                case 6:
                    int anotherLineNumber = 0;
                    System.out.print(menu.printHeading());
                    System.out.print("REMOVE STORED INFO\nEnter Master Key: ");
                    masterKeyAttempt = keyboard.next();
                    if (masterKeyAttempt.equals(masterKey)) {
                        System.out.print("Enter site: ");
                        String siteInput = keyboard.next();
                        for (int i = 0; i < counter; i++) {
                            anotherLineNumber++;
                            if (siteInput.equals(sites.get(i))) {
                                Path path = Paths.get("passwords.txt");
                                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                                lines.set(anotherLineNumber, "");
                                Files.write(path, lines, StandardCharsets.UTF_8);
                                System.out.print("Succesfully deleted info about " + siteInput);
                                sites.remove(i);
                                usernames.remove(i);
                                passwords.remove(i);
                                counter--;
                                break;
                            }
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                        break;
                    }
                    break;
                // CASE 7 = change the master key for encryption and decryption
                case 7:
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
                            AES.setNewMaterkey(1, masterKey);
                            System.out.print("\nMASTER KEY HAS BEEN CHANGED");
                        } else {
                            System.out.print(menu.printIncorrect());
                        }
                    } else {
                        System.out.print(menu.printIncorrect());
                    }
                    break;
                // CASE 8 = quits the running program
                case 8:
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