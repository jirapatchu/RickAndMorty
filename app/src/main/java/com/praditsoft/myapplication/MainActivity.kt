package com.praditsoft.myapplication

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public class MainActivity : AppCompatActivity(){
    private var recycleView: RecyclerView? = null
    private var adapter: RecycleViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        recycleView = findViewById<RecyclerView>(R.id.recyclerView)

        // this creates a vertical layout Manager
        //recyclerview.layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this, 2)
        recycleView!!.layoutManager = layoutManager

        getCharacterData()
    }
    

    private fun getCharacterData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CharacterService::class.java)
        val call = service.getCharacterData()

        call.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {

                if (response.code() == 200) {
                    val data = ArrayList<CharacterModel>()
                    for (character in response.body()!!.results) {
                        data.add(CharacterModel(character.image!!, character.name!!, character.status!!))
                    }

                    adapter = RecycleViewAdapter(data)
                    recycleView!!.adapter = adapter
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.d("Character", t.toString())
            }
        })
    }



    companion object {
        var BaseUrl = "https://rickandmortyapi.com/"
    }
}