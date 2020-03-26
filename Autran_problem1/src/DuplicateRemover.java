import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Set;

public class DuplicateRemover {
   
  ArrayList<String> uniqueWords;
  public void remove(String dataFile)
  {

   uniqueWords= new  ArrayList<String>();
    try {
      //File myObj = new File("problem1.txt");
      File myObj = new File(dataFile);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data[] = myReader.nextLine().split(" ");
        for (int i=0;i<data.length;i++)
        {
        	uniqueWords.add(data[i]);
        	
        }
        
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  //  System.out.println(uniqueWords);
    ArrayList<String> 
    newList = removeDuplicates(uniqueWords); 
    
    //System.out.println(newList);
  
  }
  
  public void write (String outputFile)
  {

	    try {
	      FileWriter myWriter = new FileWriter(outputFile);
	      myWriter.write(uniqueWords.toString());
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  
  }
  
  
  public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
  { 

      // Create a new LinkedHashSet 
      Set<T> set = new LinkedHashSet<>(); 

      // Add the elements to set 
      set.addAll(list); 

      // Clear the list 
      list.clear(); 

      // add the elements of set 
      // with no duplicates to the list 
      list.addAll(set); 

      // return the list 
      return list; 
  } 
  
}