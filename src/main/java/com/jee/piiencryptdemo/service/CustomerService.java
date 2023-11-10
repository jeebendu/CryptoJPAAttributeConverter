package com.jee.piiencryptdemo.service;

import com.jee.piiencryptdemo.domain.Customer;
import com.jee.piiencryptdemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByMobile(String mobile) {
        return customerRepository.findByMobile(mobile);
    }

    public Customer findByMobileJQL(String mobile) {
        return customerRepository.findByMobileUsingJQL(mobile);
    }
}
