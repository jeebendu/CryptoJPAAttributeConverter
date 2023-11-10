package com.jee.piiencryptdemo.domain;

import java.io.Serializable;

import com.jee.piiencryptdemo.converter.PIIAttributeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PIIAttributeConverter.class)
    private String mobile;

    @Convert(converter = PIIAttributeConverter.class)
    private String name;
}
