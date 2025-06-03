package momomo.study.scheduling.scheduler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * A simple example of a stateful scheduler
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "scheduler.jar-jar-binks", havingValue = "true")
public class JarJarBinks {

    @Getter
    private final BigBrother bigBrother = new BigBrother();

    private int steadyCount = 2;
    private int executionNumber = 1;

    public JarJarBinks() {
        log.info("No, no, mesa stay. Mesa culled Jar Jar Binks. Mesa your humble servant.");
    }

    @Scheduled(initialDelay = 2, fixedDelay = 2, timeUnit = SECONDS)
    public void communicateWithTroops() {
        if (steadyCount-- > 0) {
            final var message = "(%d) Steady...".formatted(executionNumber);
            bigBrother.spy(message);
            log.info(message);
            return;
        }

        final var message = "(%d) Ah. Whoa!".formatted(executionNumber);
        bigBrother.spy(message);
        log.info(message);

        steadyCount = 2;
        executionNumber++;
    }

}
