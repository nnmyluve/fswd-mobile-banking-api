package kh.edu.fswdmobilebankingapi.service;

import kh.edu.fswdmobilebankingapi.dto.CreateCustomerRequest;
import kh.edu.fswdmobilebankingapi.dto.CustomerResponse;
import kh.edu.fswdmobilebankingapi.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    CustomerResponse updateByPhoneNumber(
            String phoneNumber,
            UpdateCustomerRequest createCustomerRequest);

    CustomerResponse findByPhoneNumber(String phoneNumber);

    List<CustomerResponse> findAll();

    CustomerResponse createNew(CreateCustomerRequest createCustomerRequest);

    List<CustomerResponse> getAll();
}
