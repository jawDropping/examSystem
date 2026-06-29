package com.exam.management.controller

import com.exam.management.mapper.toEntity
import com.exam.management.model.dto.user.CreateUserRequest
import com.exam.management.model.dto.user.UpdateUserRequest
import com.exam.management.model.dto.user.UserResponse
import com.exam.management.service.UserService
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
@RequestMapping("/api/users")
class UserController (
    private val userService: UserService
){
    @GetMapping
    fun getAllUsers(): List<UserResponse> =
        userService.getUsers()

    @GetMapping("/{id}")
    fun getUsersById(@PathVariable id: UUID) : UserResponse =
        userService.getUsersById(id)

    @PostMapping
    fun addUser(@Valid @RequestBody request: CreateUserRequest): ResponseEntity<UserResponse> =
        ResponseEntity.created(URI.create("/api/users/id"))
            .body(userService.addUser(request))

    @PatchMapping("/{id}")
    fun editUser(@PathVariable id:UUID, @Valid @RequestBody request: UpdateUserRequest) : UserResponse =
        userService.editUser(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: UUID) = userService.deleteUser(id)
}