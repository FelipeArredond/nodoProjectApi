package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.PaymentReference;
import com.nodoapi.nodoapi.service.PaymentReferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment_references")
@CrossOrigin("*")
public class PaymentReferenceController {
    private final PaymentReferenceService paymentReferenceService;

    public PaymentReferenceController(PaymentReferenceService paymentReferenceService) {
        this.paymentReferenceService = paymentReferenceService;
    }

    @PostMapping("")
    public ResponseEntity<PaymentReference> save(@RequestBody PaymentReference paymentReference){
        return new ResponseEntity<>(paymentReferenceService.save(paymentReference), HttpStatus.CREATED);
    }
}
