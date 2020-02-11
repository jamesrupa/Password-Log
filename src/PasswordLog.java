import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordLog {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("passwords.txt");
        Scanner userInput = new Scanner(System.in);
        Scanner fileInput = new Scanner(file);

        String titleOne =
        "    ____                                          __\n" +
        "   / __ \\____ ____________      ______  _________/ /\n" +
        "  / /_/ / __ `/ ___/ ___/ | /| / / __ \\/ ___/ __  /\n" +
        " / ____/ /_/ (__  |__  )| |/ |/ / /_/ / /  / /_/ /\n" +
        "/_/    \\__,_/____/____/ |__/|__/\\____/_/   \\__,_/";

        String titleTwo =
        "    __                __                __\n" +
        "   / /   ____  ____ _/ /_  ____  ____  / /__\n" +
        "  / /   / __ \\/ __ `/ __ \\/ __ \\/ __ \\/ //_/\n" +
        " / /___/ /_/ / /_/ / /_/ / /_/ / /_/ / ,<\n" +
        "/_____/\\____/\\__, /_.___/\\____/\\____/_/|_|\n" +
        "            /____/";

        System.out.println(titleOne);
        System.out.print(titleTwo);
    }
}
