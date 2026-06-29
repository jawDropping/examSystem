package com.exam.management.model.dto.exam

import com.exam.management.model.entity.enums.ExamStatus
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class UpdateExamRequest (

    @field:Pattern(
        regexp = "^[a-zA-Z0-9]{6,}$",
        message = "Exam code must be alphanumeric and at least 6 characters long"
    )
    var code: String?,

    @field:Size(max = 255, message = "Description must not exceed 255 characters")
    var description: String?,


    var status: ExamStatus?,
)