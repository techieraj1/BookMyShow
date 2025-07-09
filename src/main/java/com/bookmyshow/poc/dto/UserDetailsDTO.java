package com.bookmyshow.poc.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDetailsDTO {

    private Long userId;
    @NotBlank(message = "User name cannot be blank")
    @Size(message = "User name must be between 1 and 50 characters", min = 1, max = 50)
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$",
            message = "Enter valid Email")
    @NotBlank(message = "Email ID cannot be blank")
    private String emailId;
    @NotBlank(message = "Contact must not be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Contact must be a valid 10-digit Indian mobile number starting with 6-9")
    private String contact;

}
