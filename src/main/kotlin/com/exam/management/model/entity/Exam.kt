package com.exam.management.model.entity

import com.exam.management.model.entity.enums.ExamStatus
import jakarta.persistence.*
import org.springframework.context.annotation.Description
import java.util.UUID

@Entity
@Table(name = "exam")
class Exam(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    val id: UUID? = null,

    @Column(name = "code", nullable = false)
    var code: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: ExamStatus
)