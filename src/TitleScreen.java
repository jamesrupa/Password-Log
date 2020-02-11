public class TitleScreen {
    private String titleOne;
    private String titleTwo;

    // constructor ->
    public TitleScreen() {
        titleOne =
                "    ____                                          __\n" +
                "   / __ \\____ ____________      ______  _________/ /\n" +
                "  / /_/ / __ `/ ___/ ___/ | /| / / __ \\/ ___/ __  /\n" +
                " / ____/ /_/ (__  |__  )| |/ |/ / /_/ / /  / /_/ /\n" +
                "/_/    \\__,_/____/____/ |__/|__/\\____/_/   \\__,_/";
        titleTwo =
                "    __                __                __\n" +
                "   / /   ____  ____ _/ /_  ____  ____  / /__\n" +
                "  / /   / __ \\/ __ `/ __ \\/ __ \\/ __ \\/ //_/\n" +
                " / /___/ /_/ / /_/ / /_/ / /_/ / /_/ / ,<\n" +
                "/_____/\\____/\\__, /_.___/\\____/\\____/_/|_|\n" +
                "            /____/";
    }

    public void printScreen() {
        System.out.println(titleOne);
        System.out.println(titleTwo);
    }
}
