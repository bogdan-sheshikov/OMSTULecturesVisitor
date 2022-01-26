package visitor.omstulecturesvisitor.Notifiers;

import visitor.omstulecturesvisitor.Lessons.Lesson;
import visitor.omstulecturesvisitor.Lessons.LessonList;
import java.util.*;

public class StartEndNotifier extends Thread{
    private static LessonList lessonList;

    @Override
    public void run() {
        while (lessonList.getSize() > 0){
            Lesson currentLesson = lessonList.popLesson();
            String currentLessonStartTime = currentLesson.getStartTime().getValue();
            String currentLessonEndTime = currentLesson.getEndTime().getValue();

            String[] splitBuffer = currentLessonStartTime.split(":");
            String startTimeHour = splitBuffer[0];
            String startTimeMinute = splitBuffer[1];

            splitBuffer = currentLessonEndTime.split(":");
            String endTimeHour = splitBuffer[0];
            String endTimeMinute = splitBuffer[1];

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startTimeHour));
            startCalendar.set(Calendar.MINUTE, Integer.parseInt(startTimeMinute));
            long startTimeInMillis = startCalendar.getTimeInMillis();
            Date startDate = new Date();
            startDate.setTime(startTimeInMillis);

            Timer startTimer = new Timer();

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(endTimeHour));
            endCalendar.set(Calendar.MINUTE, Integer.parseInt(endTimeMinute));

            Date endDate = new Date();
            endDate.setTime(endCalendar.getTimeInMillis());
            startTimer.schedule(new StartNotify(), startDate);
            startTimer.schedule(new EndNotify(), endDate);
        }
    }

    public static void setLessonList(LessonList lessonList){
        StartEndNotifier.lessonList = lessonList;
    }
}
