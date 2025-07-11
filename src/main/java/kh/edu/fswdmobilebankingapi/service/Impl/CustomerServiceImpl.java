package kh.edu.fswdmobilebankingapi.service.Impl;

import kh.edu.fswdmobilebankingapi.domain.Customer;
import kh.edu.fswdmobilebankingapi.dto.CreateCustomerRequest;
import kh.edu.fswdmobilebankingapi.dto.CustomerResponse;
import kh.edu.fswdmobilebankingapi.dto.UpdateCustomerRequest;
import kh.edu.fswdmobilebankingapi.mapper.CustomerMapper;
import kh.edu.fswdmobilebankingapi.repository.CustomerRepository;
import kh.edu.fswdmobilebankingapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(()-> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Phone number not found"));

        customerMapper.toCustomerPartially(
                updateCustomerRequest, customer
        );

        customer = customerRepository.save(customer);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public CustomerResponse findByPhoneNumber(String phoneNumber) {
        return customerRepository
                .findByPhoneNumber(phoneNumber)
                .map(customerMapper::mapCustomerToCustomerResponse)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//                .map(customer -> CustomerResponse.builder()
//                        .fullName(customer.getFullName())
//                        .gender(customer.getGender())
//                        .email(customer.getEmail())
//                        .build())
//                .orElseThrow(
//                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public List<CustomerResponse> getAll() {
        return List.of();
    }

    @Override
    public List<CustomerResponse> findAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customerMapper::mapCustomerToCustomerResponse)
                .collect(Collectors.toList());


//                .map(customer ->CustomerResponse.builder()
//                        .fullName(customer.getFullName())
//                        .gender(customer.getGender())
//                        .email(customer.getEmail())
//                        .build() )
//                .toList();

    }

    @Override
    public CustomerResponse createNew(CreateCustomerRequest createCustomerRequest) {

        if (customerRepository.existsByEmail(createCustomerRequest.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        if(customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Phone number already exists"
            );
        }

        Customer customer = customerMapper.formCreateCustomerRequest(createCustomerRequest);


//        Customer customer = new Customer();
//        customer.setFullName(createCustomerRequest.fullName());
//        customer.setGender(createCustomerRequest.gender());
//        customer.setPhoneNumber(createCustomerRequest.phoneNumber());
//        customer.setEmail(createCustomerRequest.email());
//        customer.setRemarks(createCustomerRequest.remark());
//        customer.setIsDeleted(String.valueOf(false));


        log.info("customer ID before save:{}", customer.getId());
        customer = customerRepository.save(customer);
        log.info("customer ID after save:{}", customer.getId());

        return customerMapper.mapCustomerToCustomerResponse(customer);
    }
}
