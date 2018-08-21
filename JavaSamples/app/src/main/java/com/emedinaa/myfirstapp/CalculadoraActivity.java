package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextOp1;
    private EditText editTextOp2;
    private TextView tviOp;

    private View iviSum,iviSubtract,iviMultiply,iviDivide;

    private int op1,op2;
    private double op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ui();
    }

    private void ui() {

        editTextOp1=findViewById(R.id.editTextOp1);
        editTextOp2= findViewById(R.id.editTextOp2);
        tviOp= findViewById(R.id.tviOp);

        iviSum= findViewById(R.id.iviSum);
        iviSubtract= findViewById(R.id.iviSubtract);
        iviMultiply= findViewById(R.id.iviMultiply);
        iviDivide= findViewById(R.id.iviDivide);

        iviSum.setOnClickListener(this);
        iviSubtract.setOnClickListener(this);
        iviMultiply.setOnClickListener(this);
        iviDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.v("CONSOLE", "click");

        //TODO capturar valores
        String mOp1=editTextOp1.getText().toString();
        String mOp2=editTextOp2.getText().toString();

        if(mOp1.isEmpty()|| mOp2.isEmpty())return;
        op1= Integer.parseInt(mOp1);
        op2= Integer.parseInt(mOp2);

        Log.v("CONSOLE", "op1 "+op1+ " op2 : "+op2);

        //TODO operaciones
        switch (v.getId())
        {
            case R.id.iviSum:
                    op=sumar(op1,op2);

                Log.v("CONSOLE", "op "+op);
                break;

            case R.id.iviSubtract:
                    op=restar(op1,op2);
                break;

            case R.id.iviMultiply:
                    op=multiplicar(op1, op2);
                break;

            case R.id.iviDivide:
                    op=dividir(op1,op2);
                break;

        }
        //TODO mostrar resultados
        tviOp.setText("Resultado " + op);

    }

    private int sumar(int op1, int op2) {
        return op1+op2;
    }
    private int restar(int op1, int op2) {
        return op1-op2;
    }
    private int multiplicar(int op1, int op2) {
        return op1*op2;
    }
    private double dividir(int op1, int op2) {
        //TODO validar si op2!=0
        return (op1*1.0/op2);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
