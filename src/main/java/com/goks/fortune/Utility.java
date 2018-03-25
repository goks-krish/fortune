package com.goks.fortune;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utility {
	
	public String getHostName(){
		String hostName = "Unknown";
		try{
			InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostName = addr.getHostName();
		} catch(UnknownHostException ex){
			System.out.println("Hostname can not be resolved");
			ex.printStackTrace();
		}
		return hostName;
	}
}
