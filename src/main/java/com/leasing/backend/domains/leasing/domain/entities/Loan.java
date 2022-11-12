package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Date loanIssueDate;
    private Float salePrice;
    private int loanTime;
    private int paymentFrequency;
    private Float buyBackPercentage;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable=false)
    private Currency currency;

    private Float notarialCost;
    private Float registrationCost;
    private Float appraisal;
    private Float studyCommission;
    private Float activationCommission;
    private Float periodicCommission;
    private Float riskInsurancePercentage;
    private Float discountRateKs;
    private Float discountRateWACC;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private Userb user;

    public Loan(Date loanIssueDate, Float salePrice, int loanTime, int paymentFrequency, Float buyBackPercentage, Currency currency, Float notarialCost, Float registrationCost, Float appraisal, Float studyCommission, Float activationCommission, Float periodicCommission, Float riskInsurancePercentage, Float discountRateKs, Float discountRateWACC, Userb user) {
        this.loanIssueDate = loanIssueDate;
        this.salePrice = salePrice;
        this.loanTime = loanTime;
        this.paymentFrequency = paymentFrequency;
        this.buyBackPercentage = buyBackPercentage;
        this.currency = currency;
        this.notarialCost = notarialCost;
        this.registrationCost = registrationCost;
        this.appraisal = appraisal;
        this.studyCommission = studyCommission;
        this.activationCommission = activationCommission;
        this.periodicCommission = periodicCommission;
        this.riskInsurancePercentage = riskInsurancePercentage;
        this.discountRateKs = discountRateKs;
        this.discountRateWACC = discountRateWACC;
        this.user = user;
    }
}
