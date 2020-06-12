package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1")
public class AccountRestResource {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping("/account/{id}")
  public Account getById(@PathVariable(value = "id") UUID id) {
    return accountRepository.findById(id).get();
  }

  @PostMapping("/account")
  public Account post(@RequestBody Account account) {
    return accountRepository.save(account);
  }

  @PutMapping("/account")
  public Account put(@RequestBody Account account) {
    return accountRepository.save(account);
  }
}
