import java.io.*;
import java.net.*;

public class getHttp {
    private URL url = null;
    private boolean secure = false;
    private int timeout = 200;
    private int port = 80;
    public getHttp(String url)  {
        try{
            this.url = new URL(url);
        }catch (MalformedURLException e){
            System.err.println("\n[Error]: Provide Http/Https scheme");
            System.exit(0);
        }
    }

    public void setPort(int port){
        this.port = port;
    }
    public int getCode() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(this.timeout);
            connection.setReadTimeout(this.timeout);
            connection.connect();
            return connection.getResponseCode();

        } catch (IOException e) {
            return 0;
        }
    }

    public void checkPath(String path){
        HttpURLConnection connection = null;
        try{
            connection = (HttpURLConnection) new URL(new String(this.url.getProtocol()+"://"+this.url.getHost()+"/"+path)).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(this.timeout);
            connection.setReadTimeout(this.timeout);
            connection.connect();
            if ((connection.getResponseCode() != 404)){
                System.out.println("--------\nFound: /"+path+"\nStatus Code:"+connection.getResponseCode()+"\nResponse Message:"+connection.getResponseMessage());

            }
        } catch (IOException e){
            System.err.println("Error "+new String(this.url.getProtocol()+this.url.getHost()+"/"+path));
        }
    }


    public boolean pingHost() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(this.url.getHost(), this.port), 400);
            return true;
        } catch (IOException e) {
            System.err.println("[Error]: Host unreachable");
            return false;
        }
    }
}
