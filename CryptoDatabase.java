//-----------------------------------------
// NAME  : Taylor Roy
// ASSIGNMENT : 1    
// 
// REMARKS: Create a cryptocurrency database with blockchains and investors.
//
//-----------------------------------------

import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class CryptoDatabase {
  
  public static void main(String[] args) {
    readData("A1input.txt");
  }
  
  public static void readData(String fileName) {
    //Reads in from a file and does the appropriate task depending on the input
    Scanner in = null;
    try {
      in = new Scanner((new FileReader(fileName)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    Database test_database = new Database();
    String line = in.nextLine();
    while(in.hasNextLine()) {
      String[] parts = line.split("\\s+");
      String task = parts[0];
      if(task.equals("NEW")) {
        test_database.addInvestor(parts);
      }
      else if(task.equals("CRYPTO")) {
        test_database.addCrypto(parts);
      }
      else if(task.equals("MINE")) {
        Mine newMine = new Mine(parts[1], parts[2], Integer.parseInt(parts[3]));
        test_database.makeMine(newMine);
      }
      else if(task.equals("TRADE")) {
        Trade newTrade = new Trade(parts[1], parts[2], parts[3], parts[5], 
                                   Integer.parseInt(parts[4]), Integer.parseInt(parts[6]));
        test_database.makeTrade(newTrade);
      }
      else if(task.equals("REPORT")) {
        test_database.allInvestors.print(parts[1]);
      }
      else if(task.equals("CRYPORT")) {
        test_database.allCryptos.print(parts[1]);
      }
      else if(task.equals("#")) {
        for(int i=0; i<parts.length; i++) {
          System.out.print(parts[i]);
          if(i==parts.length-1)
            System.out.println();
          else
            System.out.print(" ");
        }
      }
      else if(task.equals("END")) {
        System.out.println("DONE");
        in.close();
      }
      else {
        System.out.println("ERROR: Invalid prompt from input");
      }
      line = in.nextLine();
    }
    if(!line.equals("END")) {
      System.out.println("ERROR: Input was not ended");
      in.close();
    }
  }
  
}//end class