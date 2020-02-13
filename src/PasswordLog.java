import java.io.IOException;

public class PasswordLog {
    public static void main(String[] args) throws IOException {
        // Objects ->
        Text screen = new Text();
        Log logbook = new Log();

        screen.printTitleScreen();
        logbook.runProgram();
    }
}
