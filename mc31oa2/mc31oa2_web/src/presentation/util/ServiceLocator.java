package presentation.util;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class ServiceLocator {
	
	public static final ServiceLocator INSTANCE = new ServiceLocator();
	
	public Object locateLocalEJB(String jndiName) {
		Object ejb = null;
		try {
			InitialContext context = new InitialContext();
			ejb = context.lookup(jndiName);
			context.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ejb;
	}
	
	public Object locateRemoteEJB(String jndiName, Class ejbInterface) {
		Object ejb = null;
		try {
			InitialContext context = new InitialContext();
			Object remoteRef = context.lookup(jndiName);
			ejb = PortableRemoteObject.narrow(remoteRef, ejbInterface);
			context.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ejb;
	}

}
