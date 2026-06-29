package com.exam.management.repository

import com.exam.management.model.entity.Exam
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExamRepository: JpaRepository<Exam, UUID>