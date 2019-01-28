package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Payment;

public interface PaymentMapper {
	public int add(Payment Payment);

	public void delete(int id);

	public Payment get(int id);

	public int update(Payment Payment);

	public List<Payment> list();
}