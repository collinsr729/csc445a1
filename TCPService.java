import java.net.*;
import java.io.*;

public class TCPService {
  static final int PORT = 2792;
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(PORT);
      
      for (;;) {
        Socket client = serverSocket.accept();
        
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in =  
          new BufferedReader(new InputStreamReader(client.getInputStream()));

        String cmd = in.readLine();
        out.println(cmd.substring(0,4));

        out.close();
        in.close();
        client.close();
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
      System.exit(-1);
    }
  }
}
