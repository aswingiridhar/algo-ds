package com.leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a dictionary that contains mapping of employee and his manager as a
 * number of (employee, manager) pairs like below.
 * 
 * { "A", "C" }, { "B", "C" }, { "C", "F" }, { "D", "E" }, { "E", "F" }, { "F",
 * "F" }
 * 
 * In this example C is manager of A, C is also manager of B, F is manager of C
 * and so on.
 * 
 * Write a function to get no of employees under each manager in the hierarchy
 * not just their direct reports. It may be assumed that an employee directly
 * reports to only one manager. In the above dictionary the root node/ceo is
 * listed as reporting to himself.
 * 
 * Output should be a Dictionary that contains following.
 * 
 * A - 0 B - 0 C - 2 D - 0 E - 1 F - 5
 * 
 * @author agiridhar
 *
 */
public class NumberEmployeesUnderManager {
	
	// Driver function
    public static void main(String[] args)
    {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
 
        Map<String, List<String>> managerReporteesMap = populateResult(dataSet);
        
        System.out.println("Reportees for Manager 'A' : " + getReporteeCountByManager("A", managerReporteesMap));
        System.out.println("Reportees for Manager 'B' : " + getReporteeCountByManager("B", managerReporteesMap));
        System.out.println("Reportees for Manager 'C' : " + getReporteeCountByManager("C", managerReporteesMap));
        System.out.println("Reportees for Manager 'D' : " + getReporteeCountByManager("D", managerReporteesMap));
        System.out.println("Reportees for Manager 'E' : " + getReporteeCountByManager("E", managerReporteesMap));
        System.out.println("Reportees for Manager 'F' : " + getReporteeCountByManager("F", managerReporteesMap));
    }
    
    public static Map<String, List<String>> populateResult(Map<String, String> dataset) {
    		
    		Map<String, List<String>> managerReporteesMap = new HashMap<String, List<String>>();
    	
    		if (dataset != null && dataset.size() > 0) {
    			
    			for (Map.Entry<String, String> entry : dataset.entrySet()) {
    				
    				String manager = entry.getValue();
    				String reportee = entry.getKey();
    				
    				if (!manager.equals(reportee)) {
    					List<String> reportees = managerReporteesMap.get(manager);
        				
        				if (reportees == null) {
        					reportees = new ArrayList<String>();
        				}
        				
        				reportees.add(reportee);
        				
        				managerReporteesMap.put(manager, reportees);
    				}
    				
    			}
    			
    		}
    		
    		return managerReporteesMap;
    	
    }
    
    public static Integer getReporteeCountByManager(String manager, Map<String, List<String>> managerReporteesMap) {
    		
    		int count = 0;
    		
    		if (!managerReporteesMap.containsKey(manager)) {
    			return 0;
    		}
    		
    		
    		List<String> reportees = managerReporteesMap.get(manager);
    		
    		count += reportees.size();
    		
    		for (String reportee : reportees) {
    			
    			count += getReporteeCountByManager(reportee, managerReporteesMap);
    			
    		}
    	
    		
    		return count;
    }

}
