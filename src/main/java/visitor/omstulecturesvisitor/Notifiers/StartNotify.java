package visitor.omstulecturesvisitor.Notifiers;

import visitor.omstulecturesvisitor.WebDrivers.WebDriverController;

import java.util.TimerTask;

public class StartNotify extends TimerTask {
    @Override
    public void run() {
        WebDriverController.startSession();
    }
}
