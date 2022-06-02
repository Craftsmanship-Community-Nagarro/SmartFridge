package SmartFridgeApplication;

import at.nagarro.craftmanship.fridge.Fridge;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.time.LocalDateTime;

public class SmartFridgeTest {

    @Test
    public void testFridgeCreationDate(){
        LocalDateTime creationDate = LocalDateTime.now();
        Fridge fridge = new Fridge(creationDate);
        assertThat(fridge.getCreationDate()).isEqualTo(creationDate);
    }

    @Test
    public void testEmptyFridgeDisplay(){
        Fridge fridge = new Fridge(LocalDateTime.now());
        assertThat(fridge.getFormattedDisplay()).isEqualTo("EXPIRED:\nREMAINING:");
    }

    @Test
    public void testNextDay(){
        LocalDateTime creationDate = LocalDateTime.now();
        Fridge fridge = new Fridge(creationDate);
        fridge.nextDay();
        assertThat(fridge.getCurrentDate()).isEqualTo(creationDate.plusDays(1));
    }

}
