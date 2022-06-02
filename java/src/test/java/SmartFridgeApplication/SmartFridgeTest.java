package SmartFridgeApplication;

import at.nagarro.craftmanship.fridge.Fridge;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.Date;

public class SmartFridgeTest {

    @Test
    public void testFridgeCreationDate(){
        Date creationDate = new Date();
        Fridge fridge = new Fridge(creationDate);
        assertThat(fridge.getCreationDate()).isEqualTo(creationDate);
    }

    @Test
    public void testEmptyFridgeDisplay(){
        Fridge fridge = new Fridge(new Date());

        assertThat(fridge.getFormattedDisplay()).isEqualTo("EXPIRED:\nREMAINING:");
    }

}
