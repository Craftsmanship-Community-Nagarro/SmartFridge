// Copyright (c) 2008-2022  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package smartfridge;

import org.junit.*;

import java.time.*;

public class FridgeTest {

    public static final String MILK = "Milk";

    @Test
    public void testCurrentDate() {
        Fridge fridge = new Fridge("13/01/2022");
        Assert.assertEquals(fridge.getCurrentDate(), LocalDate.of(2022, 1, 13).atStartOfDay());
    }

    @Test
    public void testScanItem() {
        Fridge fridge = new Fridge("13/01/2022");

        fridge.scanNewItem(MILK, "16/01/2022", Condition.OPENED);
        fridge.scanNewItem("Butter", "16/01/2023", Condition.OPENED);
        fridge.scanNewItem("Meat", "17/01/2022", Condition.OPENED);

        FridgeItem milk = fridge.getItem(MILK);
        Assert.assertNotNull(milk);
    }

    @Test
    public void testRemoveItem() {
        Fridge fridge = new Fridge("13/01/2022");

        fridge.scanNewItem(MILK, "16/01/2022", Condition.OPENED);
        fridge.scanNewItem("Butter", "16/01/2023", Condition.OPENED);
        fridge.scanNewItem("Meat", "17/01/2022", Condition.OPENED);

        fridge.removeItem(MILK);

        FridgeItem milk = fridge.getItem(MILK);
        Assert.assertNull(milk);
    }

    @Test
    public void testOpenDoor() {
        Fridge fridge = new Fridge("13/01/2022");
        fridge.scanNewItem(MILK, "14/01/2022", Condition.OPENED);
        fridge.scanNewItem("Butter", "16/01/2022", Condition.SEALED);

        fridge.openDoor();
        Assert.assertEquals(fridge.getItem(MILK).getExpireDate(),
                (LocalDateTime.of(2022, 1, 13, 19,0)));

        fridge.openDoor();
        fridge.openDoor();
        fridge.openDoor();
        fridge.openDoor();

        Assert.assertEquals(fridge.getItem(MILK).getCondition(), Condition.EXPIRED);
        Assert.assertEquals(fridge.getItem("Butter").getCondition(), Condition.SEALED);
    }

    @Test
    public void testDaysPasses() {
        Fridge fridge = new Fridge("12/01/2022");
        fridge.scanNewItem(MILK, "14/01/2022", Condition.OPENED);
        fridge.scanNewItem("Butter", "16/01/2022", Condition.SEALED);

        fridge.simulateDayOver();
        fridge.simulateDayOver();
        fridge.simulateDayOver();
        fridge.simulateDayOver();

        Assert.assertEquals(fridge.getItem(MILK).getExpireDate(),
                (LocalDateTime.of(2022, 1, 14, 0,0)));
        Assert.assertEquals(fridge.getItem(MILK).getCondition(), Condition.EXPIRED);
        Assert.assertEquals(fridge.getItem("Butter").getCondition(), Condition.SEALED);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidItemCondition(){
        Fridge fridge = new Fridge("12/01/2022");
        fridge.scanNewItem(MILK, "11/01/2022", Condition.EXPIRED);
    }

    @Test
    public void testDisplayOutput(){
        Fridge fridge = new Fridge("12/01/2022");
        fridge.scanNewItem(MILK, "14/01/2022", Condition.OPENED);
        fridge.scanNewItem("Butter", "16/01/2022", Condition.SEALED);

        String output = fridge.showDisplay();
        String expectedOutput ="Today is the: 2022-01-12T00:00\n" +
                "Milk: 2 days remaining\n" +
                "Butter: 4 days remaining\n";
        Assert.assertEquals(output, expectedOutput);
    }
}
