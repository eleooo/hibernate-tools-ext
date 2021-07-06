package com.github.hibernate.tools.ext;

import org.hibernate.tool.api.reveng.TableIdentifier;
import org.hibernate.tool.internal.reveng.strategy.DefaultStrategy;
import org.hibernate.tool.internal.util.StringUtil;
import org.jboss.logging.Logger;

public class HbmStrategy extends DefaultStrategy {
	protected Logger log = Logger.getLogger(this.getClass());
	private String[] excludeTables;
	private String[] includeTables;
	
	static {
		ExporterInitializer.install();
	}
	
	@Override
	public boolean excludeTable(TableIdentifier ti) {
		if (ti == null || ti.getName() == null)
			return true;
		this.initExcludesions();
		String name = ti.getName().toLowerCase();
		if (SimpleMatcher.simpleMatch(excludeTables, name)) {
			return true;
		} else if (includeTables != null && includeTables.length > 0) {
			if(SimpleMatcher.simpleMatch(includeTables, name)) {
				return false;
			}
			return true;
		}
		return super.excludeTable(ti);
	}

	private void initExcludesions() {
		if (this.excludeTables == null) {
			String exclude = System.getProperty("exclude");
			if (exclude != null) {
				log.info("initExcludesions:" + exclude);
			}
			this.excludeTables = this.parseToList(exclude);

		}
		if (this.includeTables == null) {
			String include = System.getProperty("include");
			if (include != null) {
				log.info("initIncludesions:" + include);
			}
			this.includeTables = this.parseToList(include);
		}
	}

	private String[] parseToList(String str) {
		if (str == null || str.length() == 0) {
			return new String[0];
		}
		str = str.trim().toLowerCase();
		return StringUtil.split(str, ",");
	}
}
