package io.github.pedroermarinho.hrpayroll.services;

import io.github.pedroermarinho.hrpayroll.entities.Payment;
import io.github.pedroermarinho.hrpayroll.entities.Worker;
import io.github.pedroermarinho.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }


    public Payment getPayment(long workerId, int days) {
        final Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
