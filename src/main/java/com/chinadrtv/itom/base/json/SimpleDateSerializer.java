package com.chinadrtv.itom.base.json;

import com.chinadrtv.itom.util.DateUtil;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Date;

public class SimpleDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeString(DateUtil.toString(date));
	}

}
