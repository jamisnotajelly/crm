package binders.impl;

import binders.interfaces.ResourceConverter;
import models.PromOrders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class XmlOrdersConverter implements ResourceConverter<URL, PromOrders> {

    public PromOrders parse(URL url) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PromOrders.class);
        Unmarshaller um = context.createUnmarshaller();
        return (PromOrders) um.unmarshal(url);
    }

}
