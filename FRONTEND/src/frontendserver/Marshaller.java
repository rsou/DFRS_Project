package frontendserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Marshaller implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final byte[] marshall(IUDPObject object) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
		ObjectOutputStream out = new ObjectOutputStream(bos) ;
		out.writeObject(object);
		out.close();
		return bos.toByteArray();
	 
	
	}//end of marshall method defintion

	
	public static final IUDPObject unmarshall(byte[] data) throws IOException, ClassNotFoundException { 
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(bis);
		IUDPObject unmarshalled_data = (IUDPObject)is.readObject();
		is.close();
		return unmarshalled_data;
		
	}//end of unmarshall method definition

	
}//end of Marshaller class definition
