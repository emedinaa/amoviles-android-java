package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CalculadoraBaseA";
    private EditText editTextOp1;
    private EditText editTextOp2;
    private TextView tviOp;

    private View iviSum,iviSubtract,iviMultiply,iviDivide;

    private int op1,op2;
    double op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ui();
    }

    private void ui() {

        editTextOp1= (EditText)findViewById(R.id.editTextOp1);
        editTextOp2= (EditText)findViewById(R.id.editTextOp2);
        tviOp= (TextView)findViewById(R.id.tviOp);

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

        //TODO capturar valores
        String mOp1= editTextOp1.getText().toString().trim();
        String mOp2= editTextOp2.getText().toString().trim();

        Log.d("CONSOLE", "mop1 "+mOp1);
        Log.d("CONSOLE", "mop2 "+mOp2);
        if(mOp1.isEmpty() || mOp2.isEmpty())return;

        op1= Integer.parseInt(mOp1);
        op2= Integer.parseInt(mOp2);
        //if(op2==0)return;

        //TODO operaciones
        switch (v.getId())
        {
            case R.id.iviSum:
                Log.v(TAG, "sumar");
                op= op1+op2;
                break;

            case R.id.iviSubtract:
                Log.v(TAG, "restar");
                op= op1-op2;
                break;

            case R.id.iviMultiply:
                Log.v(TAG, "multiplicar");
                op= op1*op2;
                break;

            case R.id.iviDivide:
                Log.v(TAG, "dividir");
                if(op2>0){
                    op= op1/(op2*1.0);
                }else{
                    op=0;
                }
                break;
        }

        //TODO mostrar resultados
        Log.d("CONSOLE", "op "+op);
        tviOp.setText("Resultado : "+op);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
