
import java.rmi.*;
import java.rmi.server.*;

public class RemoteCalcImpl extends UnicastRemoteObject
        implements RemoteCalc {

    public RemoteCalcImpl() throws RemoteException {
        super();
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
