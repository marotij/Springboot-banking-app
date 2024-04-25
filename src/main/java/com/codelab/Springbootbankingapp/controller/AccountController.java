package com.codelab.Springbootbankingapp.controller;

import com.codelab.Springbootbankingapp.dto.AccountDto;
import com.codelab.Springbootbankingapp.model.Account;
import com.codelab.Springbootbankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Add Account Rest API
    @PostMapping("/accounts")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account Rest API
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){

        AccountDto accountDto=accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);

    }

    // Deposit Rest API
    @PutMapping("/account/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw Rest API

    @PutMapping("/account/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts Rest API

    @GetMapping("/accounts")
    public ResponseEntity<List< AccountDto>> getAllAcoouts(){

        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account Rest API
    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){

        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully...!");
    }



}
