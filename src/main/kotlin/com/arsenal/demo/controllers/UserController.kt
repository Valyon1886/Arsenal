package com.arsenal.demo.controllers

import com.arsenal.demo.models.User
import com.arsenal.demo.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/user")
class UserController (private val userService: UserService) {

    @PostMapping("/newUser")
    @ResponseBody
    fun addUser(@RequestBody user: User): User = userService.addUser(user)  // TODO Сделать через json

    @GetMapping("/test")
    @ResponseBody
    fun testos(): String = "sdfghjkl"

    @GetMapping("/all")
    @ResponseBody
    fun getUsers(): List<User> = userService.getUsers()

    @DeleteMapping("/del/{id}")
    @ResponseBody
    fun deleteUser(@PathVariable id: Long): String = userService.deleteUser(id)

    @PutMapping("/del/{id}")
    @ResponseBody
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User = userService.updateUser(id, user)

    @GetMapping("/{id}")
    @ResponseBody
    fun findUser(@PathVariable id: Long): User? = userService.findUser(id)
}