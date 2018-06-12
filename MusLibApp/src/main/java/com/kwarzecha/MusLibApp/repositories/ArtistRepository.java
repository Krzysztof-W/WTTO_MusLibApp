package com.kwarzecha.MusLibApp.repositories;

import com.kwarzecha.MusLibApp.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
