package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.itcen.springcontainer.user.User;

@Configuration
public class UserConfig02 {
	@Bean
	public User user() {
		return new User();
	}
}
