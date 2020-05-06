public class Submarine extends Ship
{	
	private String hull;
	private double maxDepth;
	
	/***** default constructor 
	* Default Constructor:
	* IMPORT: none
	* EXPORT: address of new Submarine class
	* ASSERTION: 
	****************/
	public Submarine()
	{
		super();
		hull="default";
		maxDepth = -400.00;	
	}
	
	/****************************************
	* Alternate Constructor
	* IMPORT: inserialNum ( String), inyear(int), inhull (String), inmaxDepth(double)
	* EXPORT: address of new Submarine class
	* ASSERTION: create objects if the import are valid and Fail if not valid
	*******/
	public Submarine(String inSerialNum, int inYear, String inHull,Engine inEngine, double inMaxDepth)
	{	
		super(inSerialNum, inYear, inEngine);	
		if (super.validateSerialNum(inSerialNum) == true && super.validateYear(inYear) == true && validateMaxDepth(inMaxDepth) == true && validateHull(inHull) == true)
		{
			hull = inHull;
			maxDepth = inMaxDepth;
		}
		else 
		{
			throw new IllegalArgumentException("Wrong data for Submarine");
		}
	}
	
	/********************************************
	* copy constructor:
	* IMPORT: inSubmarine (Submarine)
	* EXPORT: address of new Submarine object
	* ASSERTION: create an object iwht identical object state as the import
	****************/
	public Submarine(Submarine inSubmarine)
	{		
		super(inSubmarine);
		hull = inSubmarine.getHull();		
		maxDepth = inSubmarine.getMaxDepth();
	}
	
	/********************************************
	* SUBMODULE : clone
	* IMPORT: 
	* EXPORT: Submarine Class
	* ASSERTION:
	***********************/
	public Submarine clone()
	{
		Submarine cloneSubmarine;
		cloneSubmarine = new Submarine(this);
		return cloneSubmarine;
	}
	//mutators
	/*****************
	*Submodule: setHull
	*IMPORT: inHull (String)
	*EXPORT: none
	*ASSERTION: sets the hull value to inHull
	********************************/
	public void setHull(String inHull)
	{
		if (validateHull(inHull) == true)
		{
			hull = inHull;
		}
		else 
		{
			throw new IllegalArgumentException("Wrong data for Hull");
		}
	}
	
	/*****************
	*Submodule: setMaxDepth
	*IMPORT: inMaxDepth (double)
	*EXPORT: none
	*ASSERTION: sets the maxDepth value to inMaxDepth
	********************************/
	public void setMaxDepth(double inMaxDepth)
	{
		if (validateMaxDepth(inMaxDepth) == true)
		{
			maxDepth=inMaxDepth;
		}
		else
		{
			throw new IllegalArgumentException("wrong data for maxDepth");
		}
	}
	
	/*****************
	*Submodule: getHull
	*IMPORT: none
	*EXPORT: hull
	*ASSERTION: get hull
	********************************/	
	
	public String getHull()
	{
		return hull;
	}
	
	/*****************
	*Submodule: getMaxDepth
	*IMPORT: none
	*EXPORT: maxDepth
	*ASSERTION: get maxDepth
	********************************/		
	public double getMaxDepth()
	{
		return maxDepth;
	}	
	/*****************
	*Submodule: calcTravel
	*IMPORT: userDistance
	*EXPORT: max
	*ASSERTION: 
	********************************/	
	public double calcTravel(int userDistance)
	{
		double max=0;	
			max = (userDistance / this.getEngine().getCylinder()) * (1/(10 +(maxDepth *(-1))));			
		return max;
	}
	
	/***********
	* SUBMODULE : equals
	* IMPORT: inObj (Object)
	* EXPORT: same
	* ASSERTION : two Submarine are interchangeable if they have same hull and same maxDepth	
	****/
	public boolean equals(Object inObj)
	{
		boolean same = false;
		if (inObj instanceof Submarine)
		{
			Submarine inSubmarine = (Submarine)inObj;
			if (hull.equals(inSubmarine.getHull()))
			{
				if (maxDepth==inSubmarine.getMaxDepth())
				{	
					if (super.getEngine().equals(inSubmarine.getEngine()))
					{
					same=true;
					}
				}
			}
		}
		return same;
	}
	
	/*****************
	*Submodule: toString
	*IMPORT: none
	*EXPORT: string
	*ASSERTION: print
	********************************/	
	public String toString()
	{
		return ("this Submarine " + super.getSerialNum() + " was comissioned in " + super.getYear() + ", it has an engine with " + super.getEngine().getCylinder() +" cylinders. "+ 
					"run on fuel type of " + super.getEngine().getFuel() + " it is a Submarine with hull of " + hull +  " and a max depth of " + maxDepth);
	}
		
	/*****************
	*Submodule: validateHull
	*IMPORT: inHull
	*EXPORT: true/false
	*ASSERTION: validate hull
	********************************/	
	public  boolean validateHull(String inHull)
	{
		boolean trueHull = false;		
		if (inHull.toUpperCase().equals("STEEL"))
		{
			trueHull = true;
		}
			if (inHull.toUpperCase().equals("ALLOY")) 
			{
				trueHull = true;
			}
				if (inHull.toUpperCase().equals("TITANIUM"))		
				{
					trueHull = true;
				}				
		return trueHull;
	}
	/*****************
	*Submodule: validateMaxDepth
	*IMPORT: inHull
	*EXPORT: true/false
	*ASSERTION: validate max depth
	********************************/	
	public  boolean validateMaxDepth(double inMaxDepth)
	{
		boolean trueDepth=false;
		if (inMaxDepth > (-499.9) && inMaxDepth <0.1)
		{
			trueDepth = true;
		}		
		return trueDepth;
	}
}