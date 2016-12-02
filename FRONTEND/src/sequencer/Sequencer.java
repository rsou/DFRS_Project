
package sequencer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sequencer {

	public static final int sequencerPort = 2001;
	private int sequenceNumber;
	private DatagramSocket aSocket;
	private DatagramSocket rmSocket;
	private FileWriter fileWriter;
	private BufferedWriter bw;
	
	
	public Sequencer(){
		this.sequenceNumber = 0;
		startUDP();
	}
	
	
	public void startUDP(){
		
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					aSocket = new DatagramSocket(sequencerPort);
					rmSocket = new DatagramSocket();
					byte [] receiveData = new byte[1000];
					File fout = new File("SequencerLog.txt");
					System.out.println("Waiting for request from Front End");
	
					while(true){
						DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
						aSocket.receive(receivePacket);
						InetAddress IPAddress = receivePacket.getAddress();
						String received = new String(receivePacket.getData()).trim();
						System.out.println("Received data from sender: " + received);
						// format for the packet
						// sequencer number, method, IPaddress, FEPort
						String newData = Integer.toString(sequenceNumber) + "," + received + "," + IPAddress+ ","+ 2000;
						// write sequence number and method request to log
						writeToLog(fout, sequenceNumber, received);
						sequenceNumber++;
						byte [] sendData = newData.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2002);
						rmSocket.send(sendPacket);
						
					}
			
			
		}catch (Exception e) {
		      System.err.println(e);
	    }
			}
		}).start();
		
	}
	
	
	public void writeToLog(File fout, int sequencerNumber, String data) throws IOException{
		fileWriter = new FileWriter(fout, true);
		bw = new BufferedWriter(fileWriter);
		bw.write(sequencerNumber + " " + data);
		bw.newLine();
		bw.close();
	}
	

	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
		Sequencer s = new Sequencer();
	}
}//end of Sequencer class definition
