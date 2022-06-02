package at.nagarro.craftmanship.fridge;

import java.time.LocalDateTime;

public class Fridge {
    private final LocalDateTime creationDate;

    public Fridge(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getFormattedDisplay() {
        return "EXPIRED:\nREMAINING:";
    }

    public LocalDateTime getAfterTick() {
        return null;
    }
}
