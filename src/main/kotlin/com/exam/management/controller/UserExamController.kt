package com.exam.management.controller

import com.exam.management.model.dto.userExam.UserExamResponse
import com.exam.management.service.UserExamService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/user-exams")
class UserExamController(
    private val userExamService: UserExamService
) {

    @GetMapping
    fun getUserExams(
        @RequestParam(name = "user_id", required = false) user_id: UUID?,
        @RequestParam(name = "exam_id", required = false) exam_id: UUID?
    ): List<UserExamResponse> =
        userExamService.getUserExams(user_id, exam_id)

    @GetMapping("/{id}")
    fun getUserExamById(@PathVariable id: UUID): UserExamResponse =
        userExamService.getUserExamById(id)

    @PatchMapping("/{id}/submit")
    fun submitUserExam(@PathVariable id: UUID): UserExamResponse =
        userExamService.submitUserExam(id)
}