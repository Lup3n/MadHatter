public class argHandler {
    private String[] args;
    private String url = null;
    private String wordlist = null;
    private int port = 80;

    public argHandler(String[] args){
        this.args = args;
    }
    public String getUrl(){
        return url;
    }
    public String getWordlist(){
        return wordlist;
    }
    public int getPort(){
        return port;
    }
    private void help(){
        String banner =
                " __  __              _             _  _             _       _                     \n"+
                "|  \\/  |  __ _    __| |     o O O | || |   __ _    | |_    | |_     ___      _ _  \n"+
                "| |\\/| | / _` |  / _` |    o      | __ |  / _` |   |  _|   |  _|   / -_)    | '_| \n"+
                "|_|__|_| \\__,_|  \\__,_|   TS__[O] |_||_|  \\__,_|   _\\__|   _\\__|   \\___|   _|_|_  \n"+
                "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|\n"+
                "\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \n" +
                " --url, -u <url>                                   Set Target Url\n"+
                " --wordlist, -w <Path>                             Set Wordlist\n";

        System.out.print(banner);
        System.exit(0);
    }



    public void checkArgs(){
        if (args.length <= 1) {
            help();
        } else{
            for (int i = 0; i < args.length; i++){
                switch(args[i]){
                    case "--help", "-h":
                        help();
                        break;
                    case "--url", "-u":
                        this.url = args[i+1];
                        System.out.println("url: "+args[i+1]);
                        break;
                    case "--wordlist", "-w":
                        this.wordlist = args[i+1];
                        System.out.println("wordlist: "+args[i+1]);
                        break;
                    case "--port", "-p":
                        this.port = Integer.parseInt(args[i+1]);
                        System.out.println("port: "+args[i+1]);
                        break;
                }
            }
        }

    }
}
