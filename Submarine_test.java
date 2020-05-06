import java.util.*;
public class Submarine_test
{
public static void main(String[] args)
{
/* try s1 default
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*		1950<=year <=2022
*				hull = "steel" OR "alloy" OR "titanium"
*				-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
	subMarine s1 = new subMarine();
	System.out.println("sub marine 1 value: \n" + s1.toString());
	}
	catch (IllegalArgumentException e)
	{
		
		System.out.println("some of the  values are not  correct format 1");
	}
/* try s2
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*	did not satisfy		1950<=year <=2022
*				hull = "steel" OR "alloy" OR "titanium"
*				-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
		subMarine s2_i = new subMarine("156.321", 1920, "fat", 2, -400.0);
		System.out.println("sub marine 2_i value: \n" + s2_i.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 2");
	}
/* try s3
*	 satisfy  all condition 
*		did not satisfy		100.001<= serialNum <= 300.999
*					1950<=year <=2022
*					hull = "steel" OR "alloy" OR "titanium"
*					-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
		subMarine s3 = new subMarine("333.400", 1996, "Alumium",2, -110.22);
		System.out.println("sub marine s3 value: \n" + s3.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 3 ");
	}


/* try s4
*	 satisfy  all condition 
*					100.001<= serialNum <= 300.999
*					1950<=year <=2022
*					hull = "steel" OR "alloy" OR "titanium"
*					-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
		subMarine s4 = new subMarine("200.435", 1996, "TITANIUM", 2,-400.00);
		System.out.println("sub marine 4 value: \n" + s4.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 4");
	}

/* try s5 compare s5 and s4
*	 satisfy  all condition 
*					100.001<= serialNum <= 300.999
*					1950<=year <=2022
*					hull = "steel" OR "alloy" OR "titanium"
*					-500.00 <=maxDepth <=0.0 inclusive
*	s5 hull == s4 hull and s5 maxdep == s4 maxdepth
*/
	try
	{
		subMarine s4 = new subMarine("200.435", 1996, "TITANIUM", 2,-400.00);
		subMarine s5 = new subMarine("150.888", 2002, "TITANIUM", 2,-400.00);
		if (s5.equals(s4)==true)
		{
			System.out.println("sub marine 5 can replace submarine 4: \n" + s5);
		}
		else
		{
			System.out.println("subMarine 4 can not replace submarine 2\n");
		}
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 5");
	}
/*	
* try s6
*	 satisfy  all condition 
*					100.001<= serialNum <= 300.999
*					1950<=year <=2022
*					hull = "steel" OR "alloy" OR "titanium"
*					-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
		subMarine s6 = new subMarine("200.435", 1996, "TITANIUM", 2,-400.00);
		System.out.println("sub marine 6 value: \n" + s6.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 6");
	}	

/* try s7
*	 satisfy  all condition 
*					100.001<= serialNum <= 300.999
*					1950<=year <=2022
*					hull = "steel" OR "alloy" OR "titanium"
*					-500.00 <=maxDepth <=0.0 inclusive
*/
	try
	{
		subMarine s7 = new subMarine("200.435", 1996, "STEEL",1, -300.00);
		System.out.println("sub marine 7 value: \n" + s7.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 7");
	}	

	
		
	



	
	
	
	

}
}
