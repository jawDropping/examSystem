package com.exam.management.mapper

import com.exam.management.model.dto.user.CreateUserRequest
import com.exam.management.model.dto.user.UpdateUserRequest
import com.exam.management.model.dto.user.UserResponse
import com.exam.management.model.entity.User
import org.springframework.data.jpa.domain.AbstractPersistable_.id

fun CreateUserRequest.toEntity(): User =
    User(
        firstName = firstName,
        lastName = lastName,
        email = email,
    )

fun User.toResponse(): UserResponse =
    UserResponse(
        id = id!!,
        name = "$firstName $lastName",
        email = email,
    )

fun User.applyUpdate(update: UpdateUserRequest): User =
    apply {
        update.firstName?.let{ firstName = it}
        update.lastName?.let{lastName = it}
        update.email?.let { email = it }
    }