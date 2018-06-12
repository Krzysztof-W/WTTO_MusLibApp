package com.kwarzecha.MusLibApp;

import com.kwarzecha.MusLibApp.model.Artist;
import com.kwarzecha.MusLibApp.model.Song;
import com.kwarzecha.MusLibApp.repositories.ArtistRepository;
import com.kwarzecha.MusLibApp.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitializationListener implements ApplicationListener<ContextRefreshedEvent> {
	private ArtistRepository artistRepository;
	private SongRepository songRepository;

	public InitializationListener(ArtistRepository artistRepository, SongRepository songRepository) {
		this.artistRepository = artistRepository;
		this.songRepository = songRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Set<Artist> artists = new HashSet<>();
		Set<Song> songs = new HashSet<>();
		Artist artist = new Artist("John", "Dew", "Emil");
		artists.add(artist);
		Song song = new Song("Lions", "pop", "1999", "B");
		songs.add(song);
		artist.setSongs(songs);
		song.setArtists(artists);
		artistRepository.save(artist);
		songRepository.save(song);

		Set<Artist> artistSet = new HashSet<>();
		Set<Song> songSet = new HashSet<>();
		Artist artistOne = new Artist("Mathew", "More", "Han");
		artistSet.add(artistOne);
		Song songOne = new Song("Metro", "rock", "2001", "A");
		songSet.add(songOne);
		Song songTwo = new Song("Waterfall", "metal", "2003", "C");
		songSet.add(songTwo);
		artistOne.setSongs(songSet);
		songOne.setArtists(artistSet);
		songTwo.setArtists(artistSet);
		artistRepository.save(artistOne);
		songRepository.save(songOne);
		songRepository.save(songTwo);
	}
}

