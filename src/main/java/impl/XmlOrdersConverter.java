package impl;

import interfaces.ResourceConverter;
import model.Orders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class XmlOrdersConverter implements ResourceConverter<URL, Orders> {

    Orders parse(String path) throws JAXBException, IOException {
        try (FileInputStream adrFile = new FileInputStream(path)) {
            JAXBContext context = JAXBContext.newInstance(Orders.class);
            Unmarshaller um = context.createUnmarshaller();
            return (Orders) um.unmarshal(adrFile);
        }
    }

    public Orders parse(URL url) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Orders.class);
        Unmarshaller um = context.createUnmarshaller();
        return (Orders) um.unmarshal(url);
    }

}
