package app.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Exception.class);

    @Override
    public Response toResponse(Exception exception) {
        LOGGER.error("Exception occurred {}", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
