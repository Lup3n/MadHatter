import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class brute {
    private String word;
    private String wordlist;
    private getHttp target;

    public brute(getHttp target, String wordlist){
        this.wordlist = wordlist;
        this.target = target;

    }

    public void read() throws FileNotFoundException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.wordlist));
            for(String line; (line = in.readLine()) != null; ) {
                if (!(line.startsWith("#") || !(line.startsWith("")))) {
                    target.checkPath(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
