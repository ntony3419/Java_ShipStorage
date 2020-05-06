import java.io.*;
import java.util.*;
public class FileManager
{	/***** file reader
	* SUBMODULE: fileRead
	* IMPORT: none
	* EXPORT: shipStorage class
	* ASSERTION: read line by line in the file and create an object Storage
	****************/		
	public static void importData(String fileName, ShipStorage aStorage) throws IOException
	{					
		UserInterFace UserInterFace = new UserInterFace();
		FileInputStream fileStrm = null;					
		InputStreamReader rdr;
		BufferedReader bRead;
		String line;							
		int lineNum=0;		
		String[] shipValues = new String[7];		

		try { 
			fileStrm = new FileInputStream(fileName);
			rdr = new InputStreamReader(fileStrm);
			bRead = new BufferedReader(rdr);
			lineNum=0;					
			int nextLine = 0;
			line = bRead.readLine();
			System.out.println("Loading Submarine data from file: "+fileName+"\n");
				while (line !=null)
				{
					lineNum++;				
					shipValues = processLine(line);	
					if (shipValues.length != 7)
					{
						System.out.println("One of the data input is missing. Check file. return menu" ); 
						lineNum++;
					}
					else if (shipValues[0].length() !=1)
					{
						System.out.println("Type must be 'S' for Submarine or 'F' fighter jet in line number : " + lineNum+"\n");
						lineNum++;
					}
					else 
					{				
						Engine inEngine = new Engine(shipValues[4],Integer.parseInt(shipValues[3]));	
						switch (shipValues[0])					
						{
							case "s": case "S":								
										Submarine newSub = new Submarine(shipValues[1],Integer.parseInt(shipValues[2]),shipValues[5], inEngine, Double.parseDouble(shipValues[6]));
										aStorage.addShip(newSub);												
									break;					
							case "F": case "f":							
								FighterJet newJet = new FighterJet(shipValues[1], Integer.parseInt(shipValues[2]), shipValues[6], inEngine, Double.parseDouble(shipValues[5]));							
								aStorage.addShip(newJet);
								
							break;
							default:
								System.out.println("Please start the line with the type of machine 'S' Or 'F' only.\n");
								lineNum++;
							break;
						}
					}				
				line = bRead.readLine();				
				}	
				System.out.println("\nAll data loaded \n\nDone\n");			
				fileStrm.close();
		}	
			catch (IOException e){ System.out.println("can't open file " );}					
		return;			
	}
	
	/***** 
	* SUBMODULE: 
	* IMPORT: 
	* EXPORT: 
	* ASSERTION: 
	****************/	
	public static String[] processLine(String csvRow)
	{
		String[] shipValues = new String[7];
		String thisToken = null;
		StringTokenizer strTok;
		strTok = new StringTokenizer(csvRow, ",");
	
			while (strTok.hasMoreTokens())
			{
				for (int i=0; i <shipValues.length;i++)
				{
				thisToken = strTok.nextToken();
				shipValues[i]=thisToken;
				
				}
			}
	
		return shipValues;
	}	
	
	/***** file writer method
	* SUBMODULE: save data into file
	* IMPORT: String inFileName, Submarine[] inSubArray, FighterJet[] inFighterArray, inCountShip, inCountJet
	* EXPORT: none
	* ASSERTION: write data to file line by line
	****************/	
	public static void writeToFile(String inFileName, ShipStorage aStorage)
	{
		FileOutputStream fileStrm = null;
		PrintWriter pw;			
		try {			
			fileStrm = new FileOutputStream(inFileName);
			pw = new PrintWriter(fileStrm);			
			for (int i = 0; i <aStorage.getCountShip();i++)
			{
				if (aStorage.getShipArray()[i] instanceof Submarine)
				{
					pw.println("s" + "," + aStorage.getShipArray()[i].getSerialNum() +"," + String.valueOf(aStorage.getShipArray()[i].getYear()) + "," + 
									String.valueOf(aStorage.getShipArray()[i].getEngine().getCylinder()) +
										"," + aStorage.getShipArray()[i].getEngine().getFuel() +","+ ((Submarine)aStorage.getShipArray()[i]).getHull() + "," + 
										String.valueOf(((Submarine)aStorage.getShipArray()[i]).getMaxDepth()));
				}
				else if (aStorage.getShipArray()[i] instanceof FighterJet)
				{
					pw.println("f" + "," + aStorage.getShipArray()[i].getSerialNum() +"," + String.valueOf(aStorage.getShipArray()[i].getYear()) + "," + 
									String.valueOf(aStorage.getShipArray()[i].getEngine().getCylinder()) +
										"," + aStorage.getShipArray()[i].getEngine().getFuel() +","+ ((FighterJet)aStorage.getShipArray()[i]).getOrdanance() + "," + 
										String.valueOf(((FighterJet)aStorage.getShipArray()[i]).getWingSpan()));
				}		
			}
				pw.close();			
			System.out.println("\nAll data are exported into "+inFileName);
			System.out.println("\n");
		}
		catch  (IOException e)
		{
			if (fileStrm!=null)
		{
		try 
		{
			fileStrm.close(); 
		} 
		catch (IOException ex) {}	
		}
		System.out.println("error writing file" + e.getMessage());
		}			
	}	
}
