package com.goks.fortune.drools;

import java.net.InetAddress;
import java.io.IOException;

public class Test {
	
	static int totalEmployees = 10;
	static int totalDays = 14;
	static boolean random = true;

	public static void main(String[] args) {
		String hostname = "Unknown";

		System.out.println("HELLO");
		DroolsEngine dl = new DroolsEngineImpl();
		try {
//			System.out.println(dl.executeDrools(totalEmployees, totalDays, random));
			InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    System.out.println(hostname);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
