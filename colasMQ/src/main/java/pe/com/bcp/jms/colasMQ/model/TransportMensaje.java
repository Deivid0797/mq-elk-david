package pe.com.bcp.jms.colasMQ.model;

public class TransportMensaje {
	
	private String identifier;
	private Mensaje message;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Mensaje getMessage() {
		 //message = new Mensaje();
		return message;
	}
	public void setMessage(Mensaje message) {
		this.message = message;
	}
	
	

}
