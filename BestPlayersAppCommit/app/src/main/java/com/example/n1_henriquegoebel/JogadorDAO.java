package com.example.n1_henriquegoebel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class JogadorDAO {

        public static void inserir(Context context, Jogador jogador){
            Banco conn = new Banco(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nomeCompleto", jogador.nomeCompleto);
            valores.put("nomeCamiseta", jogador.nomeCamiseta);
            valores.put("pePreferencial", jogador.pePreferencial);
            valores.put("numeroCamiseta", jogador.numeroCamiseta);
            valores.put("goleiro", jogador.goleiro);
            valores.put("lateral", jogador.lateral);
            valores.put("zagueiro", jogador.zagueiro);
            valores.put("meia", jogador.meia);
            valores.put("atacante", jogador.atacante);



            db.insert("jogador", null, valores);



            db.close();
        }

        public static void editar(Context context, Jogador jogador){
            Banco conn = new Banco(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nomeCompleto", jogador.getNomeCompleto());
            valores.put("nomeCamiseta", jogador.getNomeCamiseta());
            valores.put("pePreferencial", jogador.getPePreferencial());
            valores.put("numeroCamiseta", jogador.getNumeroCamiseta());
            valores.put("goleiro", jogador.getGoleiro());
            valores.put("lateral", jogador.getLateral());
            valores.put("zagueiro", jogador.getZagueiro());
            valores.put("meia", jogador.getMeia());
            valores.put("atacante", jogador.getAtacante());

            db.update("jogador", valores, " id = " + jogador.getId(), null);



            db.close();
        }

        public static void excluir(Context context, int idJogador){
            Banco conn = new Banco(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            db.delete("jogador", " id = " + idJogador, null);



            db.close();
        }


        public static List<Jogador> getJogadores(Context context){
            Banco conn = new Banco(context);
            SQLiteDatabase db = conn.getReadableDatabase();

            Cursor cursor = db.rawQuery( "SELECT j.id, j.nomeCompleto, j.nomeCamiseta," +
                    "j.pePreferencial, j.numeroCamiseta, j.goleiro, j.lateral," +
                    "j.zagueiro, j.meia, j.atacante" +
                    " FROM jogador j " +
                    " ORDER BY j.numeroCamiseta ", null );

            List<Jogador> lista = new ArrayList<>();

            if( cursor.getCount() > 0 ){
                cursor.moveToFirst();

                do{
                    Jogador j = new Jogador();
                    j.setId( cursor.getInt(0));
                    j.setNomeCompleto( cursor.getString(1));
                    j.setNomeCamiseta( cursor.getString(2));
                    j.setPePreferencial( cursor.getString(3));
                    j.setNumeroCamiseta( cursor.getInt(4));
                    j.setGoleiro( cursor.getInt(5));
                    j.setLateral( cursor.getInt(6));
                    j.setZagueiro( cursor.getInt(7));
                    j.setMeia( cursor.getInt(8));
                    j.setAtacante( cursor.getInt(9));



                    lista.add( j );
                }while (cursor.moveToNext());
            }
            return lista;
        }

        public static Jogador getJogadorbyID(Context context, int id){
            Banco banco = new Banco(context);
            SQLiteDatabase db = banco.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT j.id, j.nomeCompleto, j.nomeCamiseta," +
                    "j.pePreferencial, j.numeroCamiseta, j.goleiro, j.lateral," +
                    "j.zagueiro, j.meia, j.atacante" +
                    " FROM jogador j " +
                    " WHERE id = " + id, null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                Jogador j = new Jogador();
                j.setId( cursor.getInt(0));
                j.setNomeCompleto( cursor.getString(1));
                j.setNomeCamiseta( cursor.getString(2));
                j.setPePreferencial( cursor.getString(3));
                j.setNumeroCamiseta( cursor.getInt(4));
                j.setGoleiro( cursor.getInt(5));
                j.setLateral( cursor.getInt(6));
                j.setZagueiro( cursor.getInt(7));
                j.setMeia( cursor.getInt(8));
                j.setAtacante( cursor.getInt(9));

                return j;
            }else{
                return null;
            }
        }


}
