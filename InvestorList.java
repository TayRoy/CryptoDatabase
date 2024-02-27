// CLASS: InvestorList
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a list of investors
//
//-----------------------------------------

public class InvestorList extends List {
  
  public InvestorList() {
    top = null;
  }
  
  public void newInvestor(String name, String id, int bank) {
    //adds an investor to the list
    Investor newInvestor = search(id);
    if(newInvestor == null) {
      top = new Investor(name, id, bank, top);
      System.out.println("Success.");
    }
    else
      System.out.println("ERROR: Duplicate investor");
  }
  
  public Investor search(String id) {
    //returns the investor being searched
    Investor curr = (Investor)top;
    while(curr != null && !curr.identifier.equals(id))
        curr = (Investor)curr.next;
    return curr;
  }
  
  public void print(String investor_id) {
    //prints out a specified investor in the list
    Investor investor_to_print = search(investor_id);
    if(investor_to_print == null)
      System.out.println("ERROR: Investor not found");
    else
      investor_to_print.print();
  }
  
}//InvestorList