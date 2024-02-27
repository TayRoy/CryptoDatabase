// CLASS: Crypto
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a cryptocurrency's info
//
//-----------------------------------------

public class Crypto extends TypeItem {
  
  public int quantity;
  public Blockchain myBlockchain;
  
  public Crypto(String name, String symbol, int quantity, ListItem next) {
    this.name = name;
    this.identifier = symbol;
    this.quantity = quantity;
    this.next = next;
    myBlockchain = new Blockchain();
  }
  
  public void print() {
    //prints out all the info of the crypto
    System.out.println("NAME: " + name + " (" + identifier + ")");
    System.out.println("BANK: " + quantity + " " + identifier);
    System.out.println("LIST OF TRANSACTIONS:");
    myBlockchain.print();
  }
  
  
  
}//Crypto