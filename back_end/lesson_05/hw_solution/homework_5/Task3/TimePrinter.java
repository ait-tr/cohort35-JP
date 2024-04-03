package homework.homework_5.Task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimePrinter {
    private TimeService timeService;

    @Autowired
    public TimePrinter(TimeService timeService) {
        this.timeService = timeService;
    }

    public void printCurrentTime() {
        System.out.println("Current time: " + timeService.getCurrentTime());
    }
}
