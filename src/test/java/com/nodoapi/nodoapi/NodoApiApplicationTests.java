package com.nodoapi.nodoapi;

import com.nodoapi.nodoapi.persistence.entity.User;
import com.nodoapi.nodoapi.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NodoApiApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	void itShouldFoundByEmail(){
		// given
		String email = "root";
		//when
		Optional<User> user = this.userRepository.findByEmail(email);
		//then
		assertThat(user.map(User::getEmail).orElse("not found")).isEqualTo(email);
	}

}
