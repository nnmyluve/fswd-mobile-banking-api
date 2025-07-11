package kh.edu.fswdmobilebankingapi.controller;


import jakarta.websocket.server.PathParam;
import kh.edu.fswdmobilebankingapi.dto.CreateCustomerRequest;
import kh.edu.fswdmobilebankingapi.dto.CustomerResponse;
import kh.edu.fswdmobilebankingapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{phoneNumber}")
    public CustomerResponse findByPhoneNumber(
            @PathVariable String phoneNumber
    ){
        return customerService.findByPhoneNumber(phoneNumber);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResponse createNew(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createNew(createCustomerRequest);
    }

}
