package com.leasing.backend.domains.leasing.resources;

import com.leasing.backend.domains.leasing.domain.entities.Currency;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class LoanResource {
    private Long loanId;
    private Date loanIssueDate;
    private double salePrice;
    private int loanTime;
    private int paymentFrequency;
    private double buyBackPercentage;
    private Long currencyId;
    private double notarialCost;
    private double registrationCost;
    private double appraisal;
    private double studyCommission;
    private double activationCommission;
    private double periodicCommission;
    private double riskInsurancePercentage;
    private double discountRateKs;
    private double discountRateWACC;
    private Long userId;
}
