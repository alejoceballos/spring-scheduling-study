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
        "scheduler.sleeping-beauty:true",
        "scheduler.jar-jar-binks: false",
        "scheduler.prime-calculator: false"
})
class SleepingBeautyTest {

    @MockitoSpyBean
    private SleepingBeauty sleepingBeauty;

    @Test
    void sleepingBeautyWakeUp() {
        await().atMost(TEN_SECONDS).untilAsserted(() -> {
            verify(sleepingBeauty, atLeast(1)).hasBeenKissed();
            out.println(sleepingBeauty.getBigBrother().showReport());
        });
    }

}