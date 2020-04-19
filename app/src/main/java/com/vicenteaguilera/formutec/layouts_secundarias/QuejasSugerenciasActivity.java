package com.vicenteaguilera.formutec.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import javax.mail.Session;
import com.vicenteaguilera.formutec.Auxiliar.SenderAsyncTask;
import com.vicenteaguilera.formutec.Auxiliar.StaticsMenus;
import com.vicenteaguilera.formutec.R;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class QuejasSugerenciasActivity extends AppCompatActivity {

    EditText editText_nombre,editText_email,editText_mensaje;
    RadioButton radioButton_queja,radioButton_sugerencia;
    Button button_enviar;

    String nombre, email, mensaje;
    boolean tipo;
    private  int REQUEST_ACCESS_FINE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quejas_sugerencias);
        setTitle(R.string.quejas_y_sugerencias);
        editText_email = findViewById(R.id.editText_email);
        editText_mensaje = findViewById(R.id.editText_mensaje);
        editText_nombre = findViewById(R.id.editText_nombre);
        radioButton_queja = findViewById(R.id.radioButton_queja);
        radioButton_sugerencia = findViewById(R.id.radioButton_sugerencia);

        button_enviar = findViewById(R.id.button_enviar);

        button_enviar.setOnClickListener(view ->
        {
            nombre = editText_nombre.getText().toString();
            email = editText_email.getText().toString();
            mensaje = editText_mensaje.getText().toString();
            tipo=evaluarEmail(email);
            if(tipo)
            {
                if (!nombre.equals("")  && !mensaje.equals(""))
                {
                    if (radioButton_sugerencia.isChecked() || radioButton_queja.isChecked())
                    {
                        tipo = radioButton_queja.isChecked() ? true : false;
                        sendEmailWithGmail(email, mensaje, nombre, tipo);
                        cleanCasillas();
                    }
                    else {
                        Toast.makeText(QuejasSugerenciasActivity.this, "Tiene que seleccionar queja o sugerencia", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(QuejasSugerenciasActivity.this, "Nombre o mensaje están vacíos", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(QuejasSugerenciasActivity.this, "el correo debe ser de tipo gmail \"...@gmail.com\"", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void sendEmailWithGmail(String to, String message,String nombre, boolean tipo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(StaticsMenus.EMAILSENDER, StaticsMenus.PASSWORD);
            }
        });

        SenderAsyncTask task = new SenderAsyncTask(session,StaticsMenus.EMAILSENDER,to,message,QuejasSugerenciasActivity.this,nombre,tipo);
        task.execute();
    }
    private boolean evaluarEmail(String email)
    {
        String vectorEmail[] = email.split("@");
        boolean bandera;
        if(vectorEmail.length==2)
        {
            if(vectorEmail[1].equals("gmail.com"))
            {
                bandera=true;
                Log.e("1","1"+bandera);
            }
            else
            {
                bandera=false;
                Log.e("1","2"+bandera);
            }
        }
        else
        {
            bandera=false;
            Log.e("1","3"+bandera);
        }
        return bandera;

    }
    private  void cleanCasillas()
    {
        editText_nombre.setText("");
        editText_email.setText("");
        editText_mensaje.setText("");
        radioButton_queja.setChecked(false);
        radioButton_sugerencia.setChecked(false);
    }
}
