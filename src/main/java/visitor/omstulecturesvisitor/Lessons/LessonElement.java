package visitor.omstulecturesvisitor.Lessons;

public class LessonElement <T> {
    protected T value;
    public void setValue(T value){
        this.value = value;
    };
    public T getValue(){
        return this.value;
    }
}
