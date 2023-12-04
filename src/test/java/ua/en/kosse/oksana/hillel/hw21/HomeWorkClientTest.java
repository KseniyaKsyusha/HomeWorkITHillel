package ua.en.kosse.oksana.hillel.hw21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.en.kosse.oksana.hillel.hw21.client.HomeWorkClient;


public class HomeWorkClientTest {
    @Test
    public void ClientApp_main_throw_exeption() {
        Assertions.assertThrows(Exception.class, () -> {
            HomeWorkClient.main(null);
        });
    }

    @Test
    public void ClientApp_messageReceiver_throw_exeption() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            HomeWorkClient.messageReceiver(null);
        });
    }

    @Test
    public void ClientApp_fileCommandProcessor_fileNotFoundMessage() {
        Assertions.assertEquals(
                1,
                HomeWorkClient.fileCommandProcessor(
                        "file: c:\\path_test", null, null));
    }
}

