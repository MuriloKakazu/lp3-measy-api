package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.AccountSpecifications.*;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1")
public class AccountRestResource {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping("/account/{id}")
  public ResponseEntity<Account> getById(@PathVariable(value = "id") UUID id) {
    if (!accountRepository.existsById(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ok(accountRepository.findById(id).get());
  }

  @GetMapping("/accounts")
  public ResponseEntity<List<Account>> searchBySpecifications(Account prototype) {
    return ok(accountRepository.findAll(matching(prototype)));
  }

  @GetMapping("/accounts/search")
  public ResponseEntity<List<Account>> search(@RequestParam(value = "q") String query) {
    return ok(accountRepository.findAll(matching(query)));
  }

  @PostMapping("/account")
  public ResponseEntity<Account> post(@RequestBody Account account) {
    if (accountRepository.existsById(account.getId())) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    return ok(accountRepository.save(account));
  }

  @PutMapping("/account")
  public ResponseEntity<Account> put(@RequestBody Account account) {
    if (!accountRepository.existsById(account.getId())) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ok(accountRepository.save(account));
  }

  @DeleteMapping("/account/{id}")
  public ResponseEntity<Account> delete(@PathVariable(value = "id") UUID id) {
    if (!accountRepository.existsById(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    accountRepository.deleteById(id);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
}
