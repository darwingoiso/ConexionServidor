package com.example.android.ejemconexinternet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    //Intanciar la svariables de los elemntos
    EditText user,password;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.editText);
        password=(EditText) findViewById(R.id.editText2);
        enviar=(Button) findViewById(R.id.button);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logeo();


            }
        });
    }
    public void Logeo(){
        AsyncHttpClient cliente=new AsyncHttpClient();
        RequestParams datos=new RequestParams();
        datos.put("usuario",user.getText().toString());
        datos.put("password",password.getText().toString());

        cliente.post(getApplicationContext(),"http://www.programadoresperuanos.com/prueba.php",datos, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp = new String(responseBody);
                if(resp.equals("verdadero")){
                    Intent open= new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(open);
                }else{
                    Toast.makeText(getApplicationContext(),"Datos Falsos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),"Sin Conexional Servidor",Toast.LENGTH_LONG).show();
            }
        });
    }
}
