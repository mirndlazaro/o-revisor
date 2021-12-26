package com.example.orevisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orevisor.classes.DisciplinaValue;
import com.example.orevisor.dao.DisciplinaDAO;

import java.util.ArrayList;

public class AddDisciplinaActivity extends AppCompatActivity {

    private ListView lista = null;
    protected DisciplinaValue disciplinaValue;
    protected ArrayAdapter<DisciplinaValue> adapter;

   @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_disciplina);
            DisciplinaDAO dao = new DisciplinaDAO(this);
            DisciplinaValue disciplinaValue = new DisciplinaValue();
            disciplinaValue.setId((new Long("1")).longValue());
            disciplinaValue.setNome("Banco de Dados");
            dao.salvar(disciplinaValue);


            int layout = android.R.layout.simple_list_item_1;
            adapter = new ArrayAdapter<DisciplinaValue>(this,layout, dao.getLista());

            dao.close();

            lista = (ListView) findViewById(R.id.disciplinaListView);
            lista.setAdapter(adapter);
        }

        @Override
        protected void onResume() {
            super.onResume();

            DisciplinaDAO dao = new DisciplinaDAO(this);
            ArrayList<DisciplinaValue> disciplinas= new ArrayList(dao.getLista());
            dao.close();
            int layout = android.R.layout.simple_list_item_1;

            adapter = new ArrayAdapter<DisciplinaValue>(this,layout, disciplinas);

            lista.setAdapter(adapter);
            lista.setOnCreateContextMenuListener(this);
            registerForContextMenu(lista);
        }
    }
}