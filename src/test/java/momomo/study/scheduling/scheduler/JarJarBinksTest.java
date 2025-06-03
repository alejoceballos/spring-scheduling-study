package momomo.study.scheduling.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static java.lang.System.out;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.TEN_SECONDS;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties = {
        "scheduler.sleeping-beauty:false",
        "scheduler.jar-jar-binks: true",
        "scheduler.prime-calculator: false"
})
class JarJarBinksTest {

    @MockitoSpyBean
    private JarJarBinks jarJarBinks;

    @Test
    void jarJarBinkCommand() {
        await().atMost(TEN_SECONDS).untilAsserted(() -> {
            verify(jarJarBinks, atLeast(3)).communicateWithTroops();
            out.println(jarJarBinks.getBigBrother().showReport());
        });
    }

}