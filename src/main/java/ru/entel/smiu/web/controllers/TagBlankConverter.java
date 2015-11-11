package ru.entel.smiu.web.controllers;

import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.db.entity.TagBlank;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("tagBlankConverter")
public class TagBlankConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                LogsController logsController = (LogsController) fc.getExternalContext().getApplicationMap().get("logsController");
                return logsController.getTagBlanks().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            return String.valueOf(((TagBlank) o).getSelectedId());
        }
        else {
            return null;
        }
    }
}
