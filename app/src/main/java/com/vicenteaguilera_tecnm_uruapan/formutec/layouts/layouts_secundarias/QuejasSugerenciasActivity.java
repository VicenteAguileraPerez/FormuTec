package com.vicenteaguilera_tecnm_uruapan.formutec.layouts.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import javax.mail.Session;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.vicenteaguilera_tecnm_uruapan.formutec.clases_auxiliares.enviar_email.SenderAsyncTask;
import com.vicenteaguilera_tecnm_uruapan.formutec.clases_auxiliares.recursos_estaticos.StaticsMenus;
import com.vicenteaguilera_tecnm_uruapan.formutec.R;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class QuejasSugerenciasActivity extends AppCompatActivity {

    private String EXREGEMAIL="([a-z,0-9]+((\\.|_|-)[a-z0-9]+)*)@([a-z,0-9]+(\\.[a-z0-9]+)*)\\.([a-z]{2,})(\\.([a-z]{2}))?";
    private TextInputLayout editText_nombre,editText_email,editText_mensaje;
    private RadioButton radioButton_queja,radioButton_sugerencia;
    private MaterialButton button_enviar;

    private String nombre, email, mensaje;
    boolean tipo;

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
        textWachers();
        button_enviar = findViewById(R.id.button_enviar);
        button_enviar.setOnClickListener(view ->
        {
            nombre = editText_nombre.getEditText().getText().toString();
            email = editText_email.getEditText().getText().toString();
            mensaje = editText_mensaje.getEditText().getText().toString();
            tipo=evaluarEmailPattern(email);
            if(tipo)
            {
                if (!nombre.equals("")  && !mensaje.equals(""))
                {
                    if (radioButton_sugerencia.isChecked() || radioButton_queja.isChecked())
                    {
                        tipo = radioButton_queja.isChecked();
                        sendEmailWithGmail(email, mensaje, nombre, tipo);
                        cleanCasillas();
                    }
                    else {
                        Snackbar.make(view, "Tiene que seleccionar queja o sugerencia", Snackbar.LENGTH_SHORT).show();
                    }
                }
                else {
                    Snackbar.make(view, "Nombre o mensaje están vacíos", Snackbar.LENGTH_SHORT).show();
                }
            }
            else
            {
                Snackbar.make(view, "Eso no es una dirección de email", Snackbar.LENGTH_SHORT).show();
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
    public boolean evaluarEmailPattern(String email)
    {
        return Pattern.matches(EXREGEMAIL,email);
    }
    @Deprecated
    private boolean evaluarEmail(String email)
    {
        String[] vectorEmail = email.split("@");
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
        editText_nombre.getEditText().setText("");
        editText_email.getEditText().setText("");
        editText_mensaje.getEditText().setText("");
        editText_mensaje.setError(null);
        editText_email.setError(null);
        editText_nombre.setError(null);
        radioButton_queja.setChecked(false);
        radioButton_sugerencia.setChecked(false);
    }
    private void textWachers()
    {
        editText_email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!evaluarEmailPattern(charSequence.toString()))
                {
                    editText_email.setError("Eso no es un email");
                }
                else
                {
                    editText_email.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText_nombre.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText_nombre.getEditText().getText().length()==0)
                {
                    editText_nombre.setError("Campo vacío");
                }
                else
                {
                    editText_nombre.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText_mensaje.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText_mensaje.getEditText().getText().length()==0)
                {
                    editText_mensaje.setError("Campo vacío");
                }
                else
                {
                    editText_mensaje.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
