package com.example.orevisor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orevisor.classes.AssuntoValue;
import com.example.orevisor.classes.DisciplinaValue;

import java.util.LinkedList;
import java.util.List;

public class AssuntoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "Revisor";
    private static final int VERSAO = 1;


    public AssuntoDAO (Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Assunto (id INTEGER PRIMARY KEY,"
                + " idDisciplina INTEGER NOT NULL,"
                + " nome TEXT UNIQUE NOT NULL,"
                + " descricao TEXT);";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl = "DROP TABLE IF EXISTS Assunto";
        db.execSQL(ddl);
        onCreate(db);
    }

    public void salvar(AssuntoValue assuntoValue) {
        ContentValues values = new ContentValues();
        values.put("idDisciplina", assuntoValue.getIdDisciplina());
        values.put("nome", assuntoValue.getNome());
        values.put("descricao", assuntoValue.getDescricao());

        getWritableDatabase().insert("Assunto", null, values);
    }

    public void alterar(AssuntoValue assuntoValue) {
        ContentValues values = new ContentValues();
        values.put("idDisciplina", assuntoValue.getIdDisciplina());
        values.put("nome", assuntoValue.getNome());
        values.put("descricao", assuntoValue.getDescricao());

        getWritableDatabase().update("Assunto", values,
                "id=?", new String[]{assuntoValue.getId().toString()});
    }

    public void deletar(AssuntoValue assuntoValue) {
        String[] args = { assuntoValue.getId().toString() };
        getWritableDatabase().delete("Assunto", "id=?", args);
    }

    public List getLista(){
        List<AssuntoValue> assuntos = new LinkedList<AssuntoValue>();

        String query = "SELECT  * FROM " + "Disciplina order by nome";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        AssuntoValue assunto = null;
        if (cursor.moveToFirst()) {
            do {
                assunto = new AssuntoValue();
                assunto.setId(Long.parseLong(cursor.getString(0)));
                assunto.setIdDisciplina(Long.valueOf(cursor.getString(1)));
                assunto.setNome(cursor.getString(2));
                assunto.setDescricao(cursor.getString(3));

                assuntos.add(assunto);
            } while (cursor.moveToNext());
        }
        return assuntos;
    }
}
