// CLASS: Trade
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a trading transaction's info
//
//-----------------------------------------

public class Trade extends Transaction {
  
  public String user2;
  public String crypto2;
  public int quantity2;
  
  public Trade(String id1, String id2, String symbol1, String symbol2, int quantity1, int quantity2) {
    user1 = id1;
    user2 = id2;
    crypto1 = symbol1;
    crypto2 = symbol2;
    this.quantity1 = quantity1;
    this.quantity2 = quantity2;
    next = null;
    setHash(0, 0);
  }
  
  public void print() {
    //prints out the trade's info
    System.out.print(user1 + " traded " + quantity1 + " " + crypto1 + " to " +
                       user2 + " for " + quantity2 + " " + crypto2);
    System.out.println(" (Hash: " + getHash() + ")");
  }
  
}//Trade