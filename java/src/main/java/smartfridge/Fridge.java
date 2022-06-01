// Copyright (c) 2008-2022  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package smartfridge;


import java.time.LocalDateTime;
import java.util.*;

public class Fridge {
    private LocalDateTime currentDate;
    private List<FridgeItem> itemList;

    public Fridge(String currentDate) {
        this.currentDate = DateFormatter.getLocalDateTimeFromString(currentDate);
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public void scanNewItem(String itemName, String expireDate, Condition condition) {
        getItemList().add(new FridgeItem(itemName, expireDate, condition));
    }

    private List<FridgeItem> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }

    public void openDoor() {
        itemList.forEach(FridgeItem::reduceExpirationDate);
        validateAllItemConditions();
    }

    public FridgeItem getItem(String itemName) {
        Optional<FridgeItem> item =
                itemList.
                        stream()
                        .filter(e -> e.getItemName().equals(itemName))
                        .findFirst();
        return item.orElse(null);
    }

    public void simulateDayOver() {
        currentDate = currentDate.plusDays(1);
        validateAllItemConditions();
    }

    private void validateAllItemConditions(){
        itemList.forEach(e -> e.validateCondition(currentDate));
    }

    public void removeItem(String itemName) {
        FridgeItem item = getItem(itemName);
        if (item == null){
            throw new RuntimeException("Kein Item mit dem Namen: " + itemName + " gefunden! Item kann nicht entfernt werden!");
        }
        itemList.remove(getItem(itemName));
    }


    public String showDisplay() {
        StringBuilder stb = new StringBuilder();
        stb.append("Today is the: ").append(currentDate).append("\n");

        printExpired(stb);
        printDaysRemaining(stb);

        return stb.toString();
    }

    private void printDaysRemaining(StringBuilder stb) {
        itemList.forEach(item -> {
            if (item.getCondition() != Condition.EXPIRED){
                stb.append(item.getItemName()).append(": ").append(item.getDaysRemaining(currentDate)).append(" days remaining\n");
            }
        });
    }

    private void printExpired(StringBuilder stb) {
        itemList.forEach(item -> {
            if (item.getCondition() == Condition.EXPIRED){
                stb.append("EXPIRED: ").append(item.getItemName()).append(" on ").append(item.getExpireDate()).append("\n");
            }
        });
    }
}
