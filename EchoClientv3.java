import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

public class EchoClientv3 {
    public static void main(String[] args) {

        try {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println("hi");


//                TCPClient2.run(1024,1024);
                Duration timeElapsed;// = Duration.between(TCPClient2.start, TCPClient2.end);
//                System.out.println("1024,1024: " + timeElapsed.toNanos());
//                TCPClient2.run(2048,512);
//                timeElapsed = Duration.between(TCPClient2.start, TCPClient2.end);
//                System.out.println("2048,512: " + timeElapsed.toNanos());
//                TCPClient2.run(4096,256);
//                timeElapsed = Duration.between(TCPClient2.start, TCPClient2.end);
//                System.out.println("4096,256: " + timeElapsed.toNanos());

                System.out.println("UDP,UDP");
                UDPClient2.run(1024,1024);
                timeElapsed = Duration.between(UDPClient2.start, UDPClient2.end);
                System.out.println("1024,1024: " + timeElapsed.toNanos());
                UDPClient2.run(2048,512);
                timeElapsed = Duration.between(UDPClient2.start, UDPClient2.end);
                System.out.println("2048,512-: " + timeElapsed.toNanos());
                UDPClient2.run(4096,256);
                timeElapsed = Duration.between(UDPClient2.start, UDPClient2.end);
                System.out.println("4096,256-: " + timeElapsed.toNanos());
            }
            stdIn.close();
        }
        catch (IOException ex) {
            System.err.println("IO failure.");
            ex.printStackTrace();
        }
    }
}
