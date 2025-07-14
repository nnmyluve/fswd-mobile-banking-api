package kh.edu.fswdmobilebankingapi.service;




import kh.edu.fswdmobilebankingapi.dto.AccountResponse;
import kh.edu.fswdmobilebankingapi.dto.CreateAccountRequest;
import kh.edu.fswdmobilebankingapi.dto.UpdateAccountRequest;

import java.util.List;

public interface AccountService {
    AccountResponse create(CreateAccountRequest request);

    List<AccountResponse> findAll();

    AccountResponse findByActNo(String actNo);

    List<AccountResponse> findByCustomerId(Integer customerId);

    void deleteByActNo(String actNo);

    AccountResponse update(String actNo, UpdateAccountRequest request);

    AccountResponse disableByActNo(String actNo);
}
