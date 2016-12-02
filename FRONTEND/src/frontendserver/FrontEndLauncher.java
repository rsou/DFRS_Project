package frontendserver;

import java.io.PrintWriter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

import frontendserver.DFRSFrontEndImpl;

public class FrontEndLauncher {

	public static void main(String [] args){
		
		
		try {
		
			String host = "localhost";
			int port = 42424;
			
			ORB orb = ORB.init(args, null);
			
			POA rootPOA = (POA)orb.resolve_initial_references("RootPOA");
			rootPOA.the_POAManager().activate();
			
			DFRSFrontEndImpl frontEndImpl = new DFRSFrontEndImpl(orb, host, port);		
			byte[]id = rootPOA.activate_object(frontEndImpl);
			org.omg.CORBA.Object ref = rootPOA.id_to_reference(id);
			
			String ior = orb.object_to_string(ref);
			System.out.println(ior);

		
			PrintWriter file = new PrintWriter("FRONTENDior.txt");
			file.println(ior);
			file.close();
			
			System.out.println("FRONT END Server is ready...");
			System.out.println("FRONT END UDPServer is ready...");
			
			rootPOA.the_POAManager().activate();
			orb.run();
		}
		catch(Exception e){
			e.printStackTrace();
		}
				
		
	}//end of main
		
}//end of FrontEndServer class definition

