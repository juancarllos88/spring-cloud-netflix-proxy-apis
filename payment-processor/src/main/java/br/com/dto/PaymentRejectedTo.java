package br.com.dto;

import java.io.Serializable;

public class PaymentRejectedTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idPayment;

	private String reason;

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public PaymentRejectedTo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentRejectedTo(String idPayment, String reason) {
		super();
		this.idPayment = idPayment;
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "[idPayment=" + idPayment + ", reason=" + reason + "]";
	}
	
	

}
