import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private final String type;
  private final double amount;
  private final LocalDateTime time_stamp;

  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.time_stamp = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "Transaction [type=" + type + ", amount=" + amount + ", time_stamp=" + time_stamp.format(TIME_FORMAT) + "]";
  }
}
