import java.util.*;
public abstract class Ship
{
	private String serialNum;
	private int year;
	private Engine engine;
	
	/***** default constructor 
	* Default Constructor: 
	* IMPORT: none
	* EXPORT: none
	* ASSERTION: 
	****************/
	public Ship()
	{
		serialNum = "";
		year = 1996;
		engine = new Engine();		
	}
	
	/***** alternate constructor 
	* Alternate Constructor:
	* IMPORT: inSerialNum (String), inYear (int), inEngine(ENGINE) 
	* EXPORT:  none
	* ASSERTION:  create ship object
	****************/
	public Ship(String inSerialNum, int inYear, Engine inEngine)
	{
		if (validateSerialNum(inSerialNum) == true && validateYear(inYear) == true)
		{
			serialNum = inSerialNum;
			year = inYear;
			engine = new Engine(inEngine);
		}
		else
		{
			throw new IllegalArgumentException("Wrong data for serialNum and year");
		}
	}
	
	/***** copy constructor 
	* Copy Constructor:
	* IMPORT: none
	* EXPORT: 
	* ASSERTION: 
	****************/
	public Ship (Ship inShip)
	{
		serialNum= inShip.getSerialNum();
		year = inShip.getYear();
		engine = inShip.getEngine();		
	}
	
	/***** setter
	* SUBMODULE : setSerialNum
	* IMPORT: inSerialNum
	* EXPORT: none
	* ASSERTION: 
	****************/
	public void setSerialNum (String inSerialNum)
	{
		if (validateSerialNum(inSerialNum) == true)
		{
			serialNum = inSerialNum;
		}
		else
		{
			throw new IllegalArgumentException("Wrong serialNum for ship");
		}
	}

	/***** setter
	* SUBMODULE : setYear
	* IMPORT: inYear
	* EXPORT: none
	* ASSERTION: 
	****************/
	public void setYear (int inYear)
	{
		if (validateYear(inYear) == true)
		{
			year = inYear;
		}
		else
		{
			throw new IllegalArgumentException("Wrong data for year of ship");
		}		
	}
	
	/***** setter
	* SUBMODULE : setEngine
	* IMPORT: inEngine
	* EXPORT: none
	* ASSERTION: 
	****************/
	public void setEngine(Engine inEngine)
	{
		if (inEngine.validateFuel(inEngine.getFuel()) == true && inEngine.validateCylinder(inEngine.getCylinder()) == true)
		{
			engine = inEngine;		
		}
		else
		{
			throw new IllegalArgumentException("wrong data for engine");
		}
	}
	
	/***** getter
	* SUBMODULE : getSerialNum
	* IMPORT: none
	* EXPORT: serialNum
	* ASSERTION: 
	****************/
	public String getSerialNum()
	{
		return serialNum;
	}
	
	/***** getter
	* SUBMODULE : getYear
	* IMPORT: none
	* EXPORT: year
	* ASSERTION: 
	****************/
	public int getYear()
	{
		return year;
	}
	
	/***** getter
	* SUBMODULE : getEngine
	* IMPORT: none
	* EXPORT: engine
	* ASSERTION: 
	****************/
	public Engine getEngine()
	{
		return engine;
	}
	
	//abstract method for clone
	public abstract Ship clone();
	
	//abstract method for calctravel
	public abstract double calcTravel(int dist);
	
	/***** toString
	* SUBMODULE : toString
	* IMPORT: none
	* EXPORT: string
	* ASSERTION: 
	****************/
	public String toString()
	{
		String newStr = new String("The ship " + serialNum + " was commission in " + year + ", " + "its engine has " + engine.toString() );
		return newStr;
	}

	/***** 
	* SUBMODULE : validateSerialNum
	* IMPORT: inSerialNum
	* EXPORT: true/fale
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
		else
		{
			newTwo = inSerialNum.split("\\.");
			int frontPart = Integer.parseInt(newTwo[0]);
			int backPart = Integer.parseInt(newTwo[1]);
			if ((frontPart>99 && frontPart <301) && (backPart >000 && backPart < 1000))
				{
					trueSerial = true;
				}
		}
		return trueSerial;
	}	
	
	/***** 
	* SUBMODULE : validateYear
	* IMPORT: inYear
	* EXPORT: true/fale
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
}