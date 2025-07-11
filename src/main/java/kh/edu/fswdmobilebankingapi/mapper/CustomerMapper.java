package kh.edu.fswdmobilebankingapi.mapper;

import kh.edu.fswdmobilebankingapi.domain.Customer;
import kh.edu.fswdmobilebankingapi.dto.CreateCustomerRequest;
import kh.edu.fswdmobilebankingapi.dto.CustomerResponse;
import kh.edu.fswdmobilebankingapi.dto.UpdateCustomerRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    
    void toCustomerPartially(
            UpdateCustomerRequest updateCustomerRequest, 
            @MappingTarget Customer customer);
    
    
    //DTO -> Model
    //Model -> DTO
    //what is source data? (parameter)
    //what is target data? (return_type)
    
    CustomerResponse mapCustomerToCustomerResponse(Customer customer);
    Customer formCreateCustomerRequest(CreateCustomerRequest customerResponse);
    CustomerResponse toCustomerResponse(Customer customer);
}
