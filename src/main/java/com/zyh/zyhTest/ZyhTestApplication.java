package com.zyh.zyhTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class ZyhTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZyhTestApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ZyhTestApplication.class);
	}





	/*
	//添加Listener
	@Bean
	public ServletListenerRegistrationBean signValidationListener(){
		ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new EventListener() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		return bean;
	}*/

	/*
	//添加servlet
	@Bean
	public ServletRegistrationBean signValidateServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new IndexServlet());
		registration.addUrlMappings("/");
		return registration;
	}
	*/







}
