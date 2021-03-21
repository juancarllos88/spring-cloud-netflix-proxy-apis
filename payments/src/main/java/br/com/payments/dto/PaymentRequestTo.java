package br.com.payments.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentRequestTo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cpf;

	private String card;

	private String cvv;
	
	private String idPayment;
	
	private BigDecimal value;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[cpf=" + cpf + ", card=" + card + ", cvv=" + cvv + ", idPayment=" + idPayment
				+ ", value=" + value + "]";
	}

	

	

	
	

}
