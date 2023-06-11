package com.example.cinemaworld

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.cinemaworld.databinding.ActivityRoomBinding


class Room : AppCompatActivity() {
    lateinit var bindingClass: ActivityRoomBinding

    lateinit var FilmList: ArrayList<Film>
    lateinit var ListView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityRoomBinding.inflate((layoutInflater))
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)

        bindingClass.ButtonAdd.setOnClickListener {
            var intent = Intent(this@Room, AddFilm::class.java)
            startActivity(intent)
        }

        FilmList = ArrayList()
        FilmList.add(Film(R.drawable.smurfsone,"Смурфики","Пьер Кюллифор","Комедия"))
        FilmList.add(Film(R.drawable.smurfstwo,"Смурфики 2","Пьер Кюллифор","Комедия"))
        FilmList.add(Film(R.drawable.paddingtonone,"Паддингтон","Томас Майкл Бонд ","Комедия"))
        FilmList.add(Film(R.drawable.paddingtontwo,"Паддингтон 2","Томас Майкл Бонд ","Комедия"))
        FilmList.add(Film(R.drawable.bigearedriot,"Бунт Ушастых","Тим Хилл","Комедия"))

        ListView = bindingClass.ListViewFilms
        ListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedFilm = FilmList[position]
            val intent = Intent(this, Film::class.java)
            intent.putExtra("film", selectedFilm)
            startActivity(intent)
        }
    }
}