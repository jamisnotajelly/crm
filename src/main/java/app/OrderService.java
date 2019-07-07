package app;

import app.model.CreateOrdersRequest;
import binders.impl.XmlOrdersConverter;
import db.PromOrderService;
import models.PromOrders;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.ejb.LockType.READ;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Lock(READ)
@Singleton
@Path("/orders")
public class OrderService {

    @EJB
    XmlOrdersConverter xmlOrdersConverter;

    @EJB
    PromOrderService promOrderService;

    @GET
    @Produces(APPLICATION_JSON)
    public Response getOrders() {
        return Response.ok(promOrderService.findAll()).build();
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response parseOrders(CreateOrdersRequest createOrdersRequest) throws MalformedURLException, JAXBException {
        URL url = new URL(createOrdersRequest.getUrl());
        PromOrders promOrders = xmlOrdersConverter.parse(url);
        promOrders.getPromOrders().forEach(promOrderService::persist);
        return Response.status(Response.Status.CREATED).build();
    }

}
