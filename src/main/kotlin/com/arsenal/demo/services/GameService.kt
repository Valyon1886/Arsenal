package com.arsenal.demo.services

import com.arsenal.demo.models.Game
import com.arsenal.demo.models.User
import com.arsenal.demo.repos.GameRepository
import com.arsenal.demo.repos.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameService (
    private val gameRepository: GameRepository,
    private val userRepository: UserRepository,
    private val blasterService: BlasterService,
    private val userService: UserService
){
    fun addGame(game: Game, userId: Long): Game {

        var currentUser:User? = userRepository.findByIdOrNull(userId)
        var newGame:Game = gameRepository.save(game)
        if (currentUser != null) {
            currentUser.games?.add(game)
            userRepository.save(currentUser)
        }
        return newGame
    }

    fun addUserToGame(game: Game, userId: Long): Game {
        var user: User? = userRepository.findByIdOrNull(userId)

        var newGame:Game = game
        newGame.users?.add(userId)
        game.users=newGame.users

        gameRepository.save(game)

        if (user != null) {
            user.games?.add(newGame)
            userRepository.save(user)
        }

        return game
    }

//    fun addAllowedSeriesToGame(game: Game, series: MutableList<String?>): Game {
//        var newGame:Game = game
//        newGame.allowedSeries=series
//        gameRepository.save(game)
//
//        return game
//    }

    fun getUserNames(gameId: Long): MutableList<String>{
        var res:MutableList<String> = mutableListOf()
        val game: Game = gameRepository.findByIdOrNull(gameId)!!
        for (i in game.users!!) userRepository.findByIdOrNull(i)?.userName?.let { res.add(it) }
        return  res
    }

    fun endActive(game: Game): Game {

        var newGame:Game = game
        newGame.isActive=false

        return gameRepository.save(newGame)
    }


    fun getGames(): List<Game> = gameRepository.findAll().toList()

    fun deleteGame(id: Long): String {
        gameRepository.deleteById(id)
        return "OK"//Response.isOk();  //  TODO Сделать через json
    }

    fun updateGame(id: Long, game:Game): Game {
        var updateGame = gameRepository.findByIdOrNull(id)
        if(updateGame!=null) {
            updateGame.users = game.users
            updateGame.name = game.name
            updateGame.image = game.image
            updateGame.mode = game.mode
            updateGame.amount = game.amount
            return gameRepository.save(updateGame)
        }
        return game
       // return Response.isOk()  //  TODO Сделать через json негативный ответ
    }

    fun findGame(id: Long): Game? = gameRepository.findByIdOrNull(id)
}