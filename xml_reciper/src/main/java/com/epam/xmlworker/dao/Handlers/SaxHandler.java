package com.epam.xmlworker.dao.Handlers;

import com.epam.xmlworker.entity.Action;
import com.epam.xmlworker.entity.Maintenance;
import com.epam.xmlworker.entity.Spare;
import com.epam.xmlworker.entity.additional.CurrencyCode;
import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.SpareType;
import com.epam.xmlworker.entity.additional.Unit;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class SaxHandler extends DefaultHandler {
    private List<Maintenance> maintenanceList = new ArrayList<>();
    private String currentElement;
    private Maintenance maintenance;
    private Action action;
    private Spare spare;
    private StringBuilder text;

    private List<Action> actionList;
    private List<Spare> spareList;

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void startElement(String uri, String localName, String  qName, Attributes attributes)
            throws SAXException {
        UUID id;
        System.out.println("startElement -> " + uri + localName + qName);
        switch (qName){
            case "maintenance":
                currentElement = qName;
                id = UUID.fromString(attributes.getValue("id"));
                maintenance = new Maintenance(id);
                break;
            case "action":
                currentElement = qName;
                id = UUID.fromString(attributes.getValue("id"));
                action = new Action(id);
                break;
            case "spare":
                currentElement = qName;
                id = UUID.fromString(attributes.getValue("id"));
                spare = new Spare(id);
                break;

            //price
            case "price":
                Double amount = Double.valueOf(attributes.getValue("amount"));
                CurrencyCode currencyCode = CurrencyCode.valueOf(attributes.getValue("currency"));
                Price price = new Price(amount, currencyCode);
                switch (currentElement){
                    case "maintenance":
                        maintenance.setPrice(price);
                        break;
                    case "action":
                        action.setPrice(price);
                        break;
                    case "spare":
                        spare.setPrice(price);
                        break;
                }
                break;
            //lists
            case "actions":
                actionList = new ArrayList<>();
                break;
            case "spares":
                spareList = new ArrayList<>();
                break;
        }
    }

    public void characters( char [] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        switch (qName){
            case "maintenance":
                maintenanceList.add(maintenance);
                break;
            case "action":
                currentElement = "maintenance";
                actionList.add(action);
                break;
            case "spare":
                currentElement = "action";
                spareList.add(spare);
                break;
            //strings
            case "name":
                switch (currentElement){
                    case "maintenance":
                        maintenance.setName(text.toString());
                        break;
                    case "action":
                        action.setName(text.toString());
                        break;
                    case "spare":
                        spare.setName(text.toString());
                        break;
                }
                break;
            case "manufacturer":
                spare.setManufacturer(text.toString());
                break;
            case "supplier":
                spare.setSupplier(text.toString());
                break;
            //Numbers
            case "man-hours":
                Double manhours = Double.parseDouble(text.toString());
                action.setManhours(manhours);
                break;
            case "level":
                Short level = Short.parseShort(text.toString());
                maintenance.setLevel(level);
                break;
            //Enums
            case "type":
                SpareType spareType = SpareType.valueOf(text.toString());
                spare.setType(spareType);
                break;
            case "unit":
                Unit unit = Unit.valueOf(text.toString());
                maintenance.setUnit(unit);
                break;

            //lists
            case "actions":
                maintenance.setActions(actionList);
                break;
            case "spares":
                action.setSpares(spareList);
                break;
        }
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
        throw (exception);
    }
}
