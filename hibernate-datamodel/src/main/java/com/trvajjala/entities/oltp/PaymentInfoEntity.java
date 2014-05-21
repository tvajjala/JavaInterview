package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.PaymentMode;

@Entity
@Table(name = "PAYMENTINFO")
public class PaymentInfoEntity implements Serializable {

	private static final long serialVersionUID = -5164985606004511409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentInfoId;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PaymentMode paymentMode;

	@ManyToOne
	@JoinColumn(name = "paymentMethodId")
	@ForeignKey(name = "FK_PaymentInfo_paymentMethod")
	private PaymentMethodEntity paymentMethod;

	private Integer installmentsCount;

	private Integer externalOrderNumber;

	private Integer paymentGatewayInvoiceId;

	private Integer easyPaySubscriptionId;

	private Integer transactionId;

	@Column(length = 100)
	private String bankApprovalNumber;

	@Column(length = 100)
	private String destinationBankId;

	@Column(length = 100)
	private String xmlFileName;

	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public PaymentMethodEntity getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodEntity paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getInstallmentsCount() {
		return installmentsCount;
	}

	public void setInstallmentsCount(Integer installmentsCount) {
		this.installmentsCount = installmentsCount;
	}

	public Integer getExternalOrderNumber() {
		return externalOrderNumber;
	}

	public void setExternalOrderNumber(Integer externalOrderNumber) {
		this.externalOrderNumber = externalOrderNumber;
	}

	public Integer getPaymentGatewayInvoiceId() {
		return paymentGatewayInvoiceId;
	}

	public void setPaymentGatewayInvoiceId(Integer paymentGatewayInvoiceId) {
		this.paymentGatewayInvoiceId = paymentGatewayInvoiceId;
	}

	public Integer getEasyPaySubscriptionId() {
		return easyPaySubscriptionId;
	}

	public void setEasyPaySubscriptionId(Integer easyPaySubscriptionId) {
		this.easyPaySubscriptionId = easyPaySubscriptionId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getBankApprovalNumber() {
		return bankApprovalNumber;
	}

	public void setBankApprovalNumber(String bankApprovalNumber) {
		this.bankApprovalNumber = bankApprovalNumber;
	}

	public String getDestinationBankId() {
		return destinationBankId;
	}

	public void setDestinationBankId(String destinationBankId) {
		this.destinationBankId = destinationBankId;
	}

	public String getXmlFileName() {
		return xmlFileName;
	}

	public void setXmlFileName(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

}
