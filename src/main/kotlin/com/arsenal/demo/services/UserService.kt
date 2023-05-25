package com.arsenal.demo.services

import com.arsenal.demo.models.User
import com.arsenal.demo.repos.BlasterRepository
import com.arsenal.demo.repos.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository, private val blasterService: BlasterService,
                   private val blasterRepository: BlasterRepository){

    fun checkIdTokenUser(idToken: String): Boolean {
        return userRepository.findByIdToken(idToken) != null
    }

    fun findUserByIdToken(idToken: String): User? {
        return userRepository.findByIdToken(idToken)
    }

    fun addUser(user: User): User {
        for (i in user.arsenal!!) {
            blasterService.createBlaster(i)
        }
        //TODO GAMES ANal arsenal
        return userRepository.save(user)
    }

    fun getUsers(): List<User> = userRepository.findAll().toList()

    fun deleteUser(id: Long): String {
        userRepository.deleteById(id)
        return "OK"//Response.isOk();  //  TODO Сделать через json
    }

    fun updateUserNotFull(id: Long, userUpdate: User): User? {
        val user = userRepository.findByIdOrNull(id)
        userUpdate.image?.let { user?.image = it }
        return user?.let { userRepository.save(it) }
    }

    fun addBlasterToUser(userId: Long, blasterId: Long): User? {
        val blaster = blasterRepository.findByIdOrNull(blasterId)
        var user = userRepository.findByIdOrNull(userId)
        if (user != null) {
            blaster?.let { user.arsenal?.add(it) }
        }
        return user?.let { userRepository.save(it) }
    }

    fun updateUser(id: Long, user:User): User {
        var updateUser = userRepository.findByIdOrNull(id)
        if(updateUser!=null) {
            updateUser.userName = user.userName
            for (i in user.arsenal!!) {
                if (i.id?.let { it1 -> blasterService.findBlaster(it1) } !=null) {
                    blasterService.updateBlaster(i.id!!, i)
                } else{
                    blasterService.createBlaster(i)
                }
            }
            updateUser.arsenal = user.arsenal
            updateUser.image = user.image
            updateUser.role = user.role
            return userRepository.save(updateUser)
        }
        return user
       // return Response.isOk()  //  TODO Сделать через json негативный ответ
    }

    fun findUser(id: Long): User? = userRepository.findByIdOrNull(id)
}