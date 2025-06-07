package Spring_Demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {
	@Bean
	public DriverManagerDataSource MyDataSource() {

		DriverManagerDataSource DMS = new DriverManagerDataSource();

		DMS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		DMS.setUrl("jdbc:mysql://localhost:3306/Spring_DB");
		DMS.setUsername("root");
		DMS.setPassword("Example@2024");

		return DMS;
	}

	@Bean
	public JdbcTemplate MyjdbcTemplate() {

		JdbcTemplate JT = new JdbcTemplate(MyDataSource());

		return JT;

	}

}
