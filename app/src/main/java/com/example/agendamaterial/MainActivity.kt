package com.example.agendamaterial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var contactoAdapter: ContactoAdapter
    private lateinit var listContacto: ArrayList<Contacto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView= findViewById(R.id.recycler_contactos)
        listContacto= ArrayList()
        listContacto.add(Contacto( "Josue", "2881170063"))
        contactoAdapter= ContactoAdapter(listContacto)

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=contactoAdapter

        fabAdd= findViewById(R.id.fab_add)
        fabAdd.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent= Intent(this, DatosActivity::class.java)
        startActivityForResult(intent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==10 && resultCode== Activity.RESULT_OK){
            val contacto: Contacto?= data?.getParcelableExtra("CONTACTO")
            if (contacto!=null){
                listContacto.add(contacto)
                contactoAdapter.notifyDataSetChanged()
            }
        }
    }
}
