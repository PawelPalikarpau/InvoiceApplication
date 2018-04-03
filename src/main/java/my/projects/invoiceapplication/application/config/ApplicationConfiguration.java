package my.projects.invoiceapplication.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "my.projects.invoiceapplication.application")
@EnableJpaRepositories(basePackages = "my.projects.invoiceapplication.application.repository")
public class ApplicationConfiguration {

}
