package com.gym.management.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GymMemberRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String phone,
        @NotBlank String membershipType
) {
}
