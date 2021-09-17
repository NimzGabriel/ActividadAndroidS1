package g.gomez.actividadandroids1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import g.gomez.actividadandroids1.classes.RecetaPizza;

public class FormActivity extends AppCompatActivity {

    float precio;
    public static ArrayList<RecetaPizza> recetasArrayList = new ArrayList<>();
    Button buttonVolver, buttonGuardar;
    EditText textReceta;
    RadioGroup radioGroupPrincipal, radioGroupBase;
    CheckBox checkBoxCebolla, checkBoxChampinion, checkBoxCherry,
             checkBoxMorron, checkBoxTomate, checkBoxPalta, checkBoxAjo,
             checkBoxAlbaca, checkBoxOregano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Buttons
        buttonVolver = findViewById(R.id.buttonVolver);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        // text
        textReceta = findViewById(R.id.textReceta);
        // RadioGroups
        radioGroupPrincipal = findViewById(R.id.radioGroupPrincipal);
        radioGroupBase = findViewById(R.id.radioGroupBase);
        // CheckBoxs
        checkBoxCebolla = findViewById(R.id.checkBoxCebolla);
        checkBoxChampinion = findViewById(R.id.checkBoxChampinion);
        checkBoxCherry = findViewById(R.id.checkBoxCherry);
        checkBoxMorron = findViewById(R.id.checkBoxMorron);
        checkBoxTomate = findViewById(R.id.checkBoxTomate);
        checkBoxPalta = findViewById(R.id.checkBoxPalta);
        // -------
        checkBoxAjo = findViewById(R.id.checkBoxAjo);
        checkBoxAlbaca = findViewById(R.id.checkBoxAlbaca);
        checkBoxOregano = findViewById(R.id.checkBoxOregano);
    }

    public void goHome(View view) {
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void saveInfo(View view) {
        String nombreReceta = textReceta.getText().toString();

        // Principal
        int principalId = radioGroupPrincipal.getCheckedRadioButtonId();
        RadioButton radioButtonPrincipal = findViewById(principalId);
        String principal = radioButtonPrincipal.getText().toString();
        if(principal.equals("Carne") || principal.equals("Pollo")) {
            precio += 1500;
        } else {
            precio += 2000;
        }

        // Base
        int baseId = radioGroupBase.getCheckedRadioButtonId();
        RadioButton radioButtonBase = findViewById(baseId);
        String base = radioButtonBase.getText().toString();
        if(base.equals("Roja") || base.equals("Blanca")) {
            precio += 500;
        }

        // Ingredientes
        ArrayList<String> ingredientes = new ArrayList<String>();
        if(checkBoxCebolla.isChecked()) {
            ingredientes.add(checkBoxCebolla.getText().toString());
            precio += 1000;
        }
        if(checkBoxChampinion.isChecked()) {
            ingredientes.add(checkBoxChampinion.getText().toString());
            precio += 1000;
        }
        if(checkBoxCherry.isChecked()) {
            ingredientes.add(checkBoxCherry.getText().toString());
            precio += 1000;
        }
        if(checkBoxMorron.isChecked()) {
            ingredientes.add(checkBoxMorron.getText().toString());
            precio += 1000;
        }
        if(checkBoxTomate.isChecked()) {
            ingredientes.add(checkBoxTomate.getText().toString());
            precio += 1000;
        }
        if(checkBoxPalta.isChecked()) {
            ingredientes.add(checkBoxPalta.getText().toString());
            precio += 1000;
        }

        // ------
        ArrayList<String> alinios = new ArrayList<String>();
        if(checkBoxAjo.isChecked()) {
            alinios.add(checkBoxAjo.getText().toString());
            precio += 500;
        }
        if(checkBoxAlbaca.isChecked()) {
            alinios.add(checkBoxAlbaca.getText().toString());
            precio += 500;
        }
        if(checkBoxOregano.isChecked()) {
            alinios.add(checkBoxOregano.getText().toString());
            precio += 500;
        }

        if(nombreReceta.isEmpty()) {
            Toast.makeText(this, "No se pudo añadir porque le falta nombre a la receta.", Toast.LENGTH_LONG).show();
        } else {
            if(ingredientes.isEmpty() || alinios.isEmpty()) {
                Toast.makeText(this, "No se pudo añadir, debes seleccionar 1 ingrediente y 1 aliño como minimo.", Toast.LENGTH_LONG).show();
            } else {
                RecetaPizza receta = new RecetaPizza(nombreReceta, principal, base, ingredientes, alinios, precio);
                recetasArrayList.add(receta);
                Toast.makeText(this, "Receta añadida exitosamente.", Toast.LENGTH_LONG).show();
            }
        }
        precio = 0;
    }
}