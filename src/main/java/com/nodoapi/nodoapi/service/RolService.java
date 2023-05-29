package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.Rol;
import com.nodoapi.nodoapi.persistence.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol save(Rol rol){
        return rolRepository.save(rol);
    }
    public List<Rol> getAll(){
        return (List<Rol>) rolRepository.findAll();
    }
}
