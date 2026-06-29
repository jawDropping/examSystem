package com.exam.management.model.dto.user

import java.util.UUID

data class UserResponse (
    var id: UUID,
    var name: String,
    var email: String
)