package com.leasing.backend.domains.leasing.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Slf4j
@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loan_issue_date")
    private Date loanIssueDate;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "loan_time")
    private int loanTime;

    @Column(name = "payment_frecuency")
    private int paymentFrequency;

    @Column(name = "buyback_percentage")
    private double buyBackPercentage;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonDeserialize
    private Currency currency;

    @Column(name = "notarial_cost")
    private double notarialCost;

    @Column(name = "registration_cost")
    private double registrationCost;

    @Column(name = "appraisal")
    private double appraisal;

    @Column(name = "study_commission")
    private double studyCommission;

    @Column(name = "activation_commission")
    private double activationCommission;

    @Column(name = "periodic_commission")
    private double periodicCommission;

    @Column(name = "risk_insurance_percentage")
    private double riskInsurancePercentage;

    @Column(name = "discount_rate_Ks")
    private double discountRateKs;

    @Column(name = "discount_rate_WACC")
    private double discountRateWACC;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonDeserialize
    private User user;
}
