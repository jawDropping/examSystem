package com.exam.management.model.dto.exam

import com.exam.management.model.entity.enums.ExamStatus
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class CreateExamRequest(

    @field:NotBlank(message = "Exam code is required")
    @field:Pattern(
        regexp = "^[a-zA-Z0-9]{6,}$",
        message = "Exam code must be alphanumeric and at least 6 characters long"
    )
    val code: String,

    @field:NotBlank(message = "Description is required")
    @field:Size(max = 255, message = "Description must not exceed 255 characters")
    val description: String,

    @field:NotNull(message = "Status is required")
    val status: ExamStatus
)