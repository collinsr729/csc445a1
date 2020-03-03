import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;

public class TCPClient2 {
    static Instant start;
    static Instant end;

    public static void run(int numMessages, int numBytes) {
//        TimeLimiter timeLimiter = new SimpleTimeLimiter();
        start = Instant.now();
        while (--numMessages >= 0) {
            String host = "gee.cs.oswego.edu";
            int echoServicePortNumber = 2792;
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(host, echoServicePortNumber);
                echoSocket.setSoTimeout(500);
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
                for(numMessages = numMessages; numMessages>0;numMessages--) {
                    out.println(toSend);
                    in.readLine();
                }
//                byte[] resp = echoSocket.getInputStream().readAllBytes();
//                if(resp!=null)
//                System.out.println(toSend.substring(0,4)+" "+Arrays.toString(resp));
                end = Instant.now();


                out.close();
                in.close();
                echoSocket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("Timeout");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
