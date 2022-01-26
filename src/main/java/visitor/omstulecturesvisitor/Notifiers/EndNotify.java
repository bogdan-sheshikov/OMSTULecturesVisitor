package visitor.omstulecturesvisitor.Notifiers;

import visitor.omstulecturesvisitor.Parsers.JsonParser;
import visitor.omstulecturesvisitor.WebDrivers.WebDriverController;

import java.util.TimerTask;

public class EndNotify extends TimerTask {

    @Override
    public void run() {
        WebDriverController.endSession();
    }
}
