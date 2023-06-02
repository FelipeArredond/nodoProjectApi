package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.SubDetail;
import com.nodoapi.nodoapi.service.SubDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subdetail")
@CrossOrigin("*")
public class SubDetailController {
    private final SubDetailService subDetailService;
    public SubDetailController(SubDetailService subDetailService) {
        this.subDetailService = subDetailService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubDetail> getByUserId(@PathVariable Long id){
        return subDetailService.getByUserId(id).
                map(subDetail -> new ResponseEntity(subDetail, HttpStatus.FOUND))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @PostMapping("")
    public ResponseEntity<SubDetail> saveSubDetail(@RequestBody SubDetail subDetail){
        return new ResponseEntity<>(subDetailService.save(subDetail), HttpStatus.CREATED);
    }
}
