package com.github.hibernate.tools.ext;

import org.hibernate.tool.internal.export.java.JavaExporter;

public class HbmJavaExporter extends JavaExporter {

	@Override
	protected void init() {
		super.init();
		ExporterInitializer.init(getProperties());
	}
}
