package frontendserver;

import java.io.Serializable;

import frontend.DFRSFrontEndPOA;

public interface  IUDPObject extends Serializable{
	
	
	public void execute(DFRSFrontEndPOA frontEndImpl);
	

	
}//end of IUDPObject class definition
