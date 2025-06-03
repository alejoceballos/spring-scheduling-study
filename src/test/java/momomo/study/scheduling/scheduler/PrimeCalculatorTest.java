package momomo.study.scheduling.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static java.lang.System.out;
import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties = {
        "scheduler.sleeping-beauty:false",
        "scheduler.jar-jar-binks: false",
        "scheduler.prime-calculator: true"
})
class PrimeCalculatorTest {

    @MockitoSpyBean
    private PrimeCalculator primeCalculator;

    @Test
    void primeCalculator() {
        await().atMost(ofSeconds(20L)).untilAsserted(() -> {
            verify(primeCalculator, atLeast(2)).imLate();
            out.println(primeCalculator.getBigBrother().showReport());
        });
    }

}