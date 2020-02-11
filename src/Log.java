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
    private ArrayList<String> sites = new ArrayList<>();
    private String menuOptions;

    // constructor ->
    public Log() throws FileNotFoundException {
        menuOptions =
                "\n\n1.    CHECK ALL SITES\n" +
                "2.    CHECK SPECIFIC SITE\n" +
                "3.    QUIT\n";
    }

    public void runProgram() {
        System.out.println(menuOptions);
        while (keyboard.hasNext()) {
            int userInput = keyboard.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("option 1");
                    break;
                case 2:
                    System.out.println("option 2");
                    break;
                case 3:
                    System.out.println("option 3");
                    quitProgram();
                    break;
                default:
                    System.out.println("NOT AN OPTION");
            }
            System.out.println(menuOptions);
        }
    }



    public void quitProgram() {
        System.out.println("Thank you for using program");
        System.exit(0);
    }


}
