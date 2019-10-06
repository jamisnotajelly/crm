package binders.impl;

import binders.interfaces.ResourceConverter;
import models.PromOrders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

@Stateless
public class XmlOrdersConverter implements ResourceConverter<URL, PromOrders> {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlOrdersConverter.class);

    public PromOrders parse(URL url) throws JAXBException {
        LOGGER.info("URL resource conversion was started {}", url);
        JAXBContext context = JAXBContext.newInstance(PromOrders.class);
        Unmarshaller um = context.createUnmarshaller();
        return (PromOrders) um.unmarshal(url);
    }

}
