package com.exam.management.mapper

import com.exam.management.model.dto.exam.CreateExamRequest
import com.exam.management.model.dto.exam.ExamResponse
import com.exam.management.model.dto.exam.UpdateExamRequest
import com.exam.management.model.entity.Exam
import com.exam.management.model.entity.enums.ExamStatus

fun CreateExamRequest.toEntity(): Exam =
    Exam(
        code = code,
        description = description,
        status = ExamStatus.ACTIVE,
    )

fun Exam.toResponse(): ExamResponse =
    ExamResponse(
        id = id!!,
        code = code,
        description = description,
        status = status
    )

fun Exam.applyUpdate(update: UpdateExamRequest): Exam =
    apply {
        update.code?.let{ code = it}
        update.description?.let { description = it }
        update.status?.let { status = it }
    }