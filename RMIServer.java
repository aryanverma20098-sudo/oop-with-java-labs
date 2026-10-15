
import java.rmi.*;
import java.rmi.registry.*;

public class RMIServer {
    public static void main(String[] args) {
        try {
            RemoteCalcImpl obj = new RemoteCalcImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalcService", obj);

            System.out.println("RMI Server is ready.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
