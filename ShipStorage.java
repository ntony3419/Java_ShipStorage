import java.util.*;
import java.io.*;
public class ShipStorage
{
	public static final int max = 30; // constant
	private Ship[] aShipArray;
	private int countShip;
	/***********
	* SUBMODULE : default constructor
	* IMPORT: none
	* EXPORT: none
	* ASSERTION : construct shipstorage
	****/
	public ShipStorage()
	{
		aShipArray = new Ship[max];
		countShip = 0;
	}
	
	public Ship[] getShipArray()
	{
		return aShipArray;
	}
	
	public void setShipArray(Ship[] inShipArray)
	{
			aShipArray = inShipArray; // Or can use public void setShipArray(Ship[] aShipArray) { aShipArray = this.aShipArray;}
	}
	
	public int getCountShip()
	{
		return countShip;
	}
	
	public void setCountShip(int incountShip)
	{
		countShip = incountShip;
	}
	/***********
	* SUBMODULE : addSubmarine
	* IMPORT: inSubmarine (Submarine)
	* EXPORT: none
	* ASSERTION : adding Submarine into the storage
	****/
	
	public void addShip(Object inObject)
	{
			if (aShipArray[countShip] != null)
			{
				countShip++;
			}
			else if (inObject instanceof Submarine)
			{
				aShipArray[countShip] = (Submarine)inObject;
				countShip++;
			}
			else if (inObject instanceof FighterJet)
			{
				aShipArray[countShip] = (FighterJet) inObject;
				countShip++;
			}
	}
	/***********
	* SUBMODULE : DestinationCheck
	* IMPORT: userDistance (INTEGER)
	* EXPORT: none
	* ASSERTION : calculate to find the fastest machine
	****/
	public void destinationCheck(int userDistance)
	{
		double speedCalcI=0;
		double speedCalcJ=0;
		double fast = 0;
		int location = 0;
		for (int i = 0 ; i  < countShip; i++)
		{
			for (int j = 0; j <countShip; j++)
			{
				if (aShipArray[i] instanceof Submarine)
				{
					speedCalcI = aShipArray[i].calcTravel(userDistance);
				}
				else if (aShipArray[i] instanceof FighterJet)
				{
					speedCalcI = aShipArray[i].calcTravel(userDistance);
				}
				
				if (aShipArray[j] instanceof Submarine)
				{
					speedCalcJ = aShipArray[j].calcTravel(userDistance);
				}
				else if (aShipArray[j] instanceof FighterJet)					
				{
					speedCalcJ = aShipArray[j].calcTravel(userDistance);
				}
				
				if (speedCalcI > speedCalcJ)
				{
					fast = speedCalcI;					
					location = i;
				}
				else 
				{
					fast = speedCalcJ;
					location = j;
				}
			}
		}
		System.out.println("The fastest is : " + aShipArray[location].toString());		
	}
	/***********
	* SUBMODULE : findDuplicate
	* IMPORT: aStorage (ShipStorage)
	* EXPORT: none
	* ASSERTION : find duplicate of ships inside its array
	****/
	public void findDuplicate(ShipStorage aStorage)
	{
		int i,j;
		Ship[] duplicateFound = new Ship[aStorage.max];
		for (i=0; i < aStorage.getCountShip();i++)
		{
				for (j =i+1; j< aStorage.getCountShip(); j++)
				{
					if (aStorage.getShipArray()[i].equals(aStorage.getShipArray()[j]))
					{
						duplicateFound[i] = aStorage.getShipArray()[j];
					}
				}	
		}
		for (int k = 0; k<duplicateFound.length; k++)
			if (duplicateFound[k] != null)
			{
				System.out.println("\nthe duplicate machines is : " + duplicateFound[k].toString());
			}
	}
	
	/***********
	* SUBMODULE : printStorage
	* IMPORT: none
	* EXPORT: none
	* ASSERTION :print all item to the terminal
	****/
	public void printStorage()
	{
		if (countShip == 0) {
			System.out.println("Storage is empty " );
		}
		else{

			for (int i = 0; i < countShip;i++)
			{
				System.out.println (aShipArray[i].toString());
			}		
		}	
	}
	
	/***********
	* SUBMODULE : equals
	* IMPORT: Object A, Object B (BOTH ARRAY)
	* EXPORT: true/false
	* ASSERTION : 
	****/
	public boolean equals(Object[] A, Object[] B)
	{
		boolean equal = true;
		if (A.length != B.length )
		{	equal = false;}
		else 
		{
			int count =0;
			do 
			{
				equal = A[count].equals(B[count]);
				count = count +1;
			}			
			while (equal && (count < A.length));
		}
		return equal;
	}
	
	/***********
	* SUBMODULE : viewSingle
	* IMPORT: machineSerialNum
	* EXPORT: none
	* ASSERTION : find a machine specificaly by its serialnum
	****/
	public void viewSingle(String machineSerialNum)
	{
		int found = 0;
		for (int i = 0; i< countShip; i ++)
		{
			if (machineSerialNum.equals(aShipArray[i].getSerialNum()))
			{
				found = i;
			}
		}
		if (found != 0)
		{
			System.out.println("\nthe machine you looking for is : " + aShipArray[found].toString()+"\n");
		}
		else
		{
			System.out.println("\nThere is no such machine in the storage\n");
		}
	}	
}
