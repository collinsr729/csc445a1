import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.VarHandle;
import java.time.Duration;

public class throughClient {
    public static void main(String[] args){
        try {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println("hi");


                TCPClient1.run(1000);
                Duration timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
                System.out.println("1000: " + timeElapsed.toNanos());
                TCPClient1.run(16000);
                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
                System.out.println("16: " + timeElapsed.toNanos());
                TCPClient1.run(64000);
                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
                System.out.println("64: " + timeElapsed.toNanos());
                TCPClient1.run(256000);
                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
                System.out.println("256k: " + timeElapsed.toNanos());
                TCPClient1.run(1024000);
                timeElapsed = Duration.between(TCPClient1.start, TCPClient1.end);
                System.out.println("1024: " + timeElapsed.toNanos());

//                UDPClient1.run(1000);
//                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
//                System.out.println("U 1000: " + timeElapsed.toNanos());
//                UDPClient1.run(16000);
//                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
//                System.out.println("UDP 16: " + timeElapsed.toNanos());
//                UDPClient1.run(64000);
//                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
//                System.out.println("UDP 64: " + timeElapsed.toNanos());
//                UDPClient1.run(256000);
//                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
//                System.out.println("UDP256: " + timeElapsed.toNanos());
//                UDPClient1.run(1024000);
//                timeElapsed = Duration.between(UDPClient1.start, UDPClient1.end);
//                System.out.println("UDP1MB: " + timeElapsed.toNanos());
            }
            stdIn.close();
        }
        catch (IOException ex) {
            System.err.println("IO failure.");
            ex.printStackTrace();
        }
    }
}
