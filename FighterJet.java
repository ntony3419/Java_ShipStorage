public class FighterJet extends Ship
{
	private String ordanance;
	private double wingSpan;	
	
	/***** default constructor 
	* Default Constructor:
	* IMPORT: none
	* EXPORT: address of new fighter jet class
	* ASSERTION: 
	****************/
	public FighterJet()
	{
		super();
		ordanance="anything";
		wingSpan = 2.0;
	}
	
	/****************************************
	* Alternate Constructor
	* IMPORT: inserialNum ( String), inyear(int), inOrdanance (String), inWingSpan(double)
	* EXPORT: address of new fighter Jet class
	* ASSERTION: create objects if the import are valid and Fail if not valid
	*******/
	public FighterJet(String inSerialNum, int inYear, String inOrdanance, Engine inEngine, double inWingSpan)
	{
		super(inSerialNum, inYear, inEngine);
		if (validateOrdanance(inOrdanance) == true && validateWingSpan(inWingSpan) == true)
		{
			ordanance = inOrdanance;
			wingSpan = inWingSpan;			
		}
		else 
		{
			throw new IllegalArgumentException("wrong data for ordanance and wingSpan");
		}
	}
	 
	/********************************************
	* copy constructor:
	* IMPORT: inFighterJet (FighterJet)
	* EXPORT: address of new FighterJet object
	* ASSERTION: create an object iwht identical object state as the import
	****************/
	public FighterJet(FighterJet inFighterJet)
	{
		super(inFighterJet);
		ordanance = inFighterJet.getOrdanance();
		wingSpan = inFighterJet.getWingSpan();
	}
	
	/*****************
	*Submodule: clone
	*IMPORT: 
	*EXPORT: fiterJet (class)
	*ASSERTION: 
	********************************/
	public FighterJet clone()
	{
		FighterJet cloneFighterJet;	
		cloneFighterJet = new FighterJet(this);
		return cloneFighterJet;
	}

	/*****************
	*Submodule: setOrdanance
	*IMPORT: inOrdanance (String)
	*EXPORT: none
	*ASSERTION: sets the ordanance value to inOrdanance
	********************************/
	public void setOrdanance(String inOrdanance)
	{
		if (validateOrdanance(inOrdanance)==true)
		{
			ordanance = inOrdanance;
		}
		else 
		{
			throw new IllegalArgumentException("wrong type of ordanance");
		}
	}
	
	/*****************
	*Submodule: setWingSpan
	*IMPORT: inWingSpan (double)
	*EXPORT: none
	*ASSERTION: sets the wingSpan value to inWingSpan
	********************************/
	public void setWingSpan(double inWingSpan)
	{
			wingSpan = inWingSpan;	
	}
	
	/*****************
	*Submodule: getOrdanance
	*IMPORT: 
	*EXPORT: ordanance(String)
	*ASSERTION: sets ordanance
	********************************/
	public String getOrdanance()
	{
		return ordanance;
	}
	
	/*****************
	*Submodule: getWingSpan
	*IMPORT: 
	*EXPORT: wingSpan
	*ASSERTION: get wingspan
	********************************/
	public double getWingSpan()
	{
		return wingSpan;
	}
	
	/*****************
	*Submodule: calcTravel
	*IMPORT: userDistance(integer)
	*EXPORT: max 
	*ASSERTION: calculate travel time
	********************************/
	public double calcTravel(int userDistance)
	{
		double max=0;	
		if (this.getEngine().getCylinder() == 0 || wingSpan == 0)
		{
			max = 0;
		}
		else
		{
			max = (userDistance / (wingSpan*this.getEngine().getCylinder()*150));			
		}
		return max;
	}

	/***********
	* SUBMODULE : equals
	* IMPORT: inObj (Object)
	* EXPORT: same
	* ASSERTION : two FighterJet are interchangeable if they have same hull and same maxDepth	
	****/
	public boolean equals(Object inObj)//override default equals methods
	{
		boolean same = false;
		FighterJet inFighterJet;
		if (inObj instanceof FighterJet)
		{
			inFighterJet =(FighterJet)inObj;
			if (ordanance.equals(inFighterJet.getOrdanance()))
			{
				if (String.valueOf(wingSpan).equals(String.valueOf(inFighterJet.getWingSpan())))
				{
					same=true;
				}
			}
		}
		return same;
	}
	
	/***********
	* SUBMODULE : toString
	* IMPORT: none
	* EXPORT: none
	* ASSERTION : printout the value of serial number , year, ordanance, wingspan
	****/
	public String toString()
	{
		return ("This fighter jet " + super.getSerialNum() + " was comissioned in " + super.getYear() + ", its engine has " + super.getEngine().getCylinder() +" cylinders." +"  and operate by " + super.getEngine().getFuel() + " Fuel " +  "it is a fighter jet with a wing span of  " + wingSpan +" and equipped with " + ordanance +" weapon system.");
	}

		/***********
	* SUBMODULE : validateOrdanance
	* IMPORT: ordanance
	* EXPORT: boolean
	* ASSERTION : validate ordanance information
	****/
	public boolean validateOrdanance(String inOrdanance)
	{
		boolean trueOrdanance = false;	
		if (inOrdanance.length()>1)
		{
			trueOrdanance=true;
		}
		return trueOrdanance;	
	}
	
		/***********
	* SUBMODULE : validateWingSpan
	* IMPORT: inWingSpan
	* EXPORT: boolean
	* ASSERTION : printout the value of serial number , year, ordanance, wingspan
	****/
	public boolean validateWingSpan(double inWingSpan)
	{
		boolean trueWingSpan=false;
		if (inWingSpan > 2.19 && inWingSpan <25.7)
		{
			trueWingSpan = true;
		}		
		return trueWingSpan;
	}
}
