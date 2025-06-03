package momomo.study.scheduling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "scheduler.sleeping-beauty:false",
        "scheduler.jar-jar-binks: false",
        "scheduler.prime-calculator: false"
})
class SpringSchedulingStudyApplicationTests {

    @Test
    void contextLoads() {
        // Just to check context loader
    }

}
