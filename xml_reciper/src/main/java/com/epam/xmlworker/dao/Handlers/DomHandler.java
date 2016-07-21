package com.epam.xmlworker.dao.Handlers;

import com.epam.xmlworker.entity.Action;
import com.epam.xmlworker.entity.Maintenance;
import com.epam.xmlworker.entity.Spare;
import com.epam.xmlworker.entity.additional.CurrencyCode;
import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.SpareType;
import com.epam.xmlworker.entity.additional.Unit;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class DomHandler {

    private Element root;
    private String path;

    public DomHandler(String path){
        this.path = path;
    }

    private void initialize(String path){
        DOMParser parser = new DOMParser();
        try {
            parser.parse(path);
            Document document = parser.getDocument();
            root = document.getDocumentElement();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Maintenance> handle(){
        initialize(path);
        ArrayList<Maintenance> maintenanceList = new ArrayList<>();
        NodeList maintenanceNodes = root.getElementsByTagName("maintenance");
        for (int i=0; i < maintenanceNodes.getLength(); i++){
            Element element = (Element) maintenanceNodes.item(i);
            maintenanceList.add(getMaintance(element));
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
        UUID id = UUID.fromString(element.getAttribute("id"));
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
