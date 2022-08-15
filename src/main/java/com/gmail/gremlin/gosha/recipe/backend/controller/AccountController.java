package com.gmail.gremlin.gosha.recipe.backend.controller;

import com.gmail.gremlin.gosha.recipe.backend.models.AccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.CreateAccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.UpdateAccountDto;
import com.gmail.gremlin.gosha.recipe.backend.services.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping(value = "/{accountId}")
  public AccountDto getAccountById(@PathVariable Long accountId) {
    if (accountId < 1) {
      throw new RuntimeException("account not found");
    }

    return accountService.getAccountById(accountId);
  }

  @GetMapping(value = "")
  public List<AccountDto> getAccounts() {
    List<AccountDto> accounts = accountService.getAccounts();
    return accounts;
  }

  @PostMapping(value = "")
  public AccountDto createAccount(@RequestBody CreateAccountDto client)  {
    return accountService.createAccount(client);
  }

  @PutMapping(value = "/{accountId}")
  public AccountDto editAccount(@PathVariable Long accountId, @RequestBody UpdateAccountDto updateAccountDto) {
    return accountService.editAccount(accountId, updateAccountDto);
  }

  @DeleteMapping(value = "/{id}")
  void deleteAccount(@PathVariable Long accountId) {
    System.out.print("AccountController: deleteAccount is being executed'\n'");
    accountService.deleteAccount(accountId);
  }
  //Postmapping createAccount, new class CreateAccountDto {} as accountDto no Id
  //getAllMapping список всех аккаунтов
  //putMapping принимает UpdateAccountDto (as CreateAccountDto) и accountId возвращает accountDto
  //deleteMapping void, принимает accountId
  //accountService и пробросить все вызовы из контроллера в аналогичные методы сервиса

  //TODO accountEntity
  //TODO swagger для тестирования через web
  //docker для создания контейнеров, почитать
  //jsonWebToken для авторизации

  //Add database
}
