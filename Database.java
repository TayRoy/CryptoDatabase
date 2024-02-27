// CLASS: Database
//
// Author: Taylor Roy, 7812747
//
// REMARKS: Maintain a universe where the cryptos and investors exist
//
//-----------------------------------------

public class Database {
  
  public InvestorList allInvestors;
  public CryptoList allCryptos;
  
  public Database() {
    allInvestors = new InvestorList();
    allCryptos = new CryptoList();
  }
  
  public void addInvestor(String[] info) {
    //adds an investor to the database
    allInvestors.newInvestor(info[1] + " " + info[2], info[3], Integer.parseInt(info[4]));
  }
  
  public void addCrypto(String[] info) {
    //adds a crypto to the database
    allCryptos.newCrypto(info[1], info[2], Integer.parseInt(info[3]));
  }
  
  public void makeMine(Mine block) {
    //adds and performs the necessary tasks for the mine transaction
    //search for investor and crypto in database
    Investor user = allInvestors.search(block.user1);
    Crypto crypto = allCryptos.search(block.crypto1);
    //check if both exist
    if(user != null && crypto != null) {
      //check for sufficient funds
      if(block.quantity1 <= crypto.quantity) {
        //add mined crypto to investor funds
        Crypto user_crypto = user.myCryptos.search(block.crypto1);
        //if investor does not already own the crypto, add it to their funds
        if(user_crypto != null)
          user_crypto.quantity += block.quantity1;
        else
          user.myCryptos.newCrypto(crypto.name, crypto.identifier, block.quantity1);
        //subtract mined crypto from crypto bank
        crypto.quantity -= block.quantity1;
        //add the block to the crypto's blockchain
        crypto.myBlockchain.addBlock(block);
      }
      else
        System.out.println("ERROR: Insufficient currency");
    }
    else {
      if(user == null)
        System.out.println("ERROR: Investor not found");
      if(crypto == null)
        System.out.println("ERROR: Cryptocurrency not found");
    }
  }
  
  public void makeTrade(Trade block) {
    //adds and performs the necessary tasks for the trade transaction
    //search for the investors in database
    Investor user1 = allInvestors.search(block.user1);
    Investor user2 = allInvestors.search(block.user2);
    //check if the investors exist 
    if(user1 != null && user2 != null) {
      //check that they aren't the same investor
      if(!user1.identifier.equals(user2.identifier)) {
        //search for outgoing cryptos of each investor 
        Crypto user1_crypto = user1.myCryptos.search(block.crypto1);
        Crypto user2_crypto = user2.myCryptos.search(block.crypto2);
        //check if those outgoing cryptos exist for both 
        if(user1_crypto != null && user2_crypto != null) {
          //check if sufficient funds for both
          if(user1_crypto.quantity >= block.quantity1 && user2_crypto.quantity >= block.quantity2) {
            //search for incoming cryptos of each investor 
            Crypto user1_crypto_new = user1.myCryptos.search(block.crypto2);
            Crypto user2_crypto_new = user2.myCryptos.search(block.crypto1);
            //create new crypto in investors' lists if not already owned
            if(user1_crypto_new == null) {
              user1.myCryptos.newCrypto(user2_crypto.name, user2_crypto.identifier, block.quantity2);
              user1_crypto_new = user1.myCryptos.search(block.crypto2);
            }
            else {
              user1_crypto_new.quantity += block.quantity2;
              user2_crypto.quantity -= block.quantity2;
            }
            if(user2_crypto_new == null) {
              user2.myCryptos.newCrypto(user1_crypto.name, user1_crypto.identifier, block.quantity1);
              user2_crypto_new = user2.myCryptos.search(block.crypto1);
            }
            else {
              user2_crypto_new.quantity += block.quantity1;
              user1_crypto.quantity -= block.quantity1;
            }
            //add the trade to the blockchain of the one or both cryptos
            if(user1_crypto_new.identifier.equals(user2_crypto_new.identifier)) {
              Crypto crypto_for_blockchain = allCryptos.search(user1_crypto_new.identifier);
              crypto_for_blockchain.myBlockchain.addBlock(block);
            }
            else {
              Crypto crypto1_for_blockchain = allCryptos.search(user1_crypto.identifier);
              Crypto crypto2_for_blockchain = allCryptos.search(user2_crypto.identifier);
              //must check for trade involving CAD
              if(crypto1_for_blockchain != null)
                 crypto1_for_blockchain.myBlockchain.addBlock(block);
              if(crypto2_for_blockchain != null)
                 crypto2_for_blockchain.myBlockchain.addBlock(block);
            }
            System.out.println("Success.");
          }
          else if(user1_crypto.quantity < block.quantity1)
            System.out.println("ERROR: Insufficient funds for " + user1.identifier);
          else if(user2_crypto.quantity < block.quantity2)
            System.out.println("ERROR: Insufficient funds for " + user2.identifier);
        }
        else if(user1_crypto == null)
          System.out.println("ERROR: Cryptocurrency not found for " + user1.identifier);
        else if(user2_crypto == null)
          System.out.println("ERROR: Cryptocurrency not found for " + user2.identifier);
      }
      else
        System.out.println("ERROR: Same trader");
    }
    else if(user1 == null)
      System.out.println("ERROR: " + block.user1 + " not found");
    else if(user2 == null)
      System.out.println("ERROR: " + block.user2 + " not found");
  }
  
}//Database