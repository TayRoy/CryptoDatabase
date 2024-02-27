// CLASS: CryptoList
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a list of cryptocurrencies
//
//-----------------------------------------

public class CryptoList extends List {
  
  public CryptoList() {
    top = null;
  }
  
  public void newCrypto(String name, String symbol, int quantity) {
    //adds a new crypto to the list
    Crypto newCrypto = search(symbol);
    if(newCrypto == null) {
      top = new Crypto(name, symbol, quantity, top);
      if(!symbol.equals("CAD")) 
        System.out.println("Success.");
    }
    else
      System.out.println("ERROR: Duplicate cryptocurrency");
  }
  
  public Crypto search(String symbol) {
    //returns the crypto being searched
    Crypto curr = (Crypto)top;
    while(curr != null && !curr.identifier.equals(symbol))
      curr = (Crypto)curr.next;
    return curr;
  }
  
  public void print() {
    //prints out the info of all cryptos in the list
    Crypto curr = (Crypto)top;
    while(curr != null) {
      if(!curr.identifier.equals("CAD") && curr.quantity > 0) {
        System.out.println(" CRYPTO: " + curr.name);
        System.out.println("  FUNDS: " + curr.quantity + " " + curr.identifier);
        System.out.println("----------------------------------------");
      }
      curr = (Crypto)curr.next;
    }
  }
  
  public void print(String crypto_symbol) {
    //prints out a specified crypto in the list
    Crypto crypto_to_print = search(crypto_symbol);
    if(crypto_to_print == null)
      System.out.println("ERROR: Crypto not found");
    else
      crypto_to_print.print();
  }
  
  
}//CryptoList