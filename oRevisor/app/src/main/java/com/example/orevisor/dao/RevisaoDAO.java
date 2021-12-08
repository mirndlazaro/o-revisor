package com.example.orevisor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orevisor.classes.RevisaoValue;

import java.util.LinkedList;
import java.util.List;

public class RevisaoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "Revisor";
    private static final int VERSAO = 1;

    public RevisaoDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Revisao (id INTEGER PRIMARY KEY,"
                + " nome TEXT UNIQUE NOT NULL);";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl = "DROP TABLE IF EXISTS Revisao";
        db.execSQL(ddl);
        onCreate(db);
    }

    public void salvar(RevisaoValue revisaoValue) {
        ContentValues values = new ContentValues();
        values.put("nome", revisaoValue.getNome());

        getWritableDatabase().insert("Disciplina", null, values);
    }

    public void alterar(RevisaoValue revisaoValue) {
        ContentValues values = new ContentValues();
        values.put("nome", revisaoValue.getNome());

        getWritableDatabase().update("Disciplina", values,
                "id=?", new String[]{revisaoValue.getId().toString()});
    }

    public void deletar(RevisaoValue revisaoValue) {
        String[] args = { revisaoValue.getId().toString() };
        getWritableDatabase().delete("Disciplina", "id=?", args);
    }

    public List getLista(){
        List<RevisaoValue> revisoes = new LinkedList<RevisaoValue>();

        String query = "SELECT  * FROM " + "Disciplina order by nome";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        RevisaoValue revisao = null;
        if (cursor.moveToFirst()) {
            do {
                revisao = new RevisaoValue();
                revisao.setId(Long.parseLong(cursor.getString(0)));

                revisao.setNome(cursor.getString(1));
                revisoes.add(revisao);
            } while (cursor.moveToNext());
        }
        return revisoes;
    }

    public void dropAll(){
        String ddl ="DROP TABLE IF EXISTS Disciplina";
        getWritableDatabase().execSQL(ddl);
        onCreate( getWritableDatabase());
    }
}
