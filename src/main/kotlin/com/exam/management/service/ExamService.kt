package com.exam.management.service

import com.exam.management.mapper.applyUpdate
import com.exam.management.mapper.toEntity
import com.exam.management.mapper.toResponse
import com.exam.management.model.dto.exam.CreateExamRequest
import com.exam.management.model.dto.exam.ExamResponse
import com.exam.management.model.dto.exam.UpdateExamRequest
import com.exam.management.model.entity.Exam
import com.exam.management.repository.ExamRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID


@Service
class ExamService(
    private val repository: ExamRepository
) {
    fun getExamById(id: UUID): ExamResponse =
        repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No exam is found") }
            .toResponse()

    fun getAllExam(): List<ExamResponse> =
        repository.findAll().map(Exam::toResponse)

    fun updateExam(id:UUID, request: UpdateExamRequest): ExamResponse =
        repository.findById(id)
            .orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND, "No Exam is found") }
            .applyUpdate(request)
            .let(repository::save)
            .toResponse()

    fun addExam(request: CreateExamRequest): ExamResponse =
        repository.save(request.toEntity()).toResponse()


    fun deleteExam(id:UUID) = repository.deleteById(id)
}