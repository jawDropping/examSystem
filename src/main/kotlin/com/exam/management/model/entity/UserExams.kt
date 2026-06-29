package com.exam.management.model.entity

import com.exam.management.model.entity.enums.UserExamStatus
import jakarta.annotation.Generated
import jakarta.persistence.*
import java.time.OffsetDateTime
import java.util.UUID

@Entity
@Table(name = "user_exams")
class UserExams(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    val exam: Exam,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(name = "date_taken",nullable = false)
    val dateTaken: OffsetDateTime = OffsetDateTime.now(),

    @Enumerated(EnumType.STRING)
    var status: UserExamStatus = UserExamStatus.PENDING
)