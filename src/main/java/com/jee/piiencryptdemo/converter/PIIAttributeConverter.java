package com.jee.piiencryptdemo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.jee.piiencryptdemo.aes.AesUtil;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.log4j.Log4j2;

@Component
@Converter
@Log4j2
public class PIIAttributeConverter implements AttributeConverter<String,String> {
    
    @Autowired
    private AesUtil aesUtilBean;
    private static AesUtil aesUtil;

    @Autowired
    private Environment environmentBean;
    private static Environment environment;

    // As the AttributeConverter is called by the JPA per field, direct autowire does not work
    // We need to use the static field and set
    // Reference: https://stackoverflow.com/a/36856434
    

    @PostConstruct
    public void init() {
    	aesUtil=this.aesUtilBean;
        environment = this.environmentBean;
    }
    
	@Override
	public String convertToDatabaseColumn(String attribute) {
		return aesUtil.encrypt(attribute);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return aesUtil.decrypt(dbData);
	}
    
}
