package com.fileuploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileuploaderApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FileuploaderApplication.class);
		//app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}
	

}
