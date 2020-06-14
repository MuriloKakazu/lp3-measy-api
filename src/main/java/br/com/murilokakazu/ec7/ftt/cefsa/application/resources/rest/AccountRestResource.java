package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.AccountSpecifications.*;

@RestController
@RequestMapping(value = "/v1")
public class AccountRestResource {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping("/account/{id}")
  public Account getById(@PathVariable(value = "id") UUID id) {
    return accountRepository.findById(id).get();
  }

  @GetMapping("/accounts")
  public List<Account> searchBySpecifications(Account prototype) {
    return accountRepository.findAll(matching(prototype));
  }

  @GetMapping("/accounts/search")
  public List<Account> search(@RequestParam(value = "q") String query) {
    return accountRepository.findAll(matching(query));
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
