package com.example.faculdade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://swapi.co/api/people/1/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.length() > 0) {

                    try {

                        TextView AnoNascimentoTextView = null;
                        TextView CorDosOlhosTextView = null;
                        TextView GeneroTextView = null;
                        TextView CorDoCabeloTextView = null;

                        String resposta = response;

                        JSONObject jsonObject = new JSONObject(resposta);

                        String AnoNascimento = String.valueOf(jsonObject.get("birth_year"));
                        String CorDosOlhos = String.valueOf(jsonObject.get("eye_color"));
                        String Genero = String.valueOf(jsonObject.get("gender"));
                        String CorDoCabelo = String.valueOf(jsonObject.get("hair_color"));

                        Pessoa p = new Pessoa();

                        p.setAnoNascimento(AnoNascimento);
                        p.setCorDosOlhos(CorDosOlhos);
                        p.setGenero(Genero);
                        p.setCorDoCabelo(CorDoCabelo);

                        List<Pessoa> lista = new ArrayList<>();

                        lista.add(p);

                        ListView mostrarDados;

                        HashMap<String, String> map = new HashMap<>();

                        List<HashMap<String, String>> hashMaps = new ArrayList<>();

                        for (int c = 0; c < lista.size(); c++) {

                            map.put("AnoNascimento", p.getAnoNascimento());
                            map.put("CorDosOlhos", p.getCorDosOlhos());
                            map.put("Genero", p.getGenero());
                            map.put("CorDoCabelo", p.getCorDoCabelo());

                            hashMaps.add(map);
                        }

                        String[] de = {"AnoNascimento", "CorDosOlhos", "Genero", "CorDoCabelo"};
                        int[] para = {R.id.AnoNascimento, R.id.CorDosOlhos, R.id.Genero, R.id.CorDoCabelo};

                        mostrarDados = findViewById(R.id.mostrardados);

                        //SIMPLE ADAPTER
                        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), hashMaps, R.layout.englobadados, de, para);

                        mostrarDados.setAdapter(adapter);


                    } catch (JSONException jsonException) {

                        jsonException.printStackTrace();

                    }

                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }

        });

        requestQueue.add(stringRequest);


    }
}
