package com.innominds.response.vo.inner;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("canHasGui")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class CanHasGui {

	@XStreamAlias("href")
	String href;

	String value;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValue();
	}

}
