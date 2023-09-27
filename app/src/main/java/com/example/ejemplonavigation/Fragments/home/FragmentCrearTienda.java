package com.example.ejemplonavigation.Fragments.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejemplonavigation.R;
import com.example.ejemplonavigation.databinding.FragmentCrearTiendaBinding;

import org.json.JSONObject;

public class FragmentCrearTienda extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    EditText campoDocumento, campoNombre, campoProfesion;
    Button botonRegistro;

    private TextView text_respuesta;
    ProgressDialog  progreso;

    RequestQueue   request;
    JsonObjectRequest jsonObjectRequest;

    private FragmentCrearTiendaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_crear_tienda, container, false);
        campoDocumento = (EditText) vista.findViewById(R.id.campoDoc);
        campoNombre = (EditText) vista.findViewById(R.id.campoNombre);
        campoProfesion = (EditText) vista.findViewById(R.id.campoProfesion);
        botonRegistro = (Button) vista.findViewById(R.id.btnRegistrar);

        request = Volley.newRequestQueue(getContext());

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();
            }
        });

        return vista;
    }

    private void cargarWebService() {

        progreso =  new ProgressDialog(getContext());
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://192.168.1.8/EjemploBDRemota/wsJSONRegistro.php?documento="+campoDocumento.getText().toString()+
                "&nombre="+campoNombre.getText().toString()+"&profesion="+campoProfesion.getText().toString();

        url = url.replace(" ","%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se ha registrado correctamente", Toast.LENGTH_LONG).show();
        progreso.hide();
        campoDocumento.setText("");
        campoNombre.setText("");
        campoProfesion.setText("");
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        //text_respuesta = text_respuesta.findViewById(R.id.respuesta);

        progreso.hide();
        Toast.makeText(getContext(), "No se pudo registrar " + error.toString(), Toast.LENGTH_LONG).show();
        Log.i("Error", error.toString());
        //text_respuesta.setText("" + error);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}