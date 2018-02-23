package attendance.application.config;

import ninja.cero.sqltemplate.core.SqlTemplate;
import ninja.cero.sqltemplate.core.mapper.MapperBuilder;
import ninja.cero.sqltemplate.core.parameter.ParamBuilder;
import ninja.cero.sqltemplate.core.template.TemplateEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class AppConfig {

	@Bean
	public SqlTemplate sqlTemplate(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return new SqlTemplate(jdbcTemplate, namedParameterJdbcTemplate, TemplateEngine.FREEMARKER, new ParamBuilder(), new MapperBuilder());
	}

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

}
