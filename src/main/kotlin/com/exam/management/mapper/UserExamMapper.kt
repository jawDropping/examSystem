package com.exam.management.mapper


import com.exam.management.model.dto.userExam.UserExamResponse
import com.exam.management.model.entity.UserExams

fun UserExams.toResponse(): UserExamResponse =
    UserExamResponse(
        id = id!!,
        name = "${user.firstName} ${user.lastName}",
        email = user.email,
        examId = exam.id!!,
        examCode = exam.code,
        description = exam.description,
        examStatus = exam.status,
        dateTake = dateTaken,
        status = status
    )