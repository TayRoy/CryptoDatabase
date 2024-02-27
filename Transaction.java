// CLASS: Transaction
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Parent class for transactions
//
//-----------------------------------------

public abstract class Transaction extends ListItem {
      
  public String user1;
  public String crypto1;
  public int quantity1;
  private long hash;
  
  public abstract void print();
  public void setHash(long my_hash, long prev_hash) { hash = my_hash + prev_hash; }
  public long getHash() { return hash; }
  public void addHash(long prev_hash) { hash += prev_hash; }
  
}