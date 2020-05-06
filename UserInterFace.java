import java.util.*;
import java.io.*;
public class UserInterFace
{
	private ShipStorage aStorage;
	/***** 
	* SUBMODULE: run
	* IMPORT: none
	* EXPORT: none
	* ASSERTION: This is the main menu
	****************/			
	public void run()
	{			
		Scanner sc= new Scanner(System.in);		
		aStorage = new ShipStorage(); // initialize the storage and get use of its function
		System.out.println("\nWelcome to Submarine and fighter jet storage");	
		int menuChoose=0;
		while (menuChoose!=8)
		{
		System.out.println("______________________________________________________\nPlease select an option from the menu (1-8)" );	
		System.out.println( "1. Add Submarine or fighter Jet from keyboard\n" +
							"2. Load Submarine or fighter jet from files\n" +
							"3. View information of specific sub marine or fighter jet in the storage\n"+
							"4. Find the fastest machine for a certain distance\n" +
							"5. List all the machines available in the storage\n"+
							"6. Export machines to a file\n"+
							"7. Find duplicate\n"+
							"8. Exit the storage\n_________________________________" );			
		try
		{	System.out.print("Enter number between 1-8: ");
			menuChoose = sc.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Please enter number from 1 to 8 only. Exiting");
			menuChoose=8;		
		}	
			switch (menuChoose)
			{
				case 1:									
					if (aStorage.getCountShip() == ShipStorage.max)
					{
						System.out.println("--------------------------- The storage is full -----------------------------------------");
					}
					else
					{
						System.out.println("Enter value for Submarine or fighter jet in the form below");
						System.out.println("Type, Serial, Year, Cylinder, Fuel, Hull Or WingSpand, Max Depth OR Ordanance");
						String dataInput;
						String[] shipData = new String[7];
						dataInput = stringScanner();
						shipData = dataInput.split(",");
						try 
						{			
							Engine inEngine = new Engine(shipData[4],Integer.parseInt(shipData[3]));		
							switch (shipData[0])
							{
								case "s": case "S" :																		
									Submarine inSub = new Submarine(shipData[1],Integer.parseInt(shipData[2]),shipData[5], inEngine, Double.parseDouble(shipData[6]));										
							//try{
									aStorage.addShip(inSub);//									} catch (Exception e){System.out.println("Wrong here");}								
								break;
								case "f": case "F":
												FighterJet inJet = new FighterJet(shipData[1], Integer.parseInt(shipData[2]), shipData[6], inEngine, Double.parseDouble(shipData[5]));
												aStorage.addShip(inJet);																				
								break;
								default: 								
								break;
							}
						}
						catch (InputMismatchException e)
						{
							System.out.println("\nwrong type of machine\n");
						}
					}
					break;				
				case 2:											
					if (aStorage.getCountShip() == ShipStorage.max)
					{
						System.out.println("--------------------------- The storage is full -----------------------------------------");
					}
					else
					{
						try{
								String fileName;
								System.out.println("File name to load ships?" );
								fileName = sc.next();	
								FileManager.importData(fileName, aStorage);							
							} catch(Exception e){System.out.println("Some of the line are incorrect. All correct datas are loaded ");}
					}
				break;				
				case 3:
					if ( aStorage.getCountShip() == 0)
					{
						System.out.println("\nThe storage is empty. \n\nPlease fill up the storage using menu 1 or 2\n");
					}
					else
					{
						System.out.println("Please enter a serial number to export the data");
						String inSerialNum = sc.next();
						aStorage.viewSingle(inSerialNum);						
					}
				break;
				case 4:
					if (aStorage.getCountShip()==0)
					{
						System.out.println("\nThe storage is empty. \n\nPlease fill up the storage using menu 1 or 2\n");
					}
					else
					{
						System.out.println("Please enter a distance for calculate");
						try
						{
							int distance=sc.nextInt();
							aStorage.destinationCheck(distance);
					} catch(InputMismatchException e2) {System.out.println("not a integer");}
						
					}
				break;
				
				case 5:
					if (aStorage.getCountShip() < ShipStorage.max)
						aStorage.printStorage();
					else System.out.println("\nThe storage is empty. \n\nPlease fill up the storage using menu 1 or 2\n");
				break;
				
				case 6:
					if (aStorage.getCountShip()==0)
						System.out.println("\nThe storage is empty. \n\nPlease fill up the storage using menu 1 or 2\n");
					else 
					{
						String outFile;
						System.out.println("please enter a file name to export the storage: ");						
						outFile = sc.next();									
						FileManager.writeToFile(outFile, aStorage);			
					}
				break;
				case 7:
					if (aStorage.getCountShip()==0)
					{
						System.out.println("\nThe storage is empty. \n\nPlease fill up the storage using menu 1 or 2\n");
					}
					else 
					{
						aStorage.findDuplicate(aStorage);
					}
				break;
				case 8:
					System.out.println("exit");
				break;
				default: 
					System.out.println("\nMust be between 1 and 8\n");
					menuChoose = 8;
				break;
			}		
		}
	}
	
