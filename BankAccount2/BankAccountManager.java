package BankAccount2;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager implements Bank {

  private static final int MAX_ACCOUNTS = 100;

  private final Map<Integer, BankAccount> accounts;
  private int id;

  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  //ADD ACCOUNT
  public BankAccount addAccount(BankAccount account) {
    if (accounts.size() >= MAX_ACCOUNTS) {
      throw new IllegalStateException("Cannot add account: maximum of 100 accounts reached.");
    }
    accounts.put(id++, account);
    return account;
  }

  //GET ACCOUNT
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  //LIST ACCOUNT
  public void listAccounts() {
    if (accounts.isEmpty()) {
      System.out.println("No accounts available.");
      return;
    }

    System.out.println("Bank accounts:");
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      String ownerName = account instanceof SavingsAccount
          ? ((SavingsAccount) account).getOwnerName()
          : "Unknown";
      System.out.printf("ID: %d, Owner: %s, Balance: %.2f%n",
          entry.getKey(), ownerName, account.getBalance());
    }
  }

}
