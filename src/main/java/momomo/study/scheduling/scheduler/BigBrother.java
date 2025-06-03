package momomo.study.scheduling.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class BigBrother {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss SSS");

    public final Map<LocalDateTime, String> spyCam = new HashMap<>();

    public void spy(final String report) {
        spyCam.put(LocalDateTime.now(), report);
    }

    public String showReport() {
        return spyCam
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(this::toTimestampedReport)
                .collect(joining("\n"));
    }

    private String toTimestampedReport(Map.Entry<LocalDateTime, String> entry) {
        return "%s: %s".formatted(entry.getKey().format(FORMATTER), entry.getValue());
    }

}
