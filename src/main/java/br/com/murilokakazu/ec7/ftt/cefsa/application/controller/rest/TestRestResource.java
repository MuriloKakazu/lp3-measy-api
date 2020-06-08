package br.com.murilokakazu.ec7.ftt.cefsa.application.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestResource {

  @RequestMapping("/artist")
  public Artist callbackResource(
      @RequestParam(value = "id", defaultValue = "") String id) {

    return new Artist(id, "Snoop Dogg");
  }

  private class Artist {
    public String id;
    public String name;

    public Artist(String id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
