public class Text {
    private String titleOne;
    private String titleTwo;

    public void printTitleScreen() {
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
        System.out.println(titleOne);
        System.out.println(titleTwo);
    }

    public String printMenuOptions() {
        return "\n----------------------------------------------------\n" +
                "1.    CHECK ALL SITES USED\n" +
                "2.    PRINT ALL STORED INFO\n" +
                "3.    RETRIEVE USERNAME & PASSWORD\n" +
                "4.    ADD SITE, USERNAME, & PASSWORD\n" +
                "5.    CHANGE MASTER CODE\n" +
                "6.    QUIT\n" +
                "----------------------------------------------------\n\n> ";
    }

    public String printQuitScreen() {
        return "\n                ....................\n" +
                "                      CLOSING\n" +
                "                     PASSWORD\n" +
                "                        LOG\n" +
                "                ....................\n";
    }

    public String printSitesHeading(){
        return "\n----------------------------------------------------\n";
    }

    public String printAllInfoHeading() {
        return "";
    }
}

