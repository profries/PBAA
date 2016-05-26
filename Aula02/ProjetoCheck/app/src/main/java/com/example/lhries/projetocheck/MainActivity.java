package com.example.lhries.projetocheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener,DialogInterface.OnClickListener{

    Button botaoPagar;
    CheckBox checkLuz;
    CheckBox checkAgua;
    CheckBox checkTelefone;
    CheckBox checkCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoPagar = (Button) this.findViewById(R.id.botaoPagar);
        botaoPagar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        checkLuz = (CheckBox) findViewById(R.id.checkLuz);
        checkAgua = (CheckBox) findViewById(R.id.checkAgua);
        checkTelefone = (CheckBox) findViewById(R.id.checkTelefone);
        checkCelular = (CheckBox) findViewById(R.id.checkCelular);

        int soma = 0;

        if(checkLuz.isChecked())
            soma += Integer.parseInt(checkLuz.getTag().toString());

        if(checkAgua.isChecked())
            soma += Integer.parseInt(checkAgua.getTag().toString());

        if(checkTelefone.isChecked())
            soma += Integer.parseInt(checkTelefone.getTag().toString());

        if(checkCelular.isChecked())
            soma += Integer.parseInt(checkCelular.getTag().toString());


        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Pagamento");
        dialogo.setMessage("Valor total: "+soma);
        dialogo.setNeutralButton("OK",this);
        dialogo.setNegativeButton("Cancelar", this);
        dialogo.show();
    }

    @Override
    public void onClick(DialogInterface arg0, int tipo) {
        if(tipo == AlertDialog.BUTTON_NEUTRAL){
            Toast.makeText(getApplicationContext(),
                    "Pagamento realizado com sucesso!",
                    Toast.LENGTH_SHORT).show();
        }
        else if(tipo == AlertDialog.BUTTON_NEGATIVE){
            Toast.makeText(getApplicationContext(),
                    "Pagamento Cancelado!",
                    Toast.LENGTH_SHORT).show();
        }
        checkLuz.setChecked(false);
        checkAgua.setChecked(false);
        checkTelefone.setChecked(false);
        checkCelular.setChecked(false);
    }

}
