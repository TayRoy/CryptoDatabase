// CLASS: Mine
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a mining transaction's info
//
//-----------------------------------------

public class Mine extends Transaction {
  
  public Mine(String id, String symbol, int quantity) {
    user1 = id;
    crypto1 = symbol;
    quantity1 = quantity;
    next = null;
    setHash(0, 0);
  }
  
  public void print() {
    //prints out the mine's info
    System.out.print(user1 + " mined " + quantity1 + " " + crypto1);
    System.out.println(" (Hash: " + getHash() + ")");
  }
  
}//Mine