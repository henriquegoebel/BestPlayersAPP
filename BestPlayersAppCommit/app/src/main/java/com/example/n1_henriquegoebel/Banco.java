package com.example.n1_henriquegoebel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "jogadores";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE IF NOT EXISTS jogador ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " nomeCompleto TEXT ," +
                " nomeCamiseta TEXT NOT NULL ," +
                " pePreferencial TEXT , " +
                " numeroCamiseta INTEGER NOT NULL , " +
                " goleiro INTEGER ,"+
                " lateral INTEGER ,"+
                " zagueiro INTEGER ,"+
                " meia INTEGER ,"+
                " atacante INTEGER );"

        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antiga, int atual) {
        if ( atual == 2){
            sqLiteDatabase.execSQL("Delete FROM jogador");
        }
    }
}