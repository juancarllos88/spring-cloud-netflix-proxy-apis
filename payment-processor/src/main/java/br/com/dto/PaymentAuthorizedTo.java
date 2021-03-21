package br.com.dto;

import java.io.Serializable;

public class PaymentAuthorizedTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idPayment;

	private String message;

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PaymentAuthorizedTo(String idPayment, String message) {
		super();
		this.idPayment = idPayment;
		this.message = message;
	}

	public PaymentAuthorizedTo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
