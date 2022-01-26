package visitor.omstulecturesvisitor.Parsers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import visitor.omstulecturesvisitor.Lessons.*;

import java.util.HashMap;

public class JsonParser {
    private static LessonList lessonList;

    private static NameOfLesson name;
    private static StartTimeOfLesson startTime;
    private static EndTimeOfLesson endTime;
    private static LinkOfLesson link;
    private static JsonElement sourceData;

    private static HashMap<String, String> nameAndLinks;
    private static NameAndLinksParser nameAndLinksParser;
    private static GetScheduleFromSite getSchedule;

    public JsonParser(String group){
        getSchedule = new GetScheduleFromSite(group);
    }

    private static void initData(){
        sourceData = getSchedule.getResponse();
        if(sourceData == null){
            System.err.println("Response from site is null");
            System.exit(-1);
        }
        nameAndLinks = nameAndLinksParser.getListOfLinks();
    }

    private static void parseSchedule(){
        JsonArray jsonArrayData = sourceData.getAsJsonArray();
        for(JsonElement jsonElement: jsonArrayData){
            String disciplineName = jsonElement.getAsJsonObject().get("discipline").getAsString();
            String beginLesson = jsonElement.getAsJsonObject().get("beginLesson").getAsString();
            String endLesson = jsonElement.getAsJsonObject().get("endLesson").getAsString();

            if(nameAndLinks.containsKey(disciplineName)) {
                name.setValue(disciplineName);
                startTime.setValue(beginLesson);
                endTime.setValue(endLesson);
                link.setValue(nameAndLinks.get(disciplineName));

                lessonList.addLesson(new Lesson(name, link, startTime, endTime));
            }

        }
    }

    public static LessonList getParsedLessonList(){
        initData();
        parseSchedule();
        return lessonList;
    }
}