	/***** 
	* SUBMODULE: validateSerialNum
	* IMPORT:  inserialNumber
	* EXPORT:  true/false
	* ASSERTION: 
	****************/			
	public static  boolean validateSerialNum(String inSerialNum)
	{
		boolean trueSerial = false;
		String[] newTwo = new String[2];
		if (inSerialNum.length()!=7)
		{
			trueSerial=false;
		}
		else if(inSerialNum.length()==7)
		{
			newTwo = inSerialNum.split("\\.");
			int frontPart = Integer.parseInt(newTwo[0]);
			int backPart = Integer.parseInt(newTwo[1]);
			if ((frontPart>99 && frontPart <301) && (backPart >000 && backPart < 1000))
				{
					trueSerial = true;
				}
			else
				{
					trueSerial = false;
				}
		}
		return trueSerial;
	}	
	
	/***** 
	* SUBMODULE: validateYear
	* IMPORT: inYear
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public static  boolean validateYear(int inYear)
	{
		boolean trueYear= false;
		if (inYear > 1949 && inYear < 2023)
		{
			trueYear=true;
		}
		
		return trueYear;
	}	
	
	/***** 
	* SUBMODULE: validateOrdanance
	* IMPORT: inOrdanance
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public  static boolean validateOrdanance(String inOrdanance)
	{
		boolean trueOrdanance = false;	
		if (inOrdanance.length()>1)
		{
			trueOrdanance=true;
		}
		return trueOrdanance;
	}
	
	/***** 
	* SUBMODULE: validateWingSpan
	* IMPORT: inWingSpan
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public static boolean validateWingSpan(double inWingSpan)
	{
		boolean trueWingSpan=false;
		if (inWingSpan > 2.19 && inWingSpan <25.7)
		{
			trueWingSpan = true;
		}
		
		return trueWingSpan;
	}
	
	/***** 
	* SUBMODULE: validate Hull
	* IMPORT: inHull
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public static boolean validateHull(String inHull)
	{
		boolean trueHull = false;		
		if (inHull.equals("STEEL"))
		{
			trueHull = true;
		}
			if (inHull.equals("ALLOY")) 
			{
				trueHull = true;
			}
				if (inHull.equals("TITANIUM"))		
				{
					trueHull = true;
				}				
		return trueHull;
	}
	
	/***** 
	* SUBMODULE: validate Cylinder
	* IMPORT: inCylinder
	* EXPORT: true/false
	* ASSERTION: This validationg is in the engine class
	****************/	
	public static boolean validateCylinder(int inCylinder)
	{
		boolean trueCylinder= false;
		if (inCylinder > 1 && inCylinder < 21)
		{
			trueCylinder=true;
		}
		
		return trueCylinder;
	}
	
	/***** 
	* SUBMODULE: validateMaxDepth
	* IMPORT: inMaxDepth
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public static boolean validateMaxDepth(double inMaxDepth)
	{
		boolean trueDepth=false;
		if (inMaxDepth > (-499.9) && inMaxDepth <0.1)
		{
			trueDepth = true;
		}		
		return trueDepth;
	}
	
	/***** 
	* SUBMODULE: validateFuel
	* IMPORT: inFuel
	* EXPORT: true/false
	* ASSERTION: 
	****************/	
	public static boolean validateFuel(String inFuel)
	{
		boolean trueFuel = false;
		if (inFuel.toUpperCase().equals("BIO"))
		{
			trueFuel = true;
		}
		else if (inFuel.toUpperCase().equals("DIESEL"))
		{
			trueFuel = true;
		}
		else if (inFuel.toUpperCase().equals("BATTERY"))
		{
			trueFuel = true;
		}
		return trueFuel;		
	}
	
	/***** 
	* SUBMODULE: intergerScanner
	* IMPORT: none
	* EXPORT: interger
	* ASSERTION: check for input if it is an integer
	****************/	
	public int integerScanner()
	{
		int userChoice;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt())
		{
			userChoice = sc.nextInt();
			result = userChoice;
		}
		else
		{
			System.out.println("not a valid integer");
		}
		return result;
	}
	
	/***** 
	* SUBMODULE: validateInputs
	* IMPORT: shipValues (String Array)
	* EXPORT: true false
	* ASSERTION: this will validate all input at the same time. convienice sometime
	****************/	
	public static boolean validateInputs(String[] shipValues)
	{
		boolean allTrue = false;
		if (validateSerialNum(shipValues[1]) && validateYear(Integer.parseInt(shipValues[2])) && validateCylinder(Integer.parseInt(shipValues[3])) && 
			validateFuel(shipValues[4]))
			{
					if (validateHull(shipValues[5]) || validateWingSpan(Double.parseDouble(shipValues[5])))
					{
						if (validateMaxDepth(Double.parseDouble(shipValues[6])) || validateOrdanance(shipValues[6]))
						{
							allTrue = true;
						}
					}			 
			}
		return allTrue;
	}	
	
	/***** 
	* SUBMODULE: stringScanner
	* IMPORT: none
	* EXPORT: String
	* ASSERTION: a quite scanner for string type (it will convert the string to uppercase
	****************/	
	public static String stringScanner()
	{
		String userChoice, result="";
		Scanner sc = new Scanner(System.in);
		userChoice = sc.next();
		result = userChoice.toUpperCase();
		return result;
	}
	/***** 
	* SUBMODULE: showError
	* IMPORT:  none 
 	* EXPORT: none 
	* ASSERTION: 
	****************/	
	public void showError()
	{
		System.out.println("there are some error need to be fixed");
	}
}
