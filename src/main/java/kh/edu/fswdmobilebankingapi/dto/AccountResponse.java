package kh.edu.fswdmobilebankingapi.dto;


import java.math.BigDecimal;

public record AccountResponse(
        Integer id,
        String actNo,
        double balance,
        BigDecimal overLimit,
        boolean isDeleted,
        String customerName
) {}

