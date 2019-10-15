package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.itcen.springcontainer.user.Friend;
import kr.co.itcen.springcontainer.user.User;


@Configuration
public class UserConfig01 {
	@Bean("user1")
	public User user() {
		return new User();
	}
	
	@Bean
	public Friend friend() {
		return new Friend("둘리");
	}
	
}
