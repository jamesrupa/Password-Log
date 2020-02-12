import java.io.FileNotFoundException;

public class PasswordLog {
    public static void main(String[] args) throws FileNotFoundException {
        // Objects ->
        Text screen = new Text();
        Log logbook = new Log();

        screen.printTitleScreen();
        logbook.runProgram();
    }
}
