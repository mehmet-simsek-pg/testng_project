import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogExample {

    private static final Logger LOGGER = LogManager.getLogger(LogExample.class);

    @Test
    public void login() {
        LOGGER.info("Tarayici baslatildi");
        LOGGER.debug("Login sayfasi acildi");
        LOGGER.info("Email ve password bilgileri girildi");
        LOGGER.warn("Password alani bos birakilamaz");
        LOGGER.error("Login basarisiz oldu");
        Assert.fail("Test basarisiz oldu");
    }
}
