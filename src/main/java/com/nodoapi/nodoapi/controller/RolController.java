package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.Rol;
import com.nodoapi.nodoapi.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("")
    public ResponseEntity<List<Rol>> getAll(){
        return new ResponseEntity<>(rolService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/addRol")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
    }
}
