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
class BlasterService (private val blasterRepository: BlasterRepository, private val ammoService: AmmoService){
    fun createBlaster(blaster: Blaster): Blaster {
        for (i in blaster.ammo.indices) {
            ammoService.createAmmo(blaster.ammo[i])
        }
        return blasterRepository.save(blaster)
    }

    fun findBlaster(id: Long): Blaster {
        return blasterRepository.findById(id).orElseThrow { EntityNotFoundException("Blaster not found with id $id") }
    }

    fun deleteBlaster(id: Long): String = blasterRepository.deleteById(id).toString()


    fun updateBlaster(id: Long, blaster: Blaster): Blaster {
        return blasterRepository.findById(id).map {
            it.name = blaster.name
            for (i in blaster.ammo) {
                if (i.id?.let { it1 -> ammoService.findAmmo(it1) } !=null) {
                    ammoService.updateAmmo(i.id!!, i)
                } else{
                    ammoService.createAmmo(i)
                }
            }
            it.ammo = blaster.ammo
            it.amount = blaster.amount
            it.image = blaster.image
            it.series = blaster.series
            it.category = blaster.category
            it.author = blaster.author
            blasterRepository.save(it)
        }.orElseThrow { EntityNotFoundException("Blaster not found with id $id") }
    }

    fun getBlasters(): List<Blaster> = blasterRepository.findAll()
}