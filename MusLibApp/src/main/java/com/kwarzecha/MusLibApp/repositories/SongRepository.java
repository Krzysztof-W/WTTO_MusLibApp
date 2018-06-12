package com.kwarzecha.MusLibApp.repositories;

import com.kwarzecha.MusLibApp.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
