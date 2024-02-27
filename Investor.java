// CLASS: Investor
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain an investor's info
//
//-----------------------------------------

public class Investor extends TypeItem {
  
  public CryptoList myCryptos;
  
  public Investor(String name, String id, int quantity, ListItem next) {
    this.name = name;
    this.identifier = id;
    this.next = next;
    myCryptos = new CryptoList();
    myCryptos.newCrypto("CanadianDollar", "CAD", quantity);
  }
  
  public void print() {
    //prints out the info of an investor
    System.out.println("\nNAME: " + name);
    System.out.println("  ID: " + identifier);
    Crypto myCAD = myCryptos.search("CAD");
    System.out.println("BANK: " + myCAD.quantity + "CAD");
    System.out.println("LIST OF OWNED CRYPTOS:");
    myCryptos.print();
  }
  
}//Investor