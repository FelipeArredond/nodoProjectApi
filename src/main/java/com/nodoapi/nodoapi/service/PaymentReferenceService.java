package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.PaymentReference;
import com.nodoapi.nodoapi.persistence.repository.PaymentReferenceRepository;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentReferenceService {
    private final PaymentReferenceRepository paymentReferenceRepository;

    public PaymentReferenceService(PaymentReferenceRepository paymentReferenceRepository) {
        this.paymentReferenceRepository = paymentReferenceRepository;
    }

    public List<PaymentReference> getAll(){
        return (List<PaymentReference>) paymentReferenceRepository.findAll();
    }

    public PaymentReference save(PaymentReference paymentReference){
        return paymentReferenceRepository.save(paymentReference);
    }
}
