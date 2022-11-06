package com.leasing.backend.domains.leasing.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private User user;
}
