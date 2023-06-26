package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.User;
import com.nodoapi.nodoapi.persistence.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository);
    }

    @Test
    void canGetAll() {
        //when
        this.userService.getAll();
        //then
        verify(this.userRepository).findAll();
    }

    @Test
    void canSave() {
        //when
        User user = User.builder()
                .name("test")
                .email("test@mail.com")
                .age(20)
                .idRol(1L)
                .build();
        this.userService.save(user);
        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(this.userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void canGetById() {
        //when
        long id = 1L;
        Optional<User> result = this.userService.getById(id);
        //then
        verify(this.userRepository).findById(id);
        assertThat(result).isInstanceOf(Optional.class);
    }

    @Test
    void canDeleteById() {
        //when
        User user = User.builder()
                .name("test")
                .email("test@mail.com")
                .age(20)
                .idRol(1L)
                .build();
        long id = 1L;
        //then
        given(this.userRepository.findById(id)).willReturn(Optional.of(user));
        boolean result = this.userService.deleteById(id);
        verify(this.userRepository).deleteById(id);
        assertThat(result).isTrue();
    }
}