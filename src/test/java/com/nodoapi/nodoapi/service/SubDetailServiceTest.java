package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.Sub;
import com.nodoapi.nodoapi.persistence.entity.SubDetail;
import com.nodoapi.nodoapi.persistence.repository.SubDetailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubDetailServiceTest {
    @Mock private SubDetailRepository subDetailRepository;
    private SubDetailService subDetailService;

    @BeforeEach
    void setUp() {
        this.subDetailService = new SubDetailService(this.subDetailRepository);
    }

    @Test
    void canSave(){
        // given
        SubDetail item = SubDetail.builder()
                .sub(Sub.builder().idSub(1L).type("premium").state("active").build())
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .idSub(1L)
                .build();
        this.subDetailService.save(item);
        // when
        ArgumentCaptor<SubDetail> subDetailArgumentCaptor = ArgumentCaptor.forClass(SubDetail.class);
        // then
        verify(this.subDetailRepository).save(subDetailArgumentCaptor.capture());
        SubDetail captured = subDetailArgumentCaptor.getValue();
        assertThat(captured).isEqualTo(item);
    }

    @Test
    void getAll(){
        // given
        // when
        this.subDetailService.getAll();
        // then
        verify(this.subDetailRepository).findAll();
    }
    @Test
    void canDeleteById(){
        // given
        SubDetail item = SubDetail.builder()
                .sub(Sub.builder().idSub(1L).type("premium").state("active").build())
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .idSub(1L)
                .build();
        // when
        long id = 1L;
        given(this.subDetailRepository.findById(id)).willReturn(Optional.of(item));
        boolean result = this.subDetailService.deleteById(id);
        // then
        verify(this.subDetailRepository).deleteById(id);
        assertThat(result).isTrue();
    }
    @Test
    void canNotDeleteById(){
        // given
        SubDetail item = SubDetail.builder()
                .sub(Sub.builder().idSub(1L).type("premium").state("active").build())
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .idSub(1L)
                .build();
        // when
        long id = 1L;
        boolean result = this.subDetailService.deleteById(id);
        // then
        verify(this.subDetailRepository).findById(id);
        assertThat(result).isFalse();
    }
    @Test
    void canGetByUserId(){
        // given
        // when
        long userId = 1L;
        this.subDetailService.getByUserId(userId);
        // then
        verify(this.subDetailRepository).findAllByIdPerson(userId);
    }

}