package SmartFridgeApplication;

import at.nagarro.craftmanship.fridge.Fridge;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

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

        assertThat(fridge.getAfterTick()).isEqualTo(creationDate.plusDays(1));
    }

}
