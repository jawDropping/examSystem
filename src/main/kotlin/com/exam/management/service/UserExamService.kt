package com.exam.management.service

import com.exam.management.mapper.toResponse
import com.exam.management.model.dto.userExam.CreateUserExamRequest
import com.exam.management.model.dto.userExam.UserExamResponse
import com.exam.management.model.entity.UserExams
import com.exam.management.model.entity.enums.UserExamStatus
import com.exam.management.repository.ExamRepository
import com.exam.management.repository.UserExamRepository
import com.exam.management.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class UserExamService(
    private val userExamRepository: UserExamRepository,
    private val userRepository: UserRepository,
    private val examRepository: ExamRepository
) {

    fun assignExamToUser(examId: UUID, request: CreateUserExamRequest): UserExamResponse {
        val user = userRepository.findById(request.user_id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No user is found") }

        val exam = examRepository.findById(examId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No exam is found") }

        val userExam = UserExams(
            user = user,
            exam = exam
        )

        return userExamRepository.save(userExam).toResponse()
    }

    fun getUserExams(userId: UUID?, examId: UUID?): List<UserExamResponse> {
        val results = when {
            userId != null && examId != null -> userExamRepository.findByUser_IdAndExam_Id(userId, examId)
            userId != null -> userExamRepository.findByUser_Id(userId)
            examId != null -> userExamRepository.findByExam_Id(examId)
            else -> userExamRepository.findAll()
        }
        return results.map(UserExams::toResponse)
    }

    fun getUserExamById(id: UUID): UserExamResponse =
        userExamRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No user exam is found") }
            .toResponse()

    fun submitUserExam(id: UUID): UserExamResponse {
        val userExam = userExamRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No user exam is found") }

        userExam.status = UserExamStatus.COMPLETED

        return userExamRepository.save(userExam).toResponse()
    }
}