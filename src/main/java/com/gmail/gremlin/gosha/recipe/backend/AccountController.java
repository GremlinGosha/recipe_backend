package com.gmail.gremlin.gosha.recipe.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {

  @GetMapping(value = "/{accountId}")
  public AccountDto getAccountById(@PathVariable Long accountId) {

    if (accountId < 1) {
      throw new RuntimeException("account not found");
    }

    return AccountDto
        .builder()
        .id(accountId)
        .name("name" + accountId)
        .build();
  }
}
