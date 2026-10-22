package BankAccount2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//For transaction history, time and date.
public class Transaction {

  private static final DateTimeFormatter TIMESTAMP_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  String type;
  double amount;
  LocalDateTime time_stamp;

  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.time_stamp = LocalDateTime.now();
  }

  public String getFormattedTimestamp() {
    return time_stamp.format(TIMESTAMP_FORMAT);
  }
}
