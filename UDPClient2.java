import java.io.IOException;
import java.net.*;
import java.time.Instant;
import java.util.Arrays;

public class UDPClient2 {
    static Instant start = null;
    static Instant end = null;

    public static void run(int numMessages,int msgSize) {
        start = Instant.now();
        while (--numMessages >= 0) {
            DatagramSocket socket = null;
            InetAddress address = null;
            try {
                socket = new DatagramSocket(2793);
                address = InetAddress.getByName("gee.cs.oswego.edu");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            DatagramPacket sender;
            DatagramPacket receiver = null;
            try {
                byte[] msg = new byte[msgSize];
                Arrays.fill(msg, (byte) 42);
                sender = new DatagramPacket(msg, msgSize, address, 2793);
                receiver = new DatagramPacket(new byte[8], 8, address, 2793);

                socket.setSoTimeout(1000);
                for(;numMessages>0;numMessages--) {
                    socket.send(sender);

                    socket.receive(receiver);
//                    System.out.println(Arrays.toString(receiver.getData()));
                }
            } catch (SocketTimeoutException e) {
                System.out.println("TIMEOUT");
            } catch (IOException e) {
                System.out.println("IO EXCEPTION");
            }
            end = Instant.now();
//            boolean ans = true;
//            for (byte b : receiver.getData()) {     //FOR TESTING
//                if (b != (byte)42) {
//                    ans = false;
//                    break;
//                }
//            }
//            System.out.println(ans);
            socket.close();
        }
    }
}
