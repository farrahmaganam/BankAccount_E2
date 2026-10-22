package BankAccount2;

public interface Bank {

  BankAccount addAccount(BankAccount account);
  BankAccount getAccount(int id);
  void listAccounts();

}
