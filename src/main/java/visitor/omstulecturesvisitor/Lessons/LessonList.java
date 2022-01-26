package visitor.omstulecturesvisitor.Lessons;

import java.util.Stack;

public class LessonList {
    private Stack<Lesson> lessons = new Stack<>();

    public LessonList(){}

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public Lesson popLesson(){
        return lessons.pop();
    }

    public Lesson peekLesson(){
        return lessons.peek();
    }

    public int getSize(){
        return lessons.size();
    }
}
