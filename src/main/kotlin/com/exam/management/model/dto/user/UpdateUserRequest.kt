package com.exam.management.model.dto.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class UpdateUserRequest(

    @field:Size(max = 100, message = "First name must not exceed 100 characters")
    var firstName: String?,

    @field:Size(max = 100, message = "First name must not exceed 100 characters")
    var lastName: String?,

    @field:Email(message = "Email must be valid")
    var email: String?,
)
