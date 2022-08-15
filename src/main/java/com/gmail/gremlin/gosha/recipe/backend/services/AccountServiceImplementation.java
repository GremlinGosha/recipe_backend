package com.gmail.gremlin.gosha.recipe.backend.services;

import com.gmail.gremlin.gosha.recipe.backend.models.AccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.CreateAccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.UpdateAccountDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

  @Override
  public AccountDto getAccountById(Long accountId) {
    return AccountDto
        .builder()
        .id(accountId)
        .name("name" + accountId)
        .build();
  }

  @Override
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

  @Override
  public AccountDto createAccount(CreateAccountDto client) {
    AccountDto account1 = new AccountDto();
    account1.setId(1L);
    account1.setName(client.getName());
    account1.setSurname(client.getSurname());
    account1.setEmail(client.getEmail());
    account1.setPhone(client.getPhone());

    return account1;
  }

  @Override
  public AccountDto editAccount(Long accountId, UpdateAccountDto updateAccountDto) {
    AccountDto editedAccount = new AccountDto();
    editedAccount.setId(accountId);
    editedAccount.setName(updateAccountDto.getName());
    editedAccount.setSurname(updateAccountDto.getSurname());
    editedAccount.setEmail(updateAccountDto.getEmail());
    editedAccount.setPhone(updateAccountDto.getPhone());

    return editedAccount;
  }

  @Override
  public void deleteAccount(Long accountId) {
    System.out.print("AccountService: deleteAccount is being executed");
  }
}
