package com.example.agendamaterial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class DatosActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtNombre: EditText
    private lateinit var txtTelefono: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)
        txtNombre= findViewById(R.id.txt_nombre)
        txtTelefono=findViewById(R.id.txt_telefono)
        btnGuardar= findViewById(R.id.btn_guardar)

        btnGuardar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val contacto: Contacto=Contacto(txtNombre.text.toString(), txtTelefono.text.toString())
        val intent: Intent= this.intent
        intent.putExtra("CONTACTO", contacto)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
