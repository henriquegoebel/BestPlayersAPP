package com.example.n1_henriquegoebel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etNomeCompleto, etNomeCamiseta, etNumeroCamiseta;
    private RadioGroup rgPe;
    private RadioButton rbCanhoto, rbDestro, rbAmbidestro;
    private CheckBox cbGoleiro, cbLateral, cbZagueiro, cbMeia, cbAtacante;
    private Button btSalvar;
    private String acao;
    private Jogador jogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomeCompleto = findViewById(R.id.etNomeCompleto);
        etNomeCamiseta = findViewById(R.id.etNomeCamiseta);
        etNumeroCamiseta = findViewById(R.id.etNumeroCamiseta);
        rgPe = findViewById(R.id.rgPe);
        rbCanhoto = findViewById(R.id.rbCanhoto);
        rbDestro = findViewById(R.id.rbDestro);
        rbAmbidestro = findViewById(R.id.rbAmbidestro);
        cbGoleiro = findViewById(R.id.cbGoleiro);
        cbLateral = findViewById(R.id.cbLateral);
        cbZagueiro = findViewById(R.id.cbZagueiro);
        cbMeia = findViewById(R.id.cbMeia);
        cbAtacante = findViewById(R.id.cbAtacante);
        btSalvar = findViewById(R.id.btSalvar);

        acao = getIntent().getStringExtra("acao");
        if(acao.equals("editar")){
            carregarFormulario();
        }

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }
    private void carregarFormulario(){
        int idJogador = getIntent().getIntExtra("idJogador", 0);
        if(idJogador != 0){
            jogador = JogadorDAO.getJogadorbyID(this, idJogador);

            etNomeCompleto.setText(jogador.nomeCompleto);
            etNomeCamiseta.setText(jogador.nomeCamiseta);
            etNumeroCamiseta.setText(String.valueOf(jogador.getNumeroCamiseta()));

            if (jogador.pePreferencial.equals(getString(R.string.rb_canhoto))){
                rbCanhoto.setChecked(true);
            }else if (jogador.pePreferencial.equals(getString(R.string.rb_destro))){
                rbDestro.setChecked(true);
            }else if (jogador.pePreferencial.equals(getString(R.string.rb_ambidestro))){
                rbAmbidestro.setChecked(true);
            }
            if(jogador.goleiro == 1){
                cbGoleiro.setChecked(true);
            }
            if(jogador.zagueiro == 1){
                cbZagueiro.setChecked(true);
            }
            if(jogador.lateral == 1){
                cbLateral.setChecked(true);
            }
            if(jogador.meia == 1){
                cbMeia.setChecked(true);
            }
            if(jogador.atacante == 1){
                cbAtacante.setChecked(true);
            }

        }
    }

    private void salvar(){


        String nomeCamiseta = etNomeCamiseta.getText().toString();
        String numeroCamiseta = etNumeroCamiseta.getText().toString();


        if(!(nomeCamiseta.isEmpty() || numeroCamiseta.isEmpty())){
            if(acao.equals("novo")){
                jogador = new Jogador();
            }

            jogador.nomeCompleto = etNomeCompleto.getText().toString();
            jogador.nomeCamiseta = etNomeCamiseta.getText().toString();
            jogador.numeroCamiseta = Integer.valueOf(etNumeroCamiseta.getText().toString());


            int radioButtonId = rgPe.getCheckedRadioButtonId();
            String tempPe = ((RadioButton) findViewById(radioButtonId)).getText().toString();
            if(tempPe.equals(getString(R.string.rb_canhoto))){
                jogador.pePreferencial = "Canhoto";
            }else if(tempPe.equals(getString(R.string.rb_destro))){
                jogador.pePreferencial = "Destro";
            }else if(tempPe.equals(getString(R.string.rb_ambidestro))){
                jogador.pePreferencial = "Ambidestro";
            }

            jogador.pePreferencial = ((RadioButton) findViewById(radioButtonId)).getText().toString();
            if(cbGoleiro.isChecked()){
                jogador.goleiro = 1;
            }else{
                jogador.goleiro = 0;
            }
            if(cbLateral.isChecked()){
                jogador.lateral = 1;
            }else{
                jogador.lateral = 0;
            }
            if(cbZagueiro.isChecked()){
                jogador.zagueiro = 1;
            }else{
                jogador.zagueiro = 0;
            }
            if(cbMeia.isChecked()){
                jogador.meia = 1;
            }else{
                jogador.meia = 0;
            }
            if(cbAtacante.isChecked()){
                jogador.atacante = 1;
            }else{
                jogador.atacante = 0;
            }

            if(acao.equals("editar")){
                JogadorDAO.editar(this, jogador);
                finish();
            }else {
                JogadorDAO.inserir(this, jogador);
            }




        }

        Intent intent = new Intent(MainActivity.this, TelaListaJogadores.class);
        intent.putExtra("acao", "salvar");
        startActivity(intent);

    }
}