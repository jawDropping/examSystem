package com.exam.management.model.dto.userExam

import com.exam.management.model.entity.enums.ExamStatus
import com.exam.management.model.entity.enums.UserExamStatus
import java.time.OffsetDateTime
import java.util.UUID

data class UserExamResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val examId: UUID,
    val examCode: String,
    val description: String,
    val examStatus: ExamStatus,
    val dateTake: OffsetDateTime,
    val status: UserExamStatus,
)
