package ru.entel.smiu.web.engine;

import ru.entel.smiu.web.settings.Configurator;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="startup", loadOnStartup=2)
public class Engine extends HttpServlet {

    private Configurator configurator;

    public Engine() {
    }

}
