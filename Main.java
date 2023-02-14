import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        argHandler arguments = new argHandler(args);
        arguments.checkArgs();
        getHttp target = new getHttp(arguments.getUrl());
        target.pingHost();
        target.setPort(arguments.getPort());
        brute bruteforce = new brute(target, arguments.getWordlist());
        bruteforce.read();
    }
}