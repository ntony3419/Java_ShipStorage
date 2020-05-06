/****
* NGUYEN HUU HUNG QUANG
* Engine.java
* This class construct an Engine for all the ship
*
*/
public class Engine
{
	private String fuel;
	private int cylinder;
	/***** default constructor 
	* Default Constructor:
	* IMPORT: none
	* EXPORT: address of new engine class
	* ASSERTION: create default keys for Engine
	****************/
	public Engine()
	{
		fuel = "GAS";
		cylinder = 6;		
	}
	
	/****************************************
	* Alternate Constructor
	* IMPORT: inFuel ( String), inCylinder(int)
	* EXPORT: address of new engine class
	* ASSERTION: create objects if the import are valid and Fail if not valid
	*******/
	public Engine(String inFuel, int inCylinder)
	{
		if (validateFuel(inFuel) == true && validateCylinder(inCylinder) == true )
		{
			fuel = inFuel;
			cylinder = inCylinder;				
		}
		else
		{
			throw new IllegalArgumentException("wrong type of fuel and cylinder");
		}
	}	
 
	/********************************************
	* copy constructor:
	* IMPORT: InEngine (engine)
	* EXPORT: address of new engine object
	* ASSERTION: create an object iwht identical object state as the import
	****************/
	public Engine(Engine inEngine)
	{
		fuel = inEngine.getFuel();
		cylinder = inEngine.getCylinder();
	}

	/********************************************
	* SUBMODULE : validateFuel
	* IMPORT: infuel
	* EXPORT: true/false
	* ASSERTION: 
	****************/
	public static boolean validateFuel(String inFuel)
	{
		boolean trueFuel = false;		
		if (inFuel.toUpperCase().equals("BIO") || inFuel.toUpperCase().equals("DIESEL") || inFuel.toUpperCase().equals("BATTERY"))
		{
			trueFuel = true;
		}	
		else
		{
				trueFuel = false;
		}		
		return trueFuel;
	}
	
	/********************************************
	* SUBMODULE : validateCylinder
	* IMPORT: inCylinder
	* EXPORT: true/false
	* ASSERTION: 
	****************/
	public static boolean validateCylinder(int inCylinder)
	{
		boolean trueCylinder= false;
		if (inCylinder > 1 && inCylinder < 21)
		{
			trueCylinder=true;
		}
		else
		{
			trueCylinder=false;
		}
		return trueCylinder;
	}
	
	/********************************************
	* SUBMODULE : clone
	* IMPORT: none
	* EXPORT: clone
	* ASSERTION: 
	****************/
	public Engine clone()
	{
		Engine cloneEngine;		
		cloneEngine = new Engine(this.fuel.toUpperCase(), this.cylinder); // this keyword refew to the variable inside this class
		return cloneEngine;
	}

	/*****************
	*Submodule: setFuel
	*IMPORT: inFuel (String)
	*EXPORT: none
	*ASSERTION: sets the fuel to infuel
	********************************/
	public void setFuel(String inFuel)
	{	
		if (validateFuel(inFuel) == true)
		{
			fuel = inFuel;
		}
		else
		{
			throw new IllegalArgumentException("invalid import type");
		}		
	}

	/*****************
	*Submodule: setCylinder
	*IMPORT: inCylinder (int)
	*EXPORT: none
	*ASSERTION: sets the cylinder to inCylinder
	********************************/
	public void setCylinder(int inCylinder)
	{
		if (validateCylinder(inCylinder) == true)
		{
			cylinder = inCylinder;
		}
		else
		{
			throw new IllegalArgumentException("invalid import type");
		}		
	}

	/*****************
	*Submodule: getFuel
	*IMPORT: 
	*EXPORT: fuel
	*ASSERTION: get fuel
	********************************/
	public String getFuel()
	{
		return fuel;
	}

	/*****************
	*Submodule: getCylinder
	*IMPORT: 
	*EXPORT: cylinder
	*ASSERTION: get cylinder
	********************************/
	public int getCylinder()
	{
		return cylinder;
	}
	
	/***********
	* SUBMODULE : equals
	* IMPORT: inObj (Object)
	* EXPORT: same
	* ASSERTION : two fighterJet are interchangeable if they have same hull and same maxDepth	
	****/
	public boolean equals(Object inObj)
	{
		boolean same = false;
		
		if (inObj instanceof Engine)
		{
			Engine inEngine = (Engine)inObj;			
			if (inEngine.getFuel() == inEngine.getFuel()) // compare fuel data of input objet with this object (this is a generic method
			{
				same=true;
			}
		}
		return same;
	}
	
	/***********
	* SUBMODULE : toString
	* IMPORT: none
	* EXPORT: String
	* ASSERTION : two fighterJet are interchangeable if they have same hull and same maxDepth	
	****/
	public String toString()
	{
		return ("Type Fuel: " + fuel + "\nproduction cylinder: " + cylinder);
	}
}
