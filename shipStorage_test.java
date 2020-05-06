import java.util.*;

public class shipStorage_test
{
public static void main(String[] args)
{

	try
	{
		//create a shipStorage
			shipStorage newShipStorage = new shipStorage();
			
		//shipStorage submarineArray = new shipStorage();
		// create 15 submarine object
		
		subMarine s1= new subMarine("111.222", 1996, "STEEL", 5, -330.00);		 // create submarine object
		subMarine s2= new subMarine("111.222", 1996, "STEEL", 5,-330.00);
		subMarine s3 = new subMarine("222.124", 1998, "ALLOY",5, -330.00); // create submarine object
		subMarine s4 = new subMarine("222.125", 1999, "ALLOY", 5,-330.00); // create submarine object
		subMarine s5 = new subMarine("222.126", 2000, "ALLOY", 5,-330.00); // create submarine object
		subMarine s6 = new subMarine("222.127", 2001, "ALLOY", 5,-330.00); // create submarine object
		subMarine s7 = new subMarine("222.128", 2002, "ALLOY",5, -330.00); // create submarine object
		subMarine s8 = new subMarine("222.129", 2003, "ALLOY",5, -330.00); // create submarine object
		subMarine s9 = new subMarine("222.120", 2004, "ALLOY", 5,-330.00); // create submarine object
		subMarine s10 = new subMarine("222.121", 2005, "ALLOY", 5,-330.00); // create submarine object
		subMarine s11 = new subMarine("222.130", 2006, "ALLOY", 5,-330.00); // create submarine object
		subMarine s12 = new subMarine("222.131", 2007, "ALLOY", 5,-330.00); // create submarine object
		subMarine s13 = new subMarine("222.132", 2008, "ALLOY", 5,-330.00); // create submarine object
		subMarine s14 = new subMarine("222.133", 2009, "ALLOY", 5,-330.00); // create submarine object
		subMarine s15 = new subMarine("222.134", 2010, "ALLOY", 5,-330.00); // create submarine object
		
		
		
	fighterJet j1= new fighterJet("221.555", 2001, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j2= new fighterJet("221.556", 2002, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j3= new fighterJet("221.557", 2003, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j4= new fighterJet("221.558", 2004, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j5= new fighterJet("221.559", 2005, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j6= new fighterJet("221.560", 2006, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j7= new fighterJet("221.561", 2007, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j8= new fighterJet("221.562", 2008, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j9= new fighterJet("221.563", 2009, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j10= new fighterJet("221.564", 2010, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j11= new fighterJet("221.565", 2011, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j12= new fighterJet("221.566", 2012, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j13= new fighterJet("221.567", 2013, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j14= new fighterJet("221.568", 2014, "SUBMACHINE GUN", 5, 5);		 // create submarine object
		fighterJet j15= new fighterJet("221.569", 2015, "SUBMACHINE GUN", 5, 5);		 // create submarine object
	
		//
		//add submarine and fighter jet to the storage
		newShipStorage.addSubmarine(s1);
		newShipStorage.addSubmarine(s2);
		newShipStorage.addSubmarine(s3);
		newShipStorage.addSubmarine(s4);
		newShipStorage.addSubmarine(s5);
		newShipStorage.addSubmarine(s6);
		newShipStorage.addSubmarine(s7);
		newShipStorage.addSubmarine(s8);
		newShipStorage.addSubmarine(s9);
		newShipStorage.addSubmarine(s10);
		newShipStorage.addSubmarine(s11);
		newShipStorage.addSubmarine(s12);
		newShipStorage.addSubmarine(s13);
		newShipStorage.addSubmarine(s14);
		newShipStorage.addSubmarine(s15);
		
		// add jet to storage
		newShipStorage.addJet(j1);
		newShipStorage.addJet(j2);
		newShipStorage.addJet(j3);
		newShipStorage.addJet(j4);
		newShipStorage.addJet(j5);
		newShipStorage.addJet(j6);
		newShipStorage.addJet(j7);
		newShipStorage.addJet(j8);
		newShipStorage.addJet(j9);
		newShipStorage.addJet(j10);
		newShipStorage.addJet(j11);
		newShipStorage.addJet(j12);
		newShipStorage.addJet(j13);
		newShipStorage.addJet(j14);
		newShipStorage.addJet(j15);
		
		System.out.println("--------------------------------------- testing the destination method -------------------------------------------");
		
		
	
		System.out.println("print the new storage");
		//print the whole storage
		newShipStorage.printStorage();
		String fastest="";
		fastest = newShipStorage.destinationCheck(100);
		//test fastest transport
		System.out.println("the fastest transport \n"+ fastest);
	
		System.out.println("--------------------------------------------testing find duplicate---------------------------------------------");
		
		newShipStorage.findDuplicate();
		
	/*	//print out the value of the submarine 1
 		System.out.println("the submarine" + s1.toString());
		
		System.out.println("adding 15 submarine");
		submarineArray.addSubmarine(s1); 
		submarineArray.addSubmarine(s2); 
		submarineArray.addSubmarine(s3); 
		submarineArray.addSubmarine(s4); 
		submarineArray.addSubmarine(s5); 
		submarineArray.addSubmarine(s6); 
		submarineArray.addSubmarine(s7); 
		submarineArray.addSubmarine(s8); 
		submarineArray.addSubmarine(s9); 
		submarineArray.addSubmarine(s10); 
		submarineArray.addSubmarine(s11); 
		submarineArray.addSubmarine(s12); 
		submarineArray.addSubmarine(s10); 
		
		submarineArray.addSubmarine(s14); 
		submarineArray.addSubmarine(s15); 
		System.out.println("new storage");
		submarineArray.printArray();
		
		*/
	
	
	
	/*	
			System.out.println("fighterjet storate--------------------------------------------------------------------");
		shipStorage fighterArray = new shipStorage();
		System.out.println("create fighter jet");
		
			fighterJet j16= new fighterJet("221.555", 2016, "SUBMACHINE GUN", 8, 5);		 // create submarine object
		
	
		System.out.println(" add fighter jet");
	*/
	/*	
		fighterArray.addJet(j1);
		fighterArray.addJet(j2);
		fighterArray.addJet(j3);
		fighterArray.addJet(j4);
		fighterArray.addJet(j5);
		fighterArray.addJet(j6);
		fighterArray.addJet(j7);
		fighterArray.addJet(j8);
		fighterArray.addJet(j9);
		fighterArray.addJet(j10);
		fighterArray.addJet(j11);
		fighterArray.addJet(j12);
		fighterArray.addJet(j13);
		fighterArray.addJet(j14);
		fighterArray.addJet(j15);
	*/
	/*
		System.out.println("the storage for jet is ");
		fighterArray.printJet();
	*/
		//testing new method
		
	}
	catch (IllegalArgumentException e)
	{
		
		System.out.println("some of the  values are not  correct format 1");
	}
}
}
