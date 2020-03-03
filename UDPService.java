import java.net.*;
import java.io.*;

public class UDPService {
  static final int PORT = 2790;
  public static void main(String[] args) {
    try {
      
	byte[] buffer;
        DatagramSocket socket = new DatagramSocket(2791);
	for(;;){
	
        buffer = new byte[1024];
	
	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	
	socket.receive(packet);
	socket.send(packet);
        

        //out.println(in.readLine());
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
      System.exit(-1);
    }
  }
}
