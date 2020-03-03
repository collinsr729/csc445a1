import java.io.*;
import java.lang.invoke.VarHandle;
import java.net.*;
import java.time.Duration;
import java.time.Instant;

public class EchoClientv2 {
    public static void main(String[] args) {
//        String host = "gee.cs.oswego.edu";
//        int echoServicePortNumber = 2790;
//
//        Socket echoSocket = null;
//        PrintWriter out = null;
//        BufferedReader in = null;
//
//        try {
//            echoSocket = new Socket(host, echoServicePortNumber);
//            out = new PrintWriter(echoSocket.getOutputStream(), true);
//            in = new BufferedReader(new InputStreamReader(
//                    echoSocket.getInputStream()));
//        } catch (UnknownHostException e) {
//            System.err.println("Don't know about host " + host);
//            e.printStackTrace();
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Couldn't get I/O for the connection.");
//            e.printStackTrace();
//            System.exit(1);
//        }

        try {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println("hi");


//                TCPClient1.run(1);
                Duration timeElapsed ; //=Duration.between(TCPClient1.start, TCPClient1.end);
//                System.out.println("1: " + timeElapsed.toNanos());
//                TCPClient1.run(1);
//                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
//                System.out.println("1.1: " + timeElapsed.toNanos());
//                TCPClient1.run(8);
//                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
//                System.out.println("8: " + timeElapsed.toNanos());
//                TCPClient1.run(64);
//                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
//                System.out.println("64: " + timeElapsed.toNanos());
//                TCPClient1.run(1024);
//                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
//                System.out.println("1024: " + timeElapsed.toNanos());

                UDPClient1.run(1);
                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
                System.out.println("UDP(1): " + timeElapsed.toNanos());
                UDPClient1.run(8);
                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
                System.out.println("UDP(8): " + timeElapsed.toNanos());
                UDPClient1.run(64);
                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
                System.out.println("UDP(64): " + timeElapsed.toNanos());
                UDPClient1.run(1024);
                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
                System.out.println("UDP(1024): " + timeElapsed.toNanos());
            }
            stdIn.close();
        }
        catch (IOException ex) {
            System.err.println("IO failure.");
            ex.printStackTrace();
        }
    }
}
