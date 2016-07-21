package com.epam.xmlworker.dao.Handlers;

import com.epam.xmlworker.entity.Action;
import com.epam.xmlworker.entity.Maintenance;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class SaxHandler extends DefaultHandler {
    private List<Maintenance> maintenanceList = new ArrayList<>();
    private Maintenance maintenance;
    private StringBuilder text;

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }
}
