package com.epam.xmlworker.dao.Handlers;

import com.epam.xmlworker.entity.Action;
import com.epam.xmlworker.entity.Maintenance;
import com.epam.xmlworker.entity.Spare;
import com.epam.xmlworker.entity.additional.CurrencyCode;
import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.SpareType;
import com.epam.xmlworker.entity.additional.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class StaxHandler {
    private List<Maintenance> maintenanceList = new ArrayList<>();

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public List<Maintenance> handle(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            maintenanceList = process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return maintenanceList;
    }

    private List<Maintenance> process(XMLStreamReader reader) throws XMLStreamException {
        List<Maintenance> maintenanceList = new ArrayList<>();
        List<Action> actionList = null;
        List<Spare> spareList = null;
        Maintenance maintenance = null;
        Action action = null;
        Spare spare = null;
        UUID id = null;
        String elementName = null;
        String currentElement = null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName){
                        case "maintenance":
                            currentElement = elementName;
                            id = UUID.fromString(reader.getAttributeValue(null, "id"));
                            maintenance = new Maintenance(id);
                            break;
                        case "action":
                            currentElement = elementName;
                            id = UUID.fromString(reader.getAttributeValue(null, "id"));
                            action = new Action(id);
                            break;
                        case "spare":
                            currentElement = elementName;
                            id = UUID.fromString(reader.getAttributeValue(null, "id"));
                            spare = new Spare(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    switch (elementName){
                        //strings
                        case "name":
                            switch (currentElement){
                                case "maintenance":
                                    maintenance.setName(text);
                                    break;
                                case "action":
                                    action.setName(text);
                                    break;
                                case "spare":
                                    spare.setName(text);
                                    break;
                            }
                            break;
                        case "manufacturer":
                            spare.setManufacturer(text);
                            break;
                        case "supplier":
                            spare.setSupplier(text);
                            break;
                        //price
                        case "price":
                            Double amount = Double.valueOf(reader.getAttributeValue(null, "amount"));
                            CurrencyCode currencyCode = CurrencyCode.valueOf(reader.getAttributeValue(null, "currency"));
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
                        //Numbers
                        case "man-hours":
                            Double manhours = Double.parseDouble(text);
                            action.setManhours(manhours);
                            break;
                        case "level":
                            Short level = Short.parseShort(text);
                            maintenance.setLevel(level);
                            break;
                        //Enums
                        case "type":
                            SpareType spareType = SpareType.valueOf(text);
                            spare.setType(spareType);
                            break;
                        case "unit":
                            Unit unit = Unit.valueOf(text);
                            maintenance.setUnit(unit);
                            break;
                        //lists
                        case "actions":
                            actionList = new ArrayList<>();
                            break;
                        case "spares":
                            spareList = new ArrayList<>();
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName){
                        case "maintenance":
                            maintenanceList.add(maintenance);
                            break;
                        case "action":
                            actionList.add(action);
                            break;
                        case "spare":
                            spareList.add(spare);
                            break;
                    }
                    break;

            }
        }


        return maintenanceList;
    }

    private Maintenance getMaintance(Element element){
        UUID id = UUID.fromString(element.getAttribute("id"));
        Maintenance maintenance = new Maintenance(id);
        maintenance.setName(getSingleChild(element, "name").getTextContent().trim());
        maintenance.setPrice(getPrice(element));
        maintenance.setLevel(Short.parseShort(getSingleChild(element, "level").getTextContent().trim()));
        maintenance.setUnit(Unit.valueOf(getSingleChild(element, "unit").getTextContent().trim()));
        //
        Element actions = getSingleChild(element, "actions");
        NodeList actionNodes = actions.getElementsByTagName("action");
        ArrayList<Action> actionList = new ArrayList<>();
        for (int j=0; j < actionNodes.getLength(); j++){
            element = (Element) actionNodes.item(j);
            actionList.add(getAction(element));
        }
        //
        maintenance.setActions(actionList);
        return maintenance;
    }

    private Action getAction(Element element){
        UUID id = UUID.fromString(element.getAttribute("id"));
        Action action = new Action(id);
        action.setName(getSingleChild(element, "name").getTextContent().trim());
        action.setPrice(getPrice(element));
        action.setManhours(Double.parseDouble(getSingleChild(element, "man-hours").getTextContent().trim()));
        //
        Element spares = getSingleChild(element, "spares");
        NodeList spareNodes = spares.getElementsByTagName("spare");
        ArrayList<Spare> spareList = new ArrayList<>();
        for (int k=0; k < spareNodes.getLength(); k++){
            element = (Element) spareNodes.item(k);
            spareList.add(getSpare(element));
        }
        //
        action.setSpares(spareList);
        return action;
    }

    private Spare getSpare(Element element){
        UUID id = UUID.fromString(element.getAttribute("storeID"));
        Spare spare = new Spare(id);
        spare.setProductID(UUID.fromString(getSingleChild(element, "productID").getTextContent().trim()));
        spare.setName(getSingleChild(element, "name").getTextContent().trim());
        spare.setPrice(getPrice(element));
        spare.setType(SpareType.valueOf(getSingleChild(element, "type").getTextContent().trim()));
        spare.setManufacturer(getSingleChild(element, "manufacturer").getTextContent().trim());
        spare.setSupplier(getSingleChild(element, "supplier").getTextContent().trim());
        return spare;
    }

    private Price getPrice(Element maintenanceElement) {
        Element priceElement = getSingleChild(maintenanceElement, "price");
        Double amount = Double.valueOf(priceElement.getAttribute("amount"));
        CurrencyCode currencyCode = CurrencyCode.valueOf(priceElement.getAttribute("currency"));
        return new Price(amount, currencyCode);
    }

    private Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }
}
