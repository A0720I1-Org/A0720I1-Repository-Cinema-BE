package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.PaymentMethod;
import com.a0720i1.cinema_project.repositories.PaymentMethodRepository;
import com.a0720i1.cinema_project.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }
}
