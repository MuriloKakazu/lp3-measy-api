package br.com.murilokakazu.ec7.ftt.cefsa.domain.repository;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PlaylistRepository extends JpaRepository<Playlist, UUID>, JpaSpecificationExecutor<Playlist> {
}
