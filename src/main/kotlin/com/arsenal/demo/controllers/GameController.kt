package com.arsenal.demo.controllers

import com.arsenal.demo.models.Game
import com.arsenal.demo.services.GameService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/game")
class GameController (private val gameService: GameService) {

    @PostMapping("/new/{id}")
    @ResponseBody
    fun addGame(@RequestBody game: Game, @PathVariable id: Long): Game = gameService.addGame(game, id)

    @PutMapping("/add/user/{id}")
    @ResponseBody
    fun addUserToGame(@RequestBody game: Game, @PathVariable id: Long): Game = gameService.addUserToGame(game, id)

    @GetMapping("/users/{id}")
    @ResponseBody
    fun getUserNames(@PathVariable id: Long): MutableList<String> = gameService.getUserNames(id)

    @GetMapping("/test")
    @ResponseBody
    fun testos(): String = "sdfghjkl"

    @PutMapping("/active")
    @ResponseBody
    fun endActive(@RequestBody game: Game): Game = gameService.endActive(game)

    @GetMapping("/all")
    @ResponseBody
    fun getGames(): List<Game> = gameService.getGames()

    @DeleteMapping("/del/{id}")
    @ResponseBody
    fun deleteGame(@PathVariable id: Long): String = gameService.deleteGame(id)

    @PutMapping("/{id}")
    @ResponseBody
    fun updateGame(@PathVariable id: Long, @RequestBody game: Game): Game = gameService.updateGame(id, game)

    @GetMapping("/{id}")
    @ResponseBody
    fun findGame(@PathVariable id: Long): Game? = gameService.findGame(id)
}

