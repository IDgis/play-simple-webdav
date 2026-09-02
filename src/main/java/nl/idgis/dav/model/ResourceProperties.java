package nl.idgis.dav.model;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.Map;
import javax.xml.namespace.QName;

public interface ResourceProperties {
	
	static final DateTimeFormatter rfc2822 = DateTimeFormatter
			.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	
	boolean collection();
	
	Optional<Date> lastModified();
	
	Map<QName, String> customProperties();
	
	default Optional<String> lastModifiedAsRFC2822() {
		return lastModified().map(date ->
			rfc2822.format(date.toInstant().atZone(ZoneOffset.UTC)));
	}
}
