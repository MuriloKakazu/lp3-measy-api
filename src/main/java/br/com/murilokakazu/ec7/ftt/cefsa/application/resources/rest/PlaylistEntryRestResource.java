package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.PlaylistEntry;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.PlaylistEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1")
public class PlaylistEntryRestResource {
    @Autowired
    private PlaylistEntryRepository playlistEntryRepository;

    @GetMapping("/playlist-entry/{id}")
    public PlaylistEntry getById(@PathVariable(value = "id") UUID id) {
        return playlistEntryRepository.findById(id).get();
    }

    @PostMapping("/playlist-entry")
    public PlaylistEntry post(@RequestBody PlaylistEntry playlistEntry) {
        return playlistEntryRepository.save(playlistEntry);
    }

    @PutMapping("/playlist-entry")
    public PlaylistEntry put(@RequestBody PlaylistEntry playlistEntry) {
        return playlistEntryRepository.save(playlistEntry);
    }
}
