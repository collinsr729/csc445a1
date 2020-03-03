import java.io.IOException;
import java.net.*;
import java.time.Instant;
import java.util.Arrays;

public class UDPClient1 {
    static Instant start = null;
    static Instant end = null;

    public static void run(int msgSize){
        DatagramSocket socket = null;
        InetAddress address = null;
        try{
            socket = new DatagramSocket(2793);
            address = InetAddress.getByName("gee.cs.oswego.edu");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        DatagramPacket sender;
        DatagramPacket receiver = null;
        try{
            byte[] msg = new byte[msgSize];
            Arrays.fill(msg,(byte)42);
            sender = new DatagramPacket(msg,msgSize,address,2793);
            receiver = new DatagramPacket(new byte[msgSize],msgSize,address,2793);

            socket.setSoTimeout(2000);
            start = Instant.now();
            socket.send(sender);
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                socket.receive(receiver);
            }catch (SocketTimeoutException e){
                System.out.println("TIMEOUT");
            } catch (IOException e) {
                System.out.println("IO EXCEPTION");
            }
        end = Instant.now();
            boolean ans = true;
            for(byte b : receiver.getData()){     //FOR TESTING
                if((char)b != '*') {
                    ans = false;
                    break;
                }
            }
            System.out.println(ans);
            socket.close();
    }
}
