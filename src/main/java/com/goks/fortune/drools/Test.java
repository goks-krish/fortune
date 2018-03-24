package com.goks.fortune.drools;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;

public class Test {
	
	static int totalEmployees = 10;
	static int totalDays = 14;
	static boolean random = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HELLO");
		DroolsEngine dl = new DroolsEngineImpl();
		try {
			System.out.println(dl.executeDrools(totalEmployees, totalDays, random));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DroolsParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
