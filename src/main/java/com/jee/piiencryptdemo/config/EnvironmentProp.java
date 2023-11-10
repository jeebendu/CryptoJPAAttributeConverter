package com.jee.piiencryptdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class EnvironmentProp {
	
	@Value("${aes.key}")
	String aesKey;

}
