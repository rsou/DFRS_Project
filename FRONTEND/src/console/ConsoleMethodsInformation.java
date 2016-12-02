package console;

public class ConsoleMethodsInformation {

	private String ipAddress;
	private int portNumber;
	
	public ConsoleMethodsInformation(String ipAddress, int portNumber){
		this.setIP(ipAddress);
		this.setPort(portNumber);
	}
	
	public String getIP(){
		return ipAddress;
	}
	
	public void setIP(String ipAddress){
		this.ipAddress = ipAddress;
	}
	
	public int getPort(){
		return portNumber;
	}
	
	public void setPort(int portNumber){
		this.portNumber = portNumber;
	}
	
	public String toString(){
		return this.ipAddress + ": " + this.portNumber;
	}
}//end of ConsoleMethodsInformation
