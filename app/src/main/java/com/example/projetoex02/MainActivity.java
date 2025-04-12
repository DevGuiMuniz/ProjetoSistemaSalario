package com.example.projetoex02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editSalario;
    RadioGroup radioGroup;
    RadioButton rbOpcao1, rbOpcao2, rbOpcao3;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     
        editSalario = findViewById(R.id.editSalario);
        radioGroup = findViewById(R.id.radioGroup);
        rbOpcao1 = findViewById(R.id.rbOpcao1);
        rbOpcao2 = findViewById(R.id.rbOpcao2);
        rbOpcao3 = findViewById(R.id.rbOpcao3);
        textResultado = findViewById(R.id.textResultado);
    }

    public void enviar(View view) {
        String salarioTexto = editSalario.getText().toString();

        if (salarioTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, digite o salário.", Toast.LENGTH_SHORT).show();
            return;
        }

        double salario = Double.parseDouble(salarioTexto);
        double percentual = 0;

        if (rbOpcao1.isChecked()) {
            percentual = 0.40;
        } else if (rbOpcao2.isChecked()) {
            percentual = 0.45;
        } else if (rbOpcao3.isChecked()) {
            percentual = 0.50;
        } else {
            Toast.makeText(this, "Selecione um percentual.", Toast.LENGTH_SHORT).show();
            return;
        }

        double novoSalario = salario + (salario * percentual);
        textResultado.setText(String.format("Novo Salário: R$ %.2f", novoSalario));
    }
}
