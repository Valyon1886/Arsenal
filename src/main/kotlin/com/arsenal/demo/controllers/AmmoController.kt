package com.arsenal.demo.controllers

import com.arsenal.demo.models.Ammo
import com.arsenal.demo.services.AmmoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/ammo")
class AmmoController(private val ammoService: AmmoService) {

    @PostMapping("/new")
    @ResponseBody
    fun createAmmo(@RequestBody ammo: Ammo): Ammo {
        return ammoService.createAmmo(ammo)
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    fun findAmmo(@PathVariable id: Long): Ammo {
        return ammoService.findAmmo(id)
    }

    @GetMapping("/all")
    @ResponseBody
    fun getAmmo(): List<Ammo> {
        return ammoService.getAmmo()
    }

    @PutMapping("/{id}")
    @ResponseBody
    fun updateAmmo(@PathVariable id: Long, @RequestBody ammo: Ammo): Ammo {
        return ammoService.updateAmmo(id, ammo)
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    fun deleteAmmo(@PathVariable id: Long): String=ammoService.deleteAmmo(id)
}