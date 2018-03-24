package com.goks.fortune.drools;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.goks.fortune.model.Employee;
import com.goks.fortune.model.SupportDay;

public class DroolsEngineImpl implements DroolsEngine {
	
	String[] employeeNames = {"Tom","Adam", "Evan", "Adit", "Glen","Sara","Arjun","Raja","Max","Krish"};

	@Override
	public String executeDrools(int totalEmployees, int totalDays, boolean random) throws DroolsParserException, IOException  {
		String schedule = "";
        KieServices kieServices = KieServices.Factory.get();
        Resource resource = kieServices.getResources().newFileSystemResource("rules.drl");
        
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(resource);
        KieBuilder kbuilder = kieServices.newKieBuilder(kieFileSystem);
        kbuilder.buildAll();
        KieRepository kieRepository = kieServices.getRepository();
        KieContainer kContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());        
		
		SupportDay[] supportDays = new SupportDay[totalDays];
		Employee[] employees = new Employee[totalEmployees];
		
		for(int i=0;i<supportDays.length;i++) {
			supportDays[i] = new SupportDay();
			supportDays[i].setId(i);
			supportDays[i].setToday(new Date(new Date().getTime() + 86400000 + (i*86400000)).toString().substring(0, 10));
			supportDays[i].setYesterday(new Date(new Date().getTime()  + (i*86400000)).toString().substring(0, 10));
			supportDays[i].setFirstShiftEmpId(-1);
			supportDays[i].setLastShiftEmpId(-1);
			supportDays[i].setTotalEmployeeCount(totalEmployees);
		}
		
		for(int i=0;i<employees.length;i++) {
			employees[i] = new Employee();
			employees[i].setId(i);
			if (employeeNames.length>i) {
				employees[i].setName(employeeNames[i]); //From array
			}
		}
 		
		for(int i=0;i<supportDays.length;i++) {
			
			int j=0;
			Integer[] numberArray = randomGenerator(employees.length, random);
			supportDays[i].setComplete(false);
			while(!supportDays[i].isComplete()) {
				KieSession kSession = kContainer.newKieSession(); 
				supportDays[i].setFirstShiftEmpId(employees[numberArray[j]].getId());
				supportDays[i].setComplete(true);
				kSession.insert(employees[numberArray[j]]);
				kSession.insert(supportDays[i]);
				kSession.fireAllRules();
				j++;
			}
			employees[supportDays[i].getFirstShiftEmpId()].setPreviousShiftDate(supportDays[i].getToday());
			employees[supportDays[i].getFirstShiftEmpId()].setTotalShifts(employees[supportDays[i].getFirstShiftEmpId()].getTotalShifts()+1); 
			j=0;
			supportDays[i].setComplete(false);
			while(!supportDays[i].isComplete()) {
				KieSession kSession = kContainer.newKieSession();		
				supportDays[i].setLastShiftEmpId(employees[numberArray[j]].getId());
				supportDays[i].setComplete(true);
				kSession.insert(employees[numberArray[j]]);
				kSession.insert(supportDays[i]);
				kSession.fireAllRules();
				j++;
			}
			employees[supportDays[i].getLastShiftEmpId()].setPreviousShiftDate(supportDays[i].getToday());
			employees[supportDays[i].getLastShiftEmpId()].setTotalShifts(employees[supportDays[i].getLastShiftEmpId()].getTotalShifts()+1);
		}
		
/*		for(int i=0;i<supportDays.length;i++) {
			ObjectNode daySchedule = mapper.createObjectNode();
			daySchedule.put("Date: ", supportDays[i].getToday());
			daySchedule.put("FirstShift: ", supportDays[i].getFirstShiftEmpId()+ " - " + employees[supportDays[i].getFirstShiftEmpId()].getName());
			daySchedule.put("LastShift: ", supportDays[i].getLastShiftEmpId()+ " - " + employees[supportDays[i].getLastShiftEmpId()].getName());
	        schedule.add(daySchedule);
		}*/
		schedule = "schedule goes here = " + supportDays[0].getFirstShiftEmpId() ;
		return schedule;
	}
    
	private Integer[] randomGenerator(int max, boolean random) {
		Integer[] arr = new Integer[max];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = i;
	    }
	    if(random) {
	    	Collections.shuffle(Arrays.asList(arr));
	    }
		return arr;
	}

}
