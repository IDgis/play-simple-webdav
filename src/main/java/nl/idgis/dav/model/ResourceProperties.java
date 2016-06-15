package nl.idgis.dav.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.Map;
import javax.xml.namespace.QName;

public interface ResourceProperties {
	
	static DateFormat rfc2822 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

	boolean collection();
	
	Optional<Date> lastModified();
	
	Map<QName, String> customProperties();
	
	default Optional<String> lastModifiedAsRFC2822() {
		return lastModified().map(rfc2822::format);
	}
}