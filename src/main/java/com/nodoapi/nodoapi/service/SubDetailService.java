package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.Sub;
import com.nodoapi.nodoapi.persistence.entity.SubDetail;
import com.nodoapi.nodoapi.persistence.repository.SubDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubDetailService {
    private final SubDetailRepository subDetailRepository;

    public SubDetailService(SubDetailRepository subDetailRepository) {
        this.subDetailRepository = subDetailRepository;
    }

    public SubDetail save(SubDetail subDetail){
        subDetailRepository.deleteAllByIdPerson(subDetail.getIdPerson());
        return subDetailRepository.save(subDetail);
    }

    public List<SubDetail> getAll(){
        return (List<SubDetail>) subDetailRepository.findAll();
    }

    public boolean deleteById(Long id){
        return subDetailRepository.findById(id).map(subDetail -> {
            subDetailRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public Optional<SubDetail> getByUserId(Long userId){
        return subDetailRepository.findAllByIdPerson(userId);
    }
}
