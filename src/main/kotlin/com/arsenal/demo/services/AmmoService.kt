package com.arsenal.demo.services

import com.arsenal.demo.models.Ammo
import com.arsenal.demo.repos.AmmoRepository
import jakarta.persistence.EntityNotFoundException

class AmmoService (private val ammoRepository: AmmoRepository){
    fun createAmmo(ammo: Ammo): Ammo = ammoRepository.save(ammo)

    fun findAmmo(id: Long): Ammo {
        return ammoRepository.findById(id).orElseThrow { EntityNotFoundException("Ammo not found with id $id") }
    }

    fun deleteAmmo(id: Long): String = ammoRepository.deleteById(id).toString()


    fun updateAmmo(id: Long, ammo: Ammo): Ammo {
        return ammoRepository.findById(id).map {
            it.name = ammo.name
            it.amount = ammo.amount
            ammoRepository.save(it)
        }.orElseThrow { EntityNotFoundException("Can't update Ammo") }
    }

    fun getAmmo(): List<Ammo> = ammoRepository.findAll()
}