package momomo.study.scheduling.scheduler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * A simple example of scheduling
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "scheduler.sleeping-beauty", havingValue = "true")
public class SleepingBeauty {

    private int executionNumber = 1;

    @Getter
    private final BigBrother bigBrother = new BigBrother();

    public SleepingBeauty() {
        final var message =
                ("(%d) I've just been dissuaded to prick my finger on a spindle of a spinning wheel. " +
                        "I'm young and dumb. I'm going to sleep").formatted(executionNumber);
        bigBrother.spy(message);
        log.info(message);
    }

    @Scheduled(initialDelay = 2, fixedDelay = 5, timeUnit = SECONDS)
    public void hasBeenKissed() {
        final var message =
                ("(%d) I've just been kissed by a stranger hired by my parents. " +
                        "Let's get up and get the hell outta here! I'll sue everybody later").formatted(executionNumber);

        bigBrother.spy(message);
        log.info(message);

        executionNumber++;
    }

}
