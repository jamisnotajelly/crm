package binders.adapter;

import models.enums.State;
import org.junit.Assert;
import org.junit.Test;

public class StateAdapterTest {
    StateAdapter stateAdapter = new StateAdapter();

    @Test
    public void marshal() throws Exception {
        Assert.assertEquals("Marshalled object is not equals to the expected", "accepted", stateAdapter.marshal(State.ACCEPTED));
    }

    @Test
    public void unmarshal() throws Exception {
        Assert.assertEquals("Unmarshalled object is not equals to the expected", State.ACCEPTED, stateAdapter.unmarshal("accepted"));

    }

}