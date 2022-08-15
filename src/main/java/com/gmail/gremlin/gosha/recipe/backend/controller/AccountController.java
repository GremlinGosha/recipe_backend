package com.gmail.gremlin.gosha.recipe.backend.controller;

import com.gmail.gremlin.gosha.recipe.backend.models.AccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.CreateAccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.UpdateAccountDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {

  @GetMapping(value = "/{accountId}")
  public AccountDto getAccountById(@PathVariable Long accountId) {
    //see SPRING
    //AccountService accountService;
    if (accountId < 1) {
      throw new RuntimeException("account not found");
    }

    return AccountDto
        .builder()
        .id(accountId)
        .name("name" + accountId)
        .build();
    //return accountService.getAccountById(accountId); example
  }

  @GetMapping(value = "")
  public List<AccountDto> getAccounts() {
    List<AccountDto> accounts = new ArrayList<>();
    AccountDto account1 = new AccountDto();
    account1.setId(1L);
    account1.setName("name" + account1.getId());
    account1.setSurname("surname" + account1.getId());
    account1.setEmail("email" + account1.getId());
    account1.setPhone("phone" + account1.getPhone());

    accounts.add(account1);

    AccountDto account2 = new AccountDto();
    account2.setId(1L);
    account2.setName("name" + account2.getId());
    account2.setSurname("surname" + account2.getId());
    account2.setEmail("email" + account2.getId());
    account2.setPhone("phone" + account2.getPhone());
    accounts.add(account2);

    return accounts;
  }

  @PostMapping(value = "")
  public AccountDto createAccount(@RequestBody CreateAccountDto client)  {
    AccountDto account1 = new AccountDto();
    account1.setId(1L);
    account1.setName(client.getName());
    account1.setSurname(client.getSurname());
    account1.setEmail(client.getEmail());
    account1.setPhone(client.getPhone());

    return account1;
  }

  @PutMapping(value = "/{accountId}")
  public AccountDto editAccount(@PathVariable Long accountId, @RequestBody UpdateAccountDto updateAccountDto) {
    AccountDto editedAccount = new AccountDto();
    editedAccount.setId(accountId);
    editedAccount.setName(updateAccountDto.getName());
    editedAccount.setSurname(updateAccountDto.getSurname());
    editedAccount.setEmail(updateAccountDto.getEmail());
    editedAccount.setPhone(updateAccountDto.getPhone());

    return editedAccount;
  }

  @DeleteMapping(value = "/{id}")
  void deleteAccount(@PathVariable Long accountId) {
    System.out.print("deleteAccount is being executed");
  }
  //Postmapping createAccount, new class CreateAccountDto {} as accountDto no Id
  //getAllMapping список всех аккаунтов
  //putMapping принимает UpdateAccountDto (as CreateAccountDto) и accountId возвращает accountDto
  //deleteMapping void, принимает accountId

  //TODO accountService и пробросить все вызовы из контроллера в аналогичные методы сервиса
  //TODO accountEntity
  //TODO swagger для тестирования через web
  //docker для создания контейнеров, почитать
  //jsonWebToken для авторизации

  //Add database
}
