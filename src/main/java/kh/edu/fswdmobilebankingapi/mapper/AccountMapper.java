package kh.edu.fswdmobilebankingapi.mapper;



import kh.edu.fswdmobilebankingapi.domain.Account;
import kh.edu.fswdmobilebankingapi.dto.AccountResponse;
import kh.edu.fswdmobilebankingapi.dto.CreateAccountRequest;
import kh.edu.fswdmobilebankingapi.dto.UpdateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account fromCreateAccountRequest(CreateAccountRequest request);

    @Mapping(source = "customer.fullName", target = "customerName")
    AccountResponse toAccountResponse(Account account);

    void updateAccountFromRequest(UpdateAccountRequest request, @MappingTarget Account account);
}
