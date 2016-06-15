package nl.idgis.dav.model;

import java.util.Date;
import java.util.Optional;
import java.util.Map;
import java.util.Collections;
import javax.xml.namespace.QName;

public class DefaultResourceProperties implements ResourceProperties {
	
	private final boolean collection;
	
	private final Date lastModified;
	
	private final Map<QName, String> customProperties;
	
	public DefaultResourceProperties(boolean collection) {
		this(collection, null, null);
	}
	
	public DefaultResourceProperties(boolean collection, Map<QName, String> customProperties) {
		this(collection, null, customProperties);		
	}
	
	public DefaultResourceProperties(boolean collection, Date lastModified) {
		this(collection, lastModified, null);
	}
	
	public DefaultResourceProperties(boolean collection, Date lastModified, Map<QName, String> customProperties) {
		this.collection = collection;
		this.lastModified = lastModified;
		this.customProperties = customProperties;
	}

	@Override
	public boolean collection() {
		return collection;
	}
	
	@Override
	public Optional<Date> lastModified() {
		return Optional.ofNullable(lastModified);
	}
	
	@Override
	public Map<QName, String> customProperties() {
		if(customProperties == null) {
			return Collections.emptyMap();
		} else {
			return customProperties;
		}
	}
}