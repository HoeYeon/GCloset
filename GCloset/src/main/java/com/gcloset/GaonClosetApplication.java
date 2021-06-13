package com.gcloset;

import com.gcloset.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class GaonClosetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaonClosetApplication.class, args);
	}

}
