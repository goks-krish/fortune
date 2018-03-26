package com.goks.fortune;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Gokul
 *
 */
public class Utility {
    /**
     * This method returns the host on which it is running.
     * @return hostname or the
     * name of the running host
     */
    public final String getHostName() {
	String hostName = "Unknown";
	try {
	    InetAddress addr;
	    addr = InetAddress.getLocalHost();
	    hostName = addr.getHostName();
	} catch (UnknownHostException ex) {
	    System.out.println("Hostname can not be resolved");
	    ex.printStackTrace();
	}
	return hostName;
    }
}
