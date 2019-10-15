package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.itcen.springcontainer.videosystem.Avengers;
import kr.co.itcen.springcontainer.videosystem.DVDPlayer;
import kr.co.itcen.springcontainer.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	@Bean
	public DVDPlayer dvdPlayer(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}
