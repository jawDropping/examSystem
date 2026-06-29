package com.exam.management.controller

import com.exam.management.model.dto.exam.CreateExamRequest
import com.exam.management.model.dto.exam.ExamResponse
import com.exam.management.model.dto.exam.UpdateExamRequest
import com.exam.management.model.dto.userExam.CreateUserExamRequest
import com.exam.management.model.dto.userExam.UserExamResponse
import com.exam.management.service.ExamService
import com.exam.management.service.UserExamService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/api/exams")
class ExamController (
    private val service: ExamService,
    private val userExamService: UserExamService
){

    @GetMapping
    fun getExams(): List<ExamResponse> =
        service.getAllExam()

    @GetMapping("/{id}")
    fun getExamsById(@PathVariable id: UUID): ExamResponse=
        service.getExamById(id)

    @PostMapping
    fun addExam(@Valid @RequestBody request: CreateExamRequest): ResponseEntity<ExamResponse> =
        ResponseEntity.created(URI.create("/api/exams/id")).body(service.addExam(request))

    @PatchMapping("/{id}")
    fun editExam(@PathVariable id:UUID, @Valid @RequestBody request: UpdateExamRequest): ExamResponse =
        service.updateExam(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteExam(@PathVariable id:UUID) = service.deleteExam(id)

    @PostMapping("/{id}/assign")
    fun assignExamToUser(
        @PathVariable id: UUID,
        @Valid @RequestBody request: CreateUserExamRequest
    ): ResponseEntity<UserExamResponse> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(userExamService.assignExamToUser(id, request))
}