package kh.edu.fswdmobilebankingapi.dto;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateAccountRequest(
        @PositiveOrZero double balance,
        @Positive BigDecimal overLimit
) {}
