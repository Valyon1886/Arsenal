package com.arsenal.demo.controllers

import com.arsenal.demo.models.Blaster
import com.arsenal.demo.repos.BlasterRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/blasters")
class BlasterController(private val blasterRepository: BlasterRepository) {

    @PostMapping("/new")
    @ResponseBody
    fun createBlaster(@RequestBody blaster: Blaster): Blaster {
        return createBlaster(blaster)
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    fun findBlaster(@PathVariable id: Long): Blaster {
        return findBlaster(id)
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getBlasters(): Blaster {
        return getBlasters()
    }

    @PutMapping("/{id}")
    @ResponseBody
    fun updateBlaster(@PathVariable id: Long, @RequestBody blaster: Blaster): Blaster {
        return updateBlaster(id, blaster)
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    fun deleteBlaster(@PathVariable id: Long): String=deleteBlaster(id)
}

