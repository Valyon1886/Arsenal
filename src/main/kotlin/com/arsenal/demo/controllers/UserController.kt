package com.arsenal.demo.controllers

import com.arsenal.demo.models.User
import com.arsenal.demo.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/user")
class UserController (private val userService: UserService) {

    @GetMapping("/get/token/{idToken}")
    @ResponseBody
    fun checkIdTokenUser(@PathVariable idToken: String) = userService.checkIdTokenUser(idToken)

    @GetMapping("/get/idToken/{idToken}")
    @ResponseBody
    fun findUserByIdToken(@PathVariable idToken: String) = userService.findUserByIdToken(idToken)

    @PutMapping("/updateNotFull/{id}")
    @ResponseBody
    fun updateUserNotFull(@PathVariable id: Long, @RequestBody userUpdate: User) = userService.updateUserNotFull(id, userUpdate)

    @PostMapping("/new")
    @ResponseBody
    fun addUser(@RequestBody user: User): User = userService.addUser(user)

    @PostMapping("/{userId}/blaster/{blasterId}")
    @ResponseBody
    fun addBlasterToUser(@PathVariable userId: Long, @PathVariable blasterId: Long) = userService.addBlasterToUser(userId, blasterId)

    @GetMapping("/test")
    @ResponseBody
    fun testos(): String = "sdfghjkl"

    @GetMapping("/all")
    @ResponseBody
    fun getUsers(): List<User> = userService.getUsers()

    @DeleteMapping("/del/{id}")
    @ResponseBody
    fun deleteUser(@PathVariable id: Long): String = userService.deleteUser(id)

    @PutMapping("/{id}")
    @ResponseBody
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User = userService.updateUser(id, user)

    @GetMapping("/{id}")
    @ResponseBody
    fun findUser(@PathVariable id: Long): User? = userService.findUser(id)
}

