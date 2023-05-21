package com.arsenal.demo.repos

import com.arsenal.demo.models.Ammo
import com.arsenal.demo.models.Blaster
import com.arsenal.demo.models.Game
import com.arsenal.demo.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<User, Long>{
    fun findByIdToken(idToken: String): User?
}

@Repository
interface BlasterRepository : JpaRepository<Blaster, Long>{

}
@Repository
interface AmmoRepository : JpaRepository<Ammo, Long>{

}

@Repository
interface GameRepository : JpaRepository<Game, Long>{

}