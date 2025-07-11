package kh.edu.fswdmobilebankingapi.dto;

public record CreateCustomerRequest(
        String fullName,
        String gender,
        String email,
        String phoneNumber,
        String remark

) {
}
