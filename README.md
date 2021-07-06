
# Hibernate tools扩展

使用示例:
```xml

<build>
	<plugins>
		<plugin>
			<groupId>org.hibernate.tool</groupId>
			<artifactId>hibernate-tools-maven</artifactId>
			<version>6.0.0.Alpha2</version>
			<dependencies>
				<dependency>
					<groupId>com.github.hibernates</groupId>
					<artifactId>hibernates-tools-ext</artifactId>
					<version>0.0.1</version>
				</dependency>
				<dependency>
					<groupId>org.hibernate.tool</groupId>
					<artifactId>hibernate-tools-orm</artifactId>
					<version>6.0.0.Alpha2</version>
				</dependency>
				<dependency>
					<groupId>com.h2database</groupId>
					<artifactId>h2</artifactId>
					<version>${h2.version}</version>
				</dependency>
			</dependencies>
			<executions>
				<execution>
					<id>generate-entities</id>
					<phase>generate-sources</phase>
					<goals>
						<goal>hbm2java</goal>
					</goals>
					<configuration>
						<packageName>com.github.eleooo.entity</packageName>
						<ejb3>true</ejb3>
					</configuration>
				</execution>
				<execution>
					<id>generate-dao</id>
					<phase>generate-sources</phase>
					<goals>
						<goal>hbm2dao</goal>
					</goals>
					<configuration>
						<packageName>com.github.eleooo.repository</packageName>
						<ejb3>false</ejb3>
						<jdk5>true</jdk5>
					</configuration>
				</execution>
			</executions>
			<configuration>
				<outputDirectory>src/main/java</outputDirectory>
				<propertyFile>src/test/resources/hbm2java.properties
				</propertyFile>
			</configuration>
		</plugin>
	</plugins>
</build>

```