package com.example.n1_henriquegoebel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.List;

public class TelaListaJogadores extends AppCompatActivity {

    private ListView lvJogadores;
    private AdapterJogadores adapter;
    private List<Jogador> listaJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_jogadores);

        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaListaJogadores.this, MainActivity.class);
                intent.putExtra("acao", "novo");
                startActivity(intent);
            }
        });

        lvJogadores = findViewById(R.id.lvJogadores);
        carregarJogadores();
        configurarListView();

    }
    private void configurarListView(){

        lvJogadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Jogador jogadorSelecionado = listaJogadores.get(position);
                Intent intent = new Intent(TelaListaJogadores.this, MainActivity.class);
                intent.putExtra("acao", "editar");
                intent.putExtra("idJogador", jogadorSelecionado.id);
                startActivity(intent);
            }
        });

        lvJogadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Jogador jogadorSelecionado = listaJogadores.get(position);
                excluirJogador(jogadorSelecionado);
                return true;
            }
        });

    }


    private void excluirJogador(Jogador jogador){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setIcon(android.R.drawable.ic_input_delete);
        alerta.setTitle(getString(R.string.txt_excluir_atencao));
        alerta.setMessage(getString(R.string.txt_excluir_message) + " " + jogador.nomeCamiseta);
        alerta.setNeutralButton(getString(R.string.txt_excluir_cancelar), null);
        alerta.setPositiveButton(getString(R.string.txt_excluir_confirmar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JogadorDAO.excluir(TelaListaJogadores.this, jogador.id);
                carregarJogadores();
            }
        });
        alerta.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarJogadores();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void carregarJogadores(){
        listaJogadores = JogadorDAO.getJogadores(this);
        adapter = new AdapterJogadores(this,listaJogadores);
        lvJogadores.setAdapter(adapter);
    }


}