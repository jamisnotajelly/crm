package adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date>{
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public Date unmarshal(String v) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return SIMPLE_DATE_FORMAT.format(v);
    }
}
