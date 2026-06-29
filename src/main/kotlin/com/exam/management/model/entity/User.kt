package com.exam.management.model.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    val id: UUID? = null,

    @Column(name = "first_name", nullable = false)
    var firstName: String,
    @Column(name = "last_name", nullable = false)
    var lastName: String,

    @Column(name = "email", nullable = false)
    var email: String
)