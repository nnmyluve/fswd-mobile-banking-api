package kh.edu.fswdmobilebankingapi.service.Impl;

import kh.edu.fswdmobilebankingapi.domain.Account;
import kh.edu.fswdmobilebankingapi.domain.Customer;
import kh.edu.fswdmobilebankingapi.dto.AccountResponse;
import kh.edu.fswdmobilebankingapi.dto.CreateAccountRequest;
import kh.edu.fswdmobilebankingapi.dto.UpdateAccountRequest;
import kh.edu.fswdmobilebankingapi.mapper.AccountMapper;
import kh.edu.fswdmobilebankingapi.repository.AccountRepository;
import kh.edu.fswdmobilebankingapi.repository.CustomerRepository;
import kh.edu.fswdmobilebankingapi.service.AccountService;
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
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse create(CreateAccountRequest request) {
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        Account account = accountMapper.fromCreateAccountRequest(request);
        account.setCustomer(customer);

        log.info("Creating account for customer ID: {}", customer.getId());

        account = accountRepository.save(account);

        return accountMapper.toAccountResponse(account);
    }

    @Override
    public List<AccountResponse> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse findByActNo(String actNo) {
        return accountRepository.findByActNo(actNo)
                .map(accountMapper::toAccountResponse)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }

    @Override
    public List<AccountResponse> findByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        return accountRepository.findByCustomer(customer)
                .stream()
                .map(accountMapper::toAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByActNo(String actNo) {
        Account account = accountRepository.findByActNo(actNo)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        accountRepository.delete(account);
        log.info("Deleted account with actNo: {}", actNo);
    }

    @Override
    public AccountResponse update(String actNo, UpdateAccountRequest request) {
        Account account = accountRepository.findByActNo(actNo)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        accountMapper.updateAccountFromRequest(request, account);

        account = accountRepository.save(account);
        return accountMapper.toAccountResponse(account);
    }

    @Override
    public AccountResponse disableByActNo(String actNo) {
        Account account = accountRepository.findByActNo(actNo)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        account.setIsDeleted(true);

        account = accountRepository.save(account);
        return accountMapper.toAccountResponse(account);
    }
}
