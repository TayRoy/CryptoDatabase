// CLASS: Blockchain
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a cryptocurrency's transactions
//
//-----------------------------------------

public class Blockchain extends List {
  
  public Transaction end;
  
  public Blockchain() {
    top = null;
    end = null;
  }
  
  public void addBlock(Transaction block) {
    //adds a block to the blockchain
    if(end == null) {
      block.setHash(block.hashCode(), 0);
      top = block;
      end = block;
    }
    else {
      block.setHash(block.hashCode(), end.getHash());
      end.next = block;
      end = block;
    }
  }
  
  public void print() {
    //prints out the block info of all blocks in the blockchain
    Transaction curr = (Transaction)top;
    long correct_hash = 0;
    long blockchain_hash = 0;
    while(curr != null) {
      curr.print();
      correct_hash += curr.getHash();
      blockchain_hash += curr.hashCode();
      curr = (Transaction)curr.next;
    }
    if(correct_hash == blockchain_hash)
      System.out.println("Successful report.");
    else
      System.out.println("ERROR: Block(s) altered");
    System.out.println("---------------------------------------------------------");
  }
  
}//Blockchain