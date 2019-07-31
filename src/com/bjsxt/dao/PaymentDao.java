package com.bjsxt.dao;

import com.bjsxt.entity.Payment;

import java.util.List;

public interface PaymentDao {
    void save(Payment payment);

    List<Object[]> getPaymentData();
}
