package com.epam.xmlworker.dao;

import com.epam.xmlworker.dao.Handlers.DomHandler;
import com.epam.xmlworker.dao.Handlers.SaxHandler;
import com.epam.xmlworker.dao.Handlers.StaxHandler;
import com.epam.xmlworker.entity.Maintenance;

import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill_Kaluga on 7/18/2016.
 */
public class XMLworker {
    private final static XMLworker instance = new XMLworker();
    private String path;

    private XMLworker(){
        path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Maintenances.xml";
    }

    public static XMLworker getInstance() {
        return instance;
    }

    public boolean work(){
        try (InputStream input = new FileInputStream(path)){
            List<Maintenance> listFromSAX = SAXworker(input);
            List<Maintenance> listFromStAX =StAXworker(input);
            List<Maintenance> listFromDOM = DOMworker(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Maintenance> SAXworker(InputStream input) {
        SaxHandler handler = new SaxHandler();
//        try {
//
//            return handler.handle(input);
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public List<Maintenance> StAXworker(InputStream input) {
        StaxHandler handler = new StaxHandler();
        try {
            return handler.handle(input);
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Maintenance> DOMworker(String path) {
        DomHandler handler = new DomHandler(path);
        return handler.handle();
    }
}
