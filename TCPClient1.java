import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;

public class TCPClient1 {
    static Instant start;
    static Instant end;

    public static void run(int numBytes) {
        String host = "gee.cs.oswego.edu";
        int echoServicePortNumber = 2790;

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(host, echoServicePortNumber);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            byte[] bytes = new byte[numBytes];
            Arrays.fill(bytes, (byte) 42);
            String toSend = new String(bytes);
            start = Instant.now();
            out.println(toSend);
            System.out.println(in.readLine().equals(toSend));
            end = Instant.now();


            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
