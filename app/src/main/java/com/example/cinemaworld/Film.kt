package com.example.cinemaworld

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/*
import android.os.Parcel




public class Film{
    var Name: String? = null
    var Genre: String? = null
    var Author: String? = null

    fun Film(name: String, genre: String, author: String) {
        Name = name
        Genre = genre
        Author = author
    }

    fun FilmInfo(`in`: Parcel) {
        val data = arrayOfNulls<String>(3)
        `in`.readStringArray(data)
        Name = data[0]
        Genre = data[1]
        Author = data[2]
    }
}*/
/*
class Film(var name: String, var genre: String, var author: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(genre)
        parcel.writeString(author)
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }
}*/


class Film(var image:Int, var name: String?, var genre: String?, var author: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(image)
        dest.writeString(name)
        dest.writeString(genre)
        dest.writeString(author)
    }

    companion object {
        @JvmField
        val CREATOR: Creator<Film?> = object : Creator<Film?> {
            override fun createFromParcel(source: Parcel): Film? {
                val image = source.readInt()
                val name = source.readString()
                val company = source.readString()
                val author = source.readString()
                return Film(image, name, company, author)
            }

            override fun newArray(size: Int): Array<Film?> {
                return arrayOfNulls(size)
            }
        }
    }
}