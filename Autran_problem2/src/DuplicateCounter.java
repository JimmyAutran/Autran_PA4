import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {
	  
	  ArrayList<String> wordCounter;
	  Set<String> unique;
	  public void count (String dataFile)
	  {

		  wordCounter= new  ArrayList<String>();
		  
		  
		    try {
		        File myObj = new File(dataFile);
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		          String data[] = myReader.nextLine().split(" ");
		          for (int i=0;i<data.length;i++)
		          {
		        	  wordCounter.add(data[i]);
		          }
		          
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		    
			  unique = new HashSet<String>(wordCounter);

		    }
	  
	  public void write (String outputFile)
	  {

		    try {
		      FileWriter myWriter = new FileWriter(outputFile);
			  for (String key : unique) {
			      myWriter.write(key + ": " + Collections.frequency(wordCounter, key)+"\n");
			  }
		      
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
	  }
	  
}
