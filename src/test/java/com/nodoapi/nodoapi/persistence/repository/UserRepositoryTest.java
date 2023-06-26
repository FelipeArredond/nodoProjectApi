package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @AfterEach
    void tearDown(){
        this.userRepository.deleteAll();
    }
    @Test
    void itShouldFoundByEmail(){
        // given
        String mail = "test@gmail.com";
        User expect = User.builder().name("Felipe").email(mail).build();
        this.userRepository.save(expect);
        //when
        Optional<User> user = this.userRepository.findByEmail(mail);
        //then
        assertThat(user.map(User::getEmail).orElse("not found")).isEqualTo(mail);
    }
    @Test
    void itShouldNotFoundByEmail(){
        // given
        String mail = "test@gmail.com";
        String wrongMail = "wrongMail";
        User expect = User.builder().name("Felipe").email(mail).build();
        this.userRepository.save(expect);
        //when
        Optional<User> user = this.userRepository.findByEmail(wrongMail);
        //then
        assertThat(user.map(User::getEmail).orElse("not found")).isNotEqualTo(mail);
    }

}