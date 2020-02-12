import java.io.FileNotFoundException;

public class PasswordLog {
    public static void main(String[] args) throws FileNotFoundException {
        // Objects ->
        TitleScreen menu = new TitleScreen();
        Log logbook = new Log();

        menu.printScreen();
        logbook.runProgram();
    }
}
