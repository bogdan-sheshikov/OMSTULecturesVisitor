package visitor.omstulecturesvisitor;

import org.openqa.selenium.json.Json;
import visitor.omstulecturesvisitor.Lessons.LessonList;
import visitor.omstulecturesvisitor.Notifiers.StartEndNotifier;
import visitor.omstulecturesvisitor.Parsers.JsonParser;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AllWorkCycle {

    public static void updateLessonList(){
        LessonList lessonList = JsonParser.getParsedLessonList();
    }
    public static void startCycle(){
        updateLessonList();
        StartEndNotifier.setLessonList(JsonParser.getParsedLessonList());
        StartEndNotifier startEndNotifier = new StartEndNotifier();
        startEndNotifier.start();

        Timer timer = new Timer();
        Date renewDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 0);
        renewDate.setTime(calendar.getTimeInMillis());
        timer.schedule(new UpdateParser(), renewDate, 1000*60*60*24);

    }
}

class UpdateParser extends TimerTask {
    @Override
    public void run() {
        AllWorkCycle.updateLessonList();
    }
}