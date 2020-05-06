import java.util.*;
public class Engine_test
{
public static void main(String[] args)
{
//try s1
	try
	{
	engine s1 = new engine();
	System.out.println("engine 1 value: " + s1.toString());
	}
	catch (IllegalArgumentException e)
	{
		
		System.out.println("some of the  values are not  correct format 1");
	}
// try s2 _i	
	try
	{
		engine s2_i = new engine("oil", 18);		// THIS ENGINE WILL NOT BE PRINTED OUT BECAUSE THE FUEL IS NOT CORRECT
		System.out.println("engine 2 value: " + s2_i.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 2");
	}
// try s2_v
	try
	{
		engine s2_v = new engine("GAS", 18);
		System.out.println("other prototype of engine 2 value: " + s2_v.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 3 ");
	}


// try s3
	try
	{
		engine s3 = new engine("water",	18);
		System.out.println("engine 3 value: " + s3.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format for engine 3");
	}

// try s4 and compare with s2v
	try
	{
		engine s2_v = new engine("GAS",		18);
		engine s4 = new engine("GAS"	,	2);
		if (s4.equals(s2_v) == true)
		{
			System.out.println(" engine 4 equal to engine  2. Engine 2 can be replaced by engine 4:   \n" + s4);
		}
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 4");
	}
	
// try s5
	try
	{
		engine s5 = new engine("GAS"	,	20);
		System.out.println("fighter Jet 5 value: " + s5.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 5");
	}	

// try s6
	try
	{
		engine s6 = new engine("GAS"		,20);
		System.out.println("engine  6 value: " + s6.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 6");
	}	

// try s7
	try
	{
		engine s7 = new engine("NUCLEAR POWER",	18);
		System.out.println("engine  7 value: " + s7.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 7");
	}	

	
// try s8
	try
	{
		engine s8 = new engine("HYDROGEN", 18);   
		System.out.println("engine 8 value: " + s8.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 8");
	}	

	
			
		
	



	
	
	
	

}
}
