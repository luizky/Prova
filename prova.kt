package br.unipar.exemploadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unipar.myapplication.R
import br.unipar.prova1.R

class MainActivity : AppCompatActivity() {

    private val listaDeTarefas = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edlugar = findViewById<EditText>(R.id.edlugar)
        val eddata = findViewById<EditText>(R.id.eddata)
        val eddinheiro = findViewById<EditText>(R.id.eddinheiro)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)
        listViewTarefas.adapter = adapter

        btnCadastrar.setOnClickListener {
            val tarefa = edlugar.text.toString()
            val tarefa2 = eddata.text.toString()
            val tarefa3 = eddinheiro.text.toString()

            if (tarefa.isNotEmpty() && tarefa2.isNotEmpty() && tarefa3.isNotEmpty()) {
                listaDeTarefas.add("Lugar: $tarefa")
                listaDeTarefas.add("Data: $tarefa2")
                listaDeTarefas.add("Valor: $tarefa3")
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Tarefas adicionadas: $tarefa, $tarefa2, $tarefa3", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}
////////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textViewDestino"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Destino"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edlugar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Lugar"
            android:inputType="text" />

        <TextView
            android:id="@+id/textViewData"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Data"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/eddata"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Data"
            android:inputType="text" />

        <TextView
            android:id="@+id/textViewValor"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Valor"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/eddinheiro"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Valor"
            android:inputType="text" />

        <Button
            android:id="@+id/btnCadastrar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Cadastrar" />

        <ListView
            android:id="@+id/listViewTarefas"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
