package com.arsenal.demo.services

import com.arsenal.demo.models.Blaster
import com.arsenal.demo.models.User
import com.arsenal.demo.repos.BlasterRepository
import com.arsenal.demo.repos.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class BlasterService (private val blasterRepository: BlasterRepository){
    fun createBlaster(blaster: Blaster): Blaster = blasterRepository.save(blaster)

    fun findBlaster(id: Long): Blaster {
        return blasterRepository.findById(id).orElseThrow { EntityNotFoundException("Blaster not found with id $id") }
    }

    fun deleteBlaster(id: Long): String = blasterRepository.deleteById(id).toString()


    fun updateBlaster(id: Long, blaster: Blaster): Blaster {
        return blasterRepository.findById(id).map {
            it.name = blaster.name
            it.ammo = blaster.ammo
            it.image = blaster.image
            it.series = blaster.series
            it.category = blaster.category
            it.author = blaster.author
            blasterRepository.save(it)
        }.orElseThrow { EntityNotFoundException("Blaster not found with id $id") }
    }

    fun getBlasters(): List<Blaster> = blasterRepository.findAll()
}