package br.com.murilokakazu.ec7.ftt.cefsa.domain.repository;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID>, JpaSpecificationExecutor<Album> {
}
