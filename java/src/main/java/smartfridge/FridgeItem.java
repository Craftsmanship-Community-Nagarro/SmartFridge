// Copyright (c) 2008-2022  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package smartfridge;


import java.time.*;
import java.time.temporal.*;

public class FridgeItem {
    private final String itemName;
    private LocalDateTime expireDate;
    private Condition condition;

    public FridgeItem(String itemName, String expireDate, Condition condition) {
        this.itemName = itemName;
        this.expireDate = DateFormatter.getLocalDateTimeFromString(expireDate);
        validateNewCondition(condition);
        this.condition = condition;
    }

    private void validateNewCondition(Condition condition) {
        if (condition == Condition.EXPIRED){
            throw new RuntimeException("You cannot put already expired Items in your fridge!");
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Condition getCondition() {
        return condition;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void reduceExpirationDate() {
        if (condition == Condition.OPENED){
            expireDate = expireDate.minusHours(5);
        }
        else if (condition == Condition.SEALED){
            expireDate = expireDate.minusHours(1);
        }
    }

    public void validateCondition(LocalDateTime currentDate){
        if (currentDate.isAfter(expireDate)){
            condition = Condition.EXPIRED;
        }
    }

    public long getDaysRemaining(LocalDateTime currentDate) {
        return ChronoUnit.DAYS.between(currentDate, expireDate);
    }
}
