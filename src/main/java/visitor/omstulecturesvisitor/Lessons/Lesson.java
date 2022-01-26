package visitor.omstulecturesvisitor.Lessons;

public class Lesson {
    private NameOfLesson name;
    private LinkOfLesson link;
    private StartTimeOfLesson startTime;
    private EndTimeOfLesson endTime;

    public Lesson(NameOfLesson name, LinkOfLesson link, StartTimeOfLesson startTime, EndTimeOfLesson endTime) {
        this.name = name;
        this.link = link;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public NameOfLesson getName() {
        return name;
    }

    public void setName(NameOfLesson name) {
        this.name = name;
    }

    public LinkOfLesson getLink() {
        return link;
    }

    public void setLink(LinkOfLesson link) {
        this.link = link;
    }

    public StartTimeOfLesson getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTimeOfLesson startTime) {
        this.startTime = startTime;
    }

    public EndTimeOfLesson getEndTime() {
        return endTime;
    }

    public void setEndTime(EndTimeOfLesson endTime) {
        this.endTime = endTime;
    }
}
