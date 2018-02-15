package attendance.application.config;

import ninja.cero.sqltemplate.core.SqlTemplate;
import ninja.cero.sqltemplate.core.template.TemplateEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class AppConfig {

	@Bean
	public SqlTemplate sqlTemplate(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return new SqlTemplate(jdbcTemplate, namedParameterJdbcTemplate, TemplateEngine.FREEMARKER);
	}

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
}
