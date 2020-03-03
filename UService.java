import java.net.*;
import java.io.*;
import java.util.Arrays;

public class UService {
  static final int PORT = 2793;
  public static void main(String[] args) {
    try {
      
	byte[] buffer;
        DatagramSocket socket = new DatagramSocket(PORT);
	for(;;){
	
        buffer = new byte[1025];
	
	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	
	socket.receive(packet);
	byte[] returnBytes = new byte[8];
	byte[] data = packet.getData();
	for(int i = 0; i<8;i++){
	returnBytes[i] = data[i];
	}
	DatagramPacket returner = new DatagramPacket(returnBytes,4,packet.getAddress(),PORT);
	//System.out.println(data.length);
	//System.out.println(Arrays.toString(returnBytes));
	socket.send(returner);
        

        //out.println(in.readLine());
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
      System.exit(-1);
    }
  }
}
