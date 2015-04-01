import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class run {

	static Scanner in = new Scanner(System.in);
	static BufferedReader reader = null;
	static FileReader fr = null;
	static FileWriter fw = null;
	static BufferedWriter writer = null;
	public static String input = "";
	public static String initialDirectory = "";
	public static String fileDirectory = "";
	public static String pathDirectory = "";
	public static String savedDirectory = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkDirectory();
				
	}

	static void menu() {
		System.out.println("");
		System.out.println("Current set Directory is: " + savedDirectory);
		System.out.println("");
		System.out.println("Choose the following option: ");
		System.out.println("1: Basic \" \" \" mark");
		System.out.println("2: Specialized \" ¡° \" mark");
		System.out.println("3: run both");
		System.out.println("4: set Directory");
		
		System.out.print("input: ");
		input = in.nextLine();
		
		if (input.equals("1")) {
			sameSign();
		} else		
		if (input.equals("2")) {
			readFiles();
		} else 		
		if (input.equals("3")) {
			both();
		} else 		
		if (input.equals("4")) {
			setDirectory();
		} else {
			System.out.println("Wrong Input! Try valid input");
			menu();
		}
		
	}
	
	static String changeDirectoryName(String directory) {
		String newDirectory = "";
		
		for (int i = 0; i < directory.length(); i++) {
			if ((directory.charAt(i) + "").equals("\\") ) {
				newDirectory += "\\";
				newDirectory += (directory.charAt(i) + "");			
			} else {
				newDirectory += (directory.charAt(i) + "");
			}
		}
		newDirectory += "\\\\";
		return newDirectory;
	}
	
	static void checkDirectory() {
		try {
			File runFile = new File("run.java");
			String runFileDirectory = runFile.getAbsoluteFile().getParentFile().getAbsolutePath();
		//	System.out.println(runFileDirectory);
			
			runFileDirectory = changeDirectoryName(runFileDirectory);
			fileDirectory = runFileDirectory;
			
			pathDirectory = runFileDirectory + "path.txt";
			//System.out.println(fileDirectory);
			
			
			File myFile = new File(pathDirectory);
			
		//	System.out.println(myFile.getAbsolutePath());
			
			if (!myFile.exists()) {
				System.out.println("No directory saved! Set your directory!");
				setDirectory();				
			} else {
				readDirectory();
				menu();
			}
			
		} catch (Exception e) {

		}
		
	}
	
	static void readDirectory() {
		
		File file = new File(pathDirectory);
		
		try {

		FileInputStream fin = null;
		InputStreamReader inputStream = null;
		BufferedReader bufferedReader = null;
		Scanner sc = null;
		
    	inputStream = new InputStreamReader(new FileInputStream(file),"UTF-8");
    	bufferedReader = new BufferedReader(inputStream);
    	sc = new Scanner(inputStream);


    	String readLine = "";
    	
    	readLine = sc.nextLine();
    	savedDirectory = changeDirectoryName(readLine); 	
		
		} catch (Exception e) {
			
			
		} 
		
	}
	
	static void setDirectory() {
		System.out.println("Enter your directory: ");		
		initialDirectory = in.nextLine();
		System.out.println("Your directory is: " + initialDirectory);
		System.out.println("1 to proceed");
		System.out.println("2 to re-enter");

		System.out.print("input: ");
		input = in.nextLine();
		
		switch (input) {
			case "1":
				try {
					String output = "path.txt";
			    	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));		
			    	
		        	out.append(initialDirectory);
					out.close();					
				} catch (Exception e) {
					
				} finally {
					checkDirectory();
					break;
				}
			case "2":
				initialDirectory = "";
				setDirectory();
				break;
		}
	}
	
	static void both() {
		try {
			System.out.println("3: Make sure your txt file is in UTF-8 format!");
			System.out.println("3: Type the file name ");
			
			System.out.print("input: ");
			input = in.nextLine();
			
    		//String dir = "C:\\Users\\Keine\\Desktop\\trial";
        	//String output = "C:\\Users\\Keine\\Desktop\\trial\\" + "both modified " + input;
    		
    		String dir = savedDirectory;
        	String output = fileDirectory + "converted\\" + "both modified " + input;
        		
        	File folder = new File("converted");
        	if (!folder.exists()) {
            	folder.mkdir();        		
        	}

        	
        	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
        		
    		
    		String fileDirectory = dir + input;
 		

    		FileInputStream fin = null;
    		InputStreamReader inputStream = null;
    		BufferedReader bufferedReader = null;
    		Scanner sc = null;
    		
    		
    		System.out.println("Your file is " + fileDirectory);
	    	File file = new File(fileDirectory);
	    			
	    	inputStream = new InputStreamReader(new FileInputStream(file),"UTF-8");
	    	bufferedReader = new BufferedReader(inputStream);
	    	sc = new Scanner(inputStream);
	

	    	String readLine = "";
	    	boolean firstQuotation = false;
	    	boolean secondQuotation = false;
	    	//ArrayList quotations = new ArrayList();
	    	
	    	while (sc.hasNext()) {
	    		String line = "";
	    		line = sc.nextLine();
//	    		System.out.println(line);
//	    		System.out.println("0000000000000000000000000000000000000000000000000");
	    		String newLine = "";
	    		boolean extra = false;
	    		for (int i = 0; i < line.length(); i++) {
	    			System.out.println(line.length() + "	i: " + i);
	    			if (line.substring(i,i+1).equals("¡±") || line.substring(i,i+1).equals("¡°")) {		    		

    					if (line.substring(i,i+1).equals("¡±")) {
			    			newLine += line.charAt(i) + " \n" + " \n";
    					} else if (line.substring(i,i+1).equals("¡°")) {
    						try {
			    				if (!line.substring(i-1,i).equals("¡±")) {
			    					newLine += " \n";	
			    				}
			    			} catch (Exception e) {
			    				
			    			} finally {
			    				newLine += " \n" + line.charAt(i);
			    			}
						}
	    			} else if (line.substring(i,i+1).equals("\"")) {		    		
	    				if (firstQuotation == true && secondQuotation == false) {
			    			try {
			    				if (line.substring(i,i+1).equals("\"") || line.substring(i+1,i+2).equals("\"")) {
			    					extra = true; 
			    				}			    				
			    			} catch (Exception e) {
			    				
			    			} finally {
		    					secondQuotation = true;
				    			newLine += line.charAt(i) + " \n";	
				    			if (extra = true) {
				    				newLine += " \n";	
				    				extra = false;
				    			}
			    			}
			    		}	else if (firstQuotation == false) {
			    			try {
			    				if (!line.substring(i-1,i).equals("\"")) {
			    					newLine += " \n";
			    				}
			    				
			    			} catch (Exception e) {
			    				
			    			} finally {
				    			newLine += " \n" + line.charAt(i);
				    			firstQuotation = true;			    				
			    			}

			    		} 
			    		if (firstQuotation == true && secondQuotation == true) {
			    			firstQuotation = false;
			    			secondQuotation = false;
			    		}

	    			} else {
		    			newLine += line.charAt(i);	    				
	    			}
	    			//System.out.println(newLine);
	    		}
	    		System.out.println("next");
	    		out.append(newLine);
	    		
	    		firstQuotation = false;
	    		secondQuotation =false;
	    	}
	    	
	    	sc.close();
	    	out.close();

		} catch (Exception e) {
	        System.out.println(e);
	        System.out.println("Directory or files not found! Retry:");
	        readFiles();
		} finally {
			if(reader != null) try{reader.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
			

			if(writer != null) try{writer.close();}catch(IOException e){}
			if(fw != null) try{fw.close();}catch(IOException e){}
			System.out.println("Done");
			menu();
		}			
		
		
	}
	
	static void sameSign() {	
		try {
			System.out.println("1: Make sure your txt file is in UTF-8 format!");
			System.out.println("1: Type the file name (check your directory in the code)");
			
			System.out.print("input: ");
			input = in.nextLine();
			
			
    		//String dir = "C:\\Users\\Keine\\Desktop\\trial";
        	//String output = "C:\\Users\\Keine\\Desktop\\trial\\" + "both modified " + input;
    		
    		String dir = savedDirectory;
        	String output = fileDirectory + "converted\\" + "same sign modified " + input;
        	
        	File folder = new File("converted");
        	if (!folder.exists()) {
            	folder.mkdir();        		
        	}
    		
        	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
        		
    		
    		String fileDirectory = dir + input;
 		

    		FileInputStream fin = null;
    		InputStreamReader inputStream = null;
    		BufferedReader bufferedReader = null;
    		Scanner sc = null;
    		
    		
    		System.out.println("Your file is " + fileDirectory);
	    	File file = new File(fileDirectory);
	    			
	    	inputStream = new InputStreamReader(new FileInputStream(file),"UTF-8");
	    	bufferedReader = new BufferedReader(inputStream);
	    	sc = new Scanner(inputStream);
	

	    	String readLine = "";
	    	boolean firstQuotation = false;
	    	boolean secondQuotation = false;
	    	//ArrayList quotations = new ArrayList();
	    	
	    	while (sc.hasNext()) {
	    		String line = "";
	    		line = sc.nextLine();
//	    		System.out.println(line);
//	    		System.out.println("0000000000000000000000000000000000000000000000000");
	    		String newLine = "";
	    		boolean extra = false;
	    		for (int i = 0; i < line.length(); i++) {
	    			System.out.println(line.length() + "	i: " + i);
	    			if (line.substring(i,i+1).equals("\"")) {		    		
	    				if (firstQuotation == true && secondQuotation == false) {
			    			try {
			    				if (line.substring(i,i+1).equals("\"") || line.substring(i+1,i+2).equals("\"")) {
			    					extra = true; 
			    				}			    				
			    			} catch (Exception e) {
			    				
			    			} finally {
		    					secondQuotation = true;
				    			newLine += line.charAt(i) + " \n";	
				    			if (extra = true) {
				    				newLine += " \n";	
				    				extra = false;
				    			}
			    			}
			    		}	else if (firstQuotation == false) {
			    			try {
			    				if (!line.substring(i-1,i).equals("\"")) {
			    					newLine += " \n";
			    				}
			    				
			    			} catch (Exception e) {
			    				
			    			} finally {
				    			newLine += " \n" + line.charAt(i);
				    			firstQuotation = true;			    				
			    			}

			    		} 
			    		if (firstQuotation == true && secondQuotation == true) {
			    			firstQuotation = false;
			    			secondQuotation = false;
			    		}

	    			} else {
		    			newLine += line.charAt(i);	    				
	    			}
	    			//System.out.println(newLine);
	    		}
	    		System.out.println("next");
	    		out.append(newLine);
	    	}
	    	
	    	sc.close();
	    	out.close();

		} catch (Exception e) {
	        System.out.println(e);
	        System.out.println("Directory or files not found! Retry:");
	        readFiles();
		} finally {
			if(reader != null) try{reader.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
			

			if(writer != null) try{writer.close();}catch(IOException e){}
			if(fw != null) try{fw.close();}catch(IOException e){}
			System.out.println("Done");
			menu();
		}		
		
		
		
		
		
	}
	
	static void readFiles() {
		try {
			System.out.println("2: Make sure your txt file is in UTF-8 format!");
			System.out.println("2: Type the file name (check your directory in the code)");
			
			System.out.print("input: ");
			input = in.nextLine();
			
    		//String dir = "C:\\Users\\Keine\\Desktop\\trial";
        	//String output = "C:\\Users\\Keine\\Desktop\\trial\\" + "both modified " + input;
    		
    		String dir = savedDirectory;
        	String output = fileDirectory + "converted\\" + "different sign modified " + input;
        	
        	File folder = new File("converted");
        	if (!folder.exists()) {
            	folder.mkdir();        		
        	}
    		
        	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
        		
    		
    		String fileDirectory = dir + input;
 		

    		FileInputStream fin = null;
    		InputStreamReader inputStream = null;
    		BufferedReader bufferedReader = null;
    		Scanner sc = null;
    		
    		
    		System.out.println("Your file is " + fileDirectory);
	    	File file = new File(fileDirectory);
	    			
	    	inputStream = new InputStreamReader(new FileInputStream(file),"UTF-8");
	    	bufferedReader = new BufferedReader(inputStream);
	    	sc = new Scanner(inputStream);
	

	    	String readLine = "";
	    	boolean firstQuotation = false;
	    	boolean secondQuotation = false;
	    	//ArrayList quotations = new ArrayList();
	    	
	    	while (sc.hasNext()) {
	    		String line = "";
	    		line = sc.nextLine();
//	    		System.out.println(line);
//	    		System.out.println("0000000000000000000000000000000000000000000000000");
	    		String newLine = "";
/*	    		for (int i = 0; i < line.length(); i++) {
	    			if (line.substring(i,i+1).equals("¡±") || line.substring(i,i+1).equals("¡°")) {		    		
	    				if (firstQuotation == true && secondQuotation == false) {
			    			secondQuotation = true;
			    			newLine += line.charAt(i) + " \n";	
			    			try {
			    				if (!line.substring(i+1,i+2).equals("¡°")) {
			    					newLine += " \n";	
			    				}
			    			} catch (Exception e) {
			    				
			    			}
			    		}	else if (firstQuotation == false) {
			    			try {
			    				if (!line.substring(i-1,i).equals("¡±")) {
			    					newLine += " \n";	
			    				}
			    			} catch (Exception e) {
			    				
			    			} finally {
				    			newLine += " \n" + line.charAt(i);
				    			firstQuotation = true;
			    			}
			    		} 
			    		if (firstQuotation == true && secondQuotation == true) {
			    			firstQuotation = false;
			    			secondQuotation = false;
			    		}

	    			} else {
		    			newLine += line.charAt(i);	    				
	    			}*/
	    		
	    		
/*	    		for (int i = 0; i < line.length(); i++) {
	    			if (line.substring(i,i+1).equals("¡±") || line.substring(i,i+1).equals("¡°")) {		    		

	    					if (firstQuotation == true && secondQuotation == false) {
	    						newLine += line.charAt(i) + " \n";
	    						firstQuotation = false;
	    					} else if (firstQuotation == false) {
	    						newLine += " \n" + line.charAt(i);
	    						firstQuotation = true;
							}
	    					
	    			} else {
		    			newLine += line.charAt(i);	    				
	    			}	    		
	    		}*/
	    		for (int i = 0; i < line.length(); i++) {
	    			if (line.substring(i,i+1).equals("¡±") || line.substring(i,i+1).equals("¡°")) {		    		

	    					if (line.substring(i,i+1).equals("¡±")) {
				    			newLine += line.charAt(i) + " \n" + " \n";
	    					} else if (line.substring(i,i+1).equals("¡°")) {
	    						try {
				    				if (!line.substring(i-1,i).equals("¡±")) {
				    					newLine += " \n";	
				    				}
				    			} catch (Exception e) {
				    				
				    			} finally {
				    				newLine += " \n" + line.charAt(i);
				    			}
							}
	    					
	    			} else {
		    			newLine += line.charAt(i);	    				
	    			}

	    		}	    		
	    		out.append(newLine);
	    		
	    		
	    	}
	    	
	    	sc.close();
	    	out.close();
	    	
/*		    	while (sc.hasNext("\"")) {
		    		if (firstQuotation = false) {
		    			firstQuotation = true;
		    			
		    		}
				
		    	}
*/

/*    		

   		
    	out.append(holder);
    		
    	out.close();
    */
     
	        
		} catch (Exception e) {
	        System.out.println(e);
	        System.out.println("Directory or files not found! Retry:");
	        readFiles();
		} finally {
			if(reader != null) try{reader.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
			

			if(writer != null) try{writer.close();}catch(IOException e){}
			if(fw != null) try{fw.close();}catch(IOException e){}
			System.out.println("Done");
			menu();
		}
	}
}
