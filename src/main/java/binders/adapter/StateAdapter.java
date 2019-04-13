package binders.adapter;

import models.enums.State;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StateAdapter extends XmlAdapter<String, State> {
    @Override
    public String marshal(State v) throws Exception {
        return v.name().toLowerCase();
    }

    @Override
    public State unmarshal(String v) throws Exception {
        return State.fromValue(v);
    }
}
