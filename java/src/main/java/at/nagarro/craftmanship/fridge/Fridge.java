package at.nagarro.craftmanship.fridge;

import java.util.Date;

public class Fridge {
  private final Date creationDate;

  public Fridge(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getCreationDate() {
    return creationDate;
  }
}
