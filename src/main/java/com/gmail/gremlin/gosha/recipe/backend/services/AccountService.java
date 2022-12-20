package com.gmail.gremlin.gosha.recipe.backend.services;

import com.gmail.gremlin.gosha.recipe.backend.models.AccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.CreateAccountDto;
import com.gmail.gremlin.gosha.recipe.backend.models.UpdateAccountDto;

import java.util.List;


public interface AccountService {

  AccountDto getAccountById(Long accountId);

  List<AccountDto> getAccounts();

  AccountDto createAccount(CreateAccountDto client);

  AccountDto editAccount(Long accountId, UpdateAccountDto updateAccountDto);

  void deleteAccount(Long accountId);

}
