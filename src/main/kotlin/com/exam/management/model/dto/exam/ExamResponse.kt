package com.exam.management.model.dto.exam

import com.exam.management.model.entity.enums.ExamStatus
import java.util.UUID

data class ExamResponse (
    val id: UUID,
    val code: String,
    val description: String,
    val status: ExamStatus
)