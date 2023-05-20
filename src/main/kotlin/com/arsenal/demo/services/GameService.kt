package com.arsenal.demo.services

import com.arsenal.demo.models.Game
import com.arsenal.demo.models.User
import com.arsenal.demo.repos.GameRepository
import com.arsenal.demo.repos.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameService (private val gameRepository: GameRepository, private val userRepository: UserRepository, private val blasterService: BlasterService){
    fun addGame(game: Game, userId: Long): Game {

        var currentUser:User? = userRepository.findByIdOrNull(userId)
        if (currentUser != null) {
            currentUser.games?.add(game)
            userRepository.save(currentUser)
        }
        return gameRepository.save(game)
    }

    fun getGames(): List<Game> = gameRepository.findAll().toList()

    fun deleteGame(id: Long): String {
        gameRepository.deleteById(id)
        return "OK"//Response.isOk();  //  TODO Сделать через json
    }

    fun updateGame(id: Long, game:Game): Game {
        var updateGame = gameRepository.findByIdOrNull(id)
        if(updateGame!=null) {
            for (i in game.arsenals!!) {
                for (j in i) {
                    if (j.id?.let { it -> blasterService.findBlaster(it) } !=null) {
                        blasterService.updateBlaster(j.id!!, j)
                    } else{
                        blasterService.createBlaster(j)
                    }
                }
            }
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