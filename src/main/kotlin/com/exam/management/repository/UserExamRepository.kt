package com.exam.management.repository

import com.exam.management.model.entity.UserExams
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserExamRepository : JpaRepository<UserExams, UUID> {

    fun findByUser_Id(userId: UUID): List<UserExams>

    fun findByExam_Id(examId: UUID): List<UserExams>

    fun findByUser_IdAndExam_Id(userId: UUID, examId: UUID): List<UserExams>
}