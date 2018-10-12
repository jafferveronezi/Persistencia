package br.com.veronezitecnologia.persistencia.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Game(
        var nome: String,
        var genero: String,
        @PrimaryKey(autoGenerate = true) var id: Int
)