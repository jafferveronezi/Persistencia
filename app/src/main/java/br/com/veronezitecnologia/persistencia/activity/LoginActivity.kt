package br.com.veronezitecnologia.persistencia.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.veronezitecnologia.persistencia.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("my app", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("MANTER CONECTADO", false)) {
            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        }

        btEntrar.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("MANTER CONECTADO", cbConectado.isChecked)
            editor.putString("USUARIO", edNome.text.toString())
            editor.apply()

            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        }
    }
}
