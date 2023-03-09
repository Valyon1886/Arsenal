package com.arsenal.demo.controllers

import com.arsenal.demo.models.Blaster
import com.arsenal.demo.repos.BlasterRepository
import com.arsenal.demo.services.BlasterService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/blasters")
class BlasterController(private val blasterService: BlasterService) {

    @PostMapping("/new")
    @ResponseBody
    fun createBlaster(@RequestBody blaster: Blaster): Blaster {
        return blasterService.createBlaster(blaster)
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    fun findBlaster(@PathVariable id: Long): Blaster {
        return blasterService.findBlaster(id)
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getBlasters(): List<Blaster> {
        return blasterService.getBlasters()
    }

    @PutMapping("/{id}")
    @ResponseBody
    fun updateBlaster(@PathVariable id: Long, @RequestBody blaster: Blaster): Blaster {
        return blasterService.updateBlaster(id, blaster)
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    fun deleteBlaster(@PathVariable id: Long): String=blasterService.deleteBlaster(id)
}

