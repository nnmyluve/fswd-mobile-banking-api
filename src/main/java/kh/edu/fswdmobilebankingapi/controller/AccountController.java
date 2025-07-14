package kh.edu.fswdmobilebankingapi.controller;


import jakarta.validation.Valid;
import kh.edu.fswdmobilebankingapi.dto.AccountResponse;
import kh.edu.fswdmobilebankingapi.dto.CreateAccountRequest;
import kh.edu.fswdmobilebankingapi.dto.UpdateAccountRequest;
import kh.edu.fswdmobilebankingapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponse create(@RequestBody @Valid CreateAccountRequest request) {
        return accountService.create(request);
    }

    @GetMapping
    public List<AccountResponse> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{actNo}")
    public AccountResponse findByActNo(@PathVariable String actNo) {
        return accountService.findByActNo(actNo);
    }

    @GetMapping("/customer/{customerId}")
    public List<AccountResponse> findByCustomer(@PathVariable Integer customerId) {
        return accountService.findByCustomerId(customerId);
    }

    @DeleteMapping("/{actNo}")
    public void deleteByActNo(@PathVariable String actNo) {
        accountService.deleteByActNo(actNo);
    }

    @PutMapping("/{actNo}")
    public AccountResponse update(@PathVariable String actNo, @RequestBody @Valid UpdateAccountRequest request) {
        return accountService.update(actNo, request);
    }

    @PutMapping("/{actNo}/disable")
    public AccountResponse disable(@PathVariable String actNo) {
        return accountService.disableByActNo(actNo);
    }
}
