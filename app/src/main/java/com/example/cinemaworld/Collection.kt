package com.example.cinemaworld

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.example.cinemaworld.databinding.ActivityCollectionBinding
import com.example.cinemaworld.databinding.ActivitySignInBinding
import kotlin.collections.Collection

class Collection : AppCompatActivity() {
    lateinit var bindingClass:ActivityCollectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityCollectionBinding.inflate((layoutInflater))
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)

        bindingClass.ButtonExite.setOnClickListener {
            var intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_moveToFilmsScreen -> {
                var intent = Intent(this, Room::class.java)
                startActivity(intent)
                finish()
                return true
            }
        }
        return false
    }

    fun showMenu(view: View){
        val popupmenu = PopupMenu(this, view)
        popupmenu.inflate(R.menu.menu_main)

        popupmenu.setOnMenuItemClickListener { item ->
            onOptionsItemSelected(item)
        }
        popupmenu.show()
    }
}