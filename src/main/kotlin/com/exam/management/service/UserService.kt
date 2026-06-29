package com.exam.management.service

import com.exam.management.mapper.applyUpdate
import com.exam.management.mapper.toEntity
import com.exam.management.mapper.toResponse
import com.exam.management.model.dto.user.CreateUserRequest
import com.exam.management.model.dto.user.UpdateUserRequest
import com.exam.management.model.dto.user.UserResponse
import com.exam.management.model.entity.User
import com.exam.management.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class UserService(
    private var userRepository: UserRepository,
) {

    fun getUsers(): List<UserResponse> =
        userRepository.findAll().map(User::toResponse)

    fun getUsersById(id: UUID): UserResponse =
        userRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found") }
            .toResponse()

    fun editUser(id:UUID, request: UpdateUserRequest): UserResponse =
        userRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found") }
            .applyUpdate(request)
            .let(userRepository::save)
            .toResponse()

    fun addUser(request: CreateUserRequest): UserResponse =
        userRepository.save(request.toEntity()).toResponse()

    fun deleteUser(id: UUID) = userRepository.deleteById(id)
}