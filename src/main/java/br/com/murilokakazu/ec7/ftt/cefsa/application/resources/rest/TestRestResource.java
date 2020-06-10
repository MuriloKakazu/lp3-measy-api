package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestResource {

  @RequestMapping("/artist")
  public String getArtistById(
      @RequestParam(value = "id", defaultValue = "") String id) {

    return null;
  }
}
