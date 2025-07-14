package kh.edu.fswdmobilebankingapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank String actNo,
        @PositiveOrZero double balance,
        @Positive BigDecimal overLimit,
        @NotNull Integer customerId
) {}
