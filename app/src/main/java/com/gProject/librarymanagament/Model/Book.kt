package com.gProject.librarymanagament.Model

class Book   {
    var id : Int = 0
    var BookName : String = ""
    var Category : String = ""
    var Author : String = ""
    var Location : String = ""



    constructor(bookName : String,category:String,author:String,location : String)
    {
        this.BookName = bookName
        this.Category = category
        this.Author = author
        this.Location = location

    }

    constructor(){

    }


}




