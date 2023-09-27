package com.example.ejemplonavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarUsuario extends AppCompatActivity {

    EditText camp1, camp2, camp3, camp4, camp5, camp6, camp7, camp8, camp9, camp10, camp11, camp12, camp13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario);

        camp1 = (EditText)findViewById(R.id.txtNom_Usu);
        camp2 = (EditText)findViewById(R.id.txtApe_Usu);
        camp3 = (EditText)findViewById(R.id.txtCed_Usu);
        camp4 = (EditText)findViewById(R.id.txtNac_Usu);
        camp5 = (EditText)findViewById(R.id.txtCel_Usu);
        camp6 = (EditText)findViewById(R.id.txtEml_Usu);
        camp7 = (EditText)findViewById(R.id.txtBar_Usu);
        camp8 = (EditText)findViewById(R.id.txtCiu_Usu);
        camp9 = (EditText)findViewById(R.id.txtDep_Usu);
        camp10 = (EditText)findViewById(R.id.txtDir_Usu);
        camp11 = (EditText)findViewById(R.id.txtApa_Usu);
        camp12 = (EditText)findViewById(R.id.txtUsu_Usu);
        camp13 = (EditText)findViewById(R.id.txtCon_Usu);
    }

    public boolean validar() {
        boolean retorno = true;

        String nomb;
        String apel;
        String cedu;
        String naci;
        String celu;
        String emai;
        String barr;
        String ciud;
        String depa;
        String dire;
        String apar;
        String usua;
        String cont;

        nomb = camp1.getText().toString();
        apel = camp2.getText().toString();
        cedu = camp3.getText().toString();
        naci = camp4.getText().toString();
        celu = camp5.getText().toString();
        emai = camp6.getText().toString();
        barr = camp7.getText().toString();
        ciud = camp8.getText().toString();
        depa = camp9.getText().toString();
        dire = camp10.getText().toString();
        apar = camp11.getText().toString();
        usua = camp12.getText().toString();
        cont = camp13.getText().toString();

        if (nomb.isEmpty()) {
            camp1.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (apel.isEmpty()) {
            camp2.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (cedu.isEmpty()) {
            camp3.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (naci.isEmpty()) {
            camp4.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (celu.isEmpty()) {
            camp5.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (emai.isEmpty()) {
            camp6.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (barr.isEmpty()) {
            camp7.setError("Este campo no puede quedar vacio");
        } if (ciud.isEmpty()) {
            camp8.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (depa.isEmpty()) {
            camp9.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (dire.isEmpty()) {
            camp10.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (apar.isEmpty()) {
            camp11.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (usua.isEmpty()) {
            camp12.setError("Este campo no puede quedar vacio");
            retorno = false;
        } if (cont.isEmpty()) {
            camp13.setError("Este campo no puede quedar vacio");
            retorno = false;
        }
        return retorno;
    }

    public void Cambio (View view) {
        if (validar()) {
            Toast.makeText(this, "Datos agregados", Toast.LENGTH_SHORT).show();
            Intent Cambiar = new Intent(this, IniciarSesion.class);
            startActivity(Cambiar);
        }
    }



}
