import java.util.*;
public class testFighterJet
{
public static void main(String[] args)
{
//try s1 : create default value for jet 1
	try
	{
	fighterJet s1 = new fighterJet();
	System.out.println("fighter Jet 1 value: \n" + s1.toString());
	}
	catch (IllegalArgumentException e)
	{
		
		System.out.println("some of the  values are not  correct format 1");
	}
/* try s2  satisfy all condition 100.001<= serialNum <= 300.999, 1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.6
*/
	try
	{
		fighterJet s2 = new fighterJet("156.321", 1996, "SUBMACHINE GUN", 2.20);
		System.out.println("fighter Jet 2 value: \n" + s2.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 2");
	}
/* try s3  satisfy 3 condition 100.001<= serialNum <= 300.999
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.6
*			year did not satisfy condition 1950<=year <=2022
*/
	try
	{
		fighterJet s3 = new fighterJet("156.321", 0, "SUBMACHINE GUN", 2.20);
		System.out.println("fighter Jet 3 value: 'n" + s3.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 3 ");
	}



/* try s4 and compare with 3
*	both satisfy 4 condition 100.001<= serialNum <= 300.999
*				1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.7
*			AND s4's ordanance and wingspan must be the same as s3 ordanance and wingspan
*/
	try
	{
		fighterJet s3_test = new fighterJet("100.200", 2005, "SUBMACHINE GUN", 2.20);//("156.321", 1996, "SUBMACHINE GUN", 2.20);
		fighterJet s4 = new fighterJet("111.333", 2005, "SUBMACHINE GUN", 2.20);
		if (s4.equals(s3_test) == true)
		{
			System.out.println("fighter Jet 4 can replace fighter Jet  3:\n " + s4);
		}
		else
		{
			System.out.println("fighter jet 4 CAN NOT replace fighter jet 3.");
		}
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 4");
	}
	
/* try s5 
*	 satisfy  condition 
*				1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.6
*	did not satisfy		100.001<= serialNum <= 300.999
*/
	try
	{
		fighterJet s5 = new fighterJet("500.321", 1996, "SUBMACHINE GUN", 2.20);
		System.out.println("fighter Jet 5 value: \n" + s5.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 5");
	}	

/* try s6
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*				1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 < = wingSpan <= 25.6 inclusive
*/
	try
	{
		fighterJet s6 = new fighterJet("156.321", 1996, "ROCKET MISSLE", 2.20);
		System.out.println("fighter Jet 6 value: 'n" + s6.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 6");
	}	

/* try s7
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*				1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*	did not satisfy		2.20 <=wingSpan <=25.6 inclusive
*/

	try
	{
		fighterJet s7 = new fighterJet("156.321", 1996, "SUBMACHINE GUN", 25.7);
		System.out.println("fighter Jet 7 value: \n" + s7.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 7");
	}	

/* try s8
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*				1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.6 inclusive
*/

	try
	{
		fighterJet s8 = new fighterJet("156.321", 1996, "ALL SYSTEM INCLUDED", 2.20);
		System.out.println("fighter Jet 8 value: \n" + s8.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 8");
	}	
	
		
/* try s9
*	 satisfy  all condition 
*				100.001<= serialNum <= 300.999
*	did not satisfy		1950<=year <=2022
*				ordanance = "SUBMACHINE GUN" OR "ROCKET MISSLE" OR ALL WEPON
*				2.20 <=wingSpan <=25.6 inclusive
*/

	try
	{
		fighterJet s9 = new fighterJet("156.321", 2080, "SUBMACHINE GUN", 2.20);
		System.out.println("fighter Jet 9 value: \n" + s9.toString());
	}
	catch (IllegalArgumentException e)
	{

		System.out.println("some of the  values are not  correct format 9");
	}
	



	
	
	
	

}
}
