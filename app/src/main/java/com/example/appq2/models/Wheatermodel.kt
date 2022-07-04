package com.example.appq2.models

class Wheatermodel {
    val id : Int
    val main: String
    val description : String
    val icon : String

    constructor(id: Int, main: String, description: String, icon: String) {
        this.id = id
        this.main = main
        this.description = description
        this.icon = icon
    }
}