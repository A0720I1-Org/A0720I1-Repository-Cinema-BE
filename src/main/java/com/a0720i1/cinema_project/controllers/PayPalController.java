package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.common.paypal.PaypalPaymentIntent;
import com.a0720i1.cinema_project.common.paypal.PaypalPaymentMethod;
import com.a0720i1.cinema_project.models.dto.ticket.LinkDTO;
import com.a0720i1.cinema_project.models.dto.ticket.PaymentDTO;
import com.a0720i1.cinema_project.services.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member/paypal")
public class PayPalController {

    public static final String URL_PAYPAL_SUCCESS = "/pay/success";
    public static final String URL_PAYPAL_CANCEL = "/pay/cancel";


    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @PostMapping(value = "/pay")
    public ResponseEntity<LinkDTO> pay(@RequestBody PaymentDTO paymentDTO, HttpServletRequest request) {

        String cancelUrl = "http://localhost:4200/book/booking-confirmation";
        String successUrl = "http://localhost:4200/book/create-booking";

        try {
            Payment payment = paypalService.createPayment(
                    paymentDTO.getAmount(),
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "Payment by Paypal",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    LinkDTO linkDTO = new LinkDTO(links.getHref());
                    return new ResponseEntity<>(linkDTO, HttpStatus.OK) ;
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay() {
        return "http://localhost:4200/book/booking-confirmation";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public ResponseEntity<Void> successPay(@RequestParam("paymentId") String paymentId,
                                           @RequestParam("payerId") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
