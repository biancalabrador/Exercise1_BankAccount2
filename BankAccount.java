/**
 * Represents a bank account with deposit, withdrawal, and freeze operations.
 */
public class BankAccount {
  private double balance;
  private final String owner;
  private boolean frozen;

  public BankAccount(String owner) {
    this.owner = owner;
  }

  public void deposit(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }

    System.out.printf("Amount deposited: %.2f%n", amount);
    if (amount > 0) {
      balance += amount;

      System.out.printf("Current balance: %.2f%n", balance);
    }

    if (!Double.isFinite(amount) || amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
  }

  public void withdraw(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.printf("Amount withdrawn: %.2f%n", amount);
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    } else if (amount > balance) {
      System.out.printf("Insufficient balance. Current balance: %.2f%n", balance);
      return;
    } else {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    System.out.printf("Current balance: %.2f%n", balance);
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
