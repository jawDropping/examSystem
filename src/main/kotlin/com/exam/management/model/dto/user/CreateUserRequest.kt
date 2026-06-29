package com.exam.management.model.dto.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest(
    @field:NotBlank(message = "First name is required")
    @field:Size(max = 100, message = "First name must not exceed 100 characters")
    var firstName: String,

    @field:NotBlank(message = "Last name is required")
    @field:Size(max = 100, message = "First name must not exceed 100 characters")
    var lastName: String,

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email must be valid")
    var email: String,
)
