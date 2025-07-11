package kh.edu.fswdmobilebankingapi.dto;

public record UpdateCustomerRequest(
        String fullName,
        String phoneNumber
) {
}
