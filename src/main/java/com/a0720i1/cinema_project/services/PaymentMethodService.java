package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentMethodService {
    List<PaymentMethod> getAllPaymentMethod();
}
