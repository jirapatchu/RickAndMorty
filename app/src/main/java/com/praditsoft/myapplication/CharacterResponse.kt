package com.praditsoft.myapplication

import com.google.gson.annotations.SerializedName

class CharacterResponse {
    @SerializedName("info")
    var info: PaginationInfo? = null
    @SerializedName("results")
    var results = ArrayList<Character>()
}

class PaginationInfo {
    @SerializedName("count")
    var count: Int = 0
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("next")
    var next: String? = null
    @SerializedName("prev")
    var prev: String? = null
}

class Character {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("status")
    var status: String? = null
    @SerializedName("species")
    var species: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("origin")
    var origin: Location? = null
    @SerializedName("location")
    var location: Location? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("episode")
    var episode = ArrayList<String>()
    @SerializedName("url")
    var url: String? = null
    @SerializedName("created")
    var created: String? = null
}

class Location {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("prev")
    var url: String? = null
}