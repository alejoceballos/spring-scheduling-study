package momomo.study.scheduling.scheduler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * This must be a typical example of a non-crashable scheduling. One execution must wait until the other finishes.
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "scheduler.prime-calculator", havingValue = "true")
public class PrimeCalculator {

    private static final int START = 1;
    private static final int END = 25;

    @Getter
    private final BigBrother bigBrother = new BigBrother();

    private int executionNumber = 1;

    public PrimeCalculator() {
        log.info("Start thinking");
    }

    @Scheduled(initialDelay = 1, fixedDelay = 5, timeUnit = SECONDS)
    public void imLate() {
        IntStream
                .range(START, END)
                .forEach(intNumber -> {
                    final var value = new BigInteger(2048, new Random()).nextProbablePrime();
                    final var message = "(%d) %d - %d".formatted(executionNumber, intNumber, value);
                    bigBrother.spy(message);
                    log.info(message);
                });

        final var message = "(%d) %d - Finished".formatted(executionNumber, END);
        bigBrother.spy(message);
        log.info(message);

        executionNumber++;
    }

}
