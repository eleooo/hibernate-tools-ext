package com.github.hibernate.tools.ext;

import java.lang.reflect.Field;
import java.util.Properties;

import org.hibernate.tool.api.export.ExporterType;

public class ExporterInitializer {

	public static void install() {
		try {
			Field field = ExporterType.DAO.getClass().getDeclaredField("className");
			field.setAccessible(true);
			field.set(ExporterType.DAO, HbmDaoExporter.class.getName());
			
			field = ExporterType.JAVA.getClass().getDeclaredField("className");
			field.setAccessible(true);
			field.set(ExporterType.JAVA, HbmJavaExporter.class.getName());			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void init(Properties properties) {
		properties.putAll(System.getProperties());
		String tmp = System.getProperty("filePattern");
		if(tmp != null && tmp.length() > 0) {
			properties.setProperty(HbmJavaExporter.FILE_PATTERN, tmp);
		}
		tmp = System.getProperty("templateName");
		if(tmp != null && tmp.length() > 0) {
			properties.setProperty(HbmJavaExporter.TEMPLATE_NAME, tmp);
		}
	}
}
