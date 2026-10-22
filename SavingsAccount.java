public class SavingsAccount extends BankAccount {
  private final String ownerName;

  public SavingsAccount(String ownerName) {
    super(ownerName);
    this.ownerName = ownerName;
    System.out.println("Account Owner: " + ownerName + ".");
  }
  
  public String getOwnerName() {
    return ownerName;
  }
}
