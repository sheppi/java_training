package com.epam.xmlworker.dao.Handlers;

import com.epam.xmlworker.entity.Action;
import com.epam.xmlworker.entity.Maintenance;
import com.epam.xmlworker.entity.Spare;
import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.SpareType;
import com.epam.xmlworker.entity.additional.Unit;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class SaxHandler extends DefaultHandler {

}
