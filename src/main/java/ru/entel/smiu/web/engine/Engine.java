package ru.entel.smiu.web.engine;

import ru.entel.smiu.web.settings.Configurator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="startup", loadOnStartup=2)
public class Engine extends HttpServlet {
    private Configurator configurator;

    public Engine() {
        configurator = new Configurator();
        configurator.configure();
    }


}
