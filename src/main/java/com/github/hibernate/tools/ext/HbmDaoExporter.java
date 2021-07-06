package com.github.hibernate.tools.ext;

import org.hibernate.tool.internal.export.dao.DaoExporter;

public class HbmDaoExporter extends DaoExporter {

	@Override
	protected void init() {
		super.init();
		getProperties().put(FILE_PATTERN, "{package-name}/{class-name}Repository.java");
		ExporterInitializer.init(getProperties());
	}

	
}
