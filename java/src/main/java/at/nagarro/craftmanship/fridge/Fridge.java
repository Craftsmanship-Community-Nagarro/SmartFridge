package at.nagarro.craftmanship.fridge;

import java.time.LocalDateTime;

public class Fridge {
  private final LocalDateTime creationDate;
  private LocalDateTime currentDate;

  public Fridge(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    this.currentDate = creationDate;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public String getFormattedDisplay() {
    return "EXPIRED:\nREMAINING:";
  }

  public void nextDay() {
    this.currentDate = this.currentDate.plusDays(1);
  }

  public LocalDateTime getCurrentDate(){
    return this.currentDate;
  }

}
