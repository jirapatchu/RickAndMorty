package com.praditsoft.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.Character

interface CharacterService {
    @GET("api/character")
    fun getCharacterData(): Call<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}