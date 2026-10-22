import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private double balance;
  private final String owner;
  private boolean frozen;
  private final List<Transaction> transactionHistory;

  public BankAccount() {
    this("");
  }

  public BankAccount(String owner) {
    this.owner = owner;
    this.transactionHistory = new ArrayList<>();
  }

  public void deposit(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }

    System.out.printf("Amount deposited: %.2f%n", amount);
    if (!Double.isFinite(amount) || amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  public void withdraw(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.printf("Amount withdrawn: %.2f%n", amount);
    if (!Double.isFinite(amount) || amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (amount > balance) {
      System.out.printf("Insufficient balance. Current balance: %.2f%n", balance);
      return;
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  public double getBalance() {
    return balance;
  }

  public String getOwner() {
    return owner;
  }

  public void freezeAccount() {
    frozen = true;
  }

  public void unfreezeAccount() {
    frozen = false;
  }

  public boolean isFrozen() {
    return frozen;
  }

  private double round(double amount) {
    return Double.isFinite(amount) ? Math.round(amount * 100.0) / 100.0 : amount;
  }
}
