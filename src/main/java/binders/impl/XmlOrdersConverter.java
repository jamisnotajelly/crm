package binders.impl;

import models.PromOrders;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

@Stateless
public class XmlOrdersConverter {

    public PromOrders parse(URL url) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PromOrders.class);
        Unmarshaller um = context.createUnmarshaller();
        return (PromOrders) um.unmarshal(url);
    }


    public void create(PromOrders promOrders) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(PromOrders.class);
        Marshaller marshaller = context.createMarshaller();
        OutputStream outputStream = new FileOutputStream("someth.xml");
        marshaller.marshal(promOrders, outputStream);
        outputStream.close();
    }

}
