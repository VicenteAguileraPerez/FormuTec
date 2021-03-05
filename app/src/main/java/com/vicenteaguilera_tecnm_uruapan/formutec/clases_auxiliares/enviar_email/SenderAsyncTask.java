package com.vicenteaguilera_tecnm_uruapan.formutec.clases_auxiliares.enviar_email;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.vicenteaguilera_tecnm_uruapan.formutec.layouts.layouts_secundarias.QuejasSugerenciasActivity;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SenderAsyncTask extends AsyncTask<String, String, String>
{
    private String from, to, message;
    private ProgressDialog progressDialog;
    private Session session;
    @SuppressLint("StaticFieldLeak")
    private QuejasSugerenciasActivity quejasSugerenciasActivity;
    private String nombre;
    private  boolean tipo;

    public SenderAsyncTask(Session session, String from, String to, String message, QuejasSugerenciasActivity quejasSugerenciasActivity, String nombre, boolean tipo) {
        this.session = session;
        this.from = from;
        this.to = to;

        this.message = message;
        this.quejasSugerenciasActivity = quejasSugerenciasActivity;
        this.nombre=nombre;
        this.tipo=tipo;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(quejasSugerenciasActivity, "Enviando", "Espere", true);
        progressDialog.setCancelable(false);
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            String tipo = (this.tipo)?"Queja":"Sugerencia";

            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from,"FormuTec"));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject("Gracias por ayudarnos a mejorar FormuTec");
            String htmlText2 = "<p ALIGN=\"center\"><img  width=\"200\" height=\"200\" src=\"https://firebasestorage.googleapis.com/v0/b/formutec-formutec.appspot.com/o/FormutecNAME%20-%20Logo%202.2.png?alt=media&token=ba243cd2-c05e-4bfc-add6-c4b7df270255\"></p>";
            String htmlText =
                    "<body> " +
                            "<h4><font size=3 face=\"Sans Serif,arial,verdana\">Hola, </font></h4> " +
                            "<br>"+
                            htmlText2+
                            "<hr>" +
                            "<p ALIGN=\"justify\"><font size=3 face=\"Sans Serif,arial,verdana\">"+"Agradecemos tu colaboración <strong>"+nombre+
                            "</strong> evaluaremos la petición y tendremos pronta respuesta a tu petición"+"</font></p>"+
                            "<p ALIGN=\"justify\"><font size=3 face=\"Sans Serif,arial,verdana\">Saludos cordiales,</font></p>"+
                            "<p><font size=3 face=\"Sans Serif,arial,verdana\">El equipo </font><font color=\"#2B53A3\" size=3 face=\"Sans Serif,arial,verdana\">FormuTec</font></p>"+
                            "<br>"+
                            "<hr>"+

                            "<footer>"+
                            "<p><font color=\"#C5BFBF\" size=2 face=\"Sans Serif,arial,verdana\">Gracias!!</font></p>"+
                            "<p ALIGN=\"justify\"><font color=\"#C5BFBF\" size=1 face=\"Sans Serif,arial,verdana\">©FormuTec from Instituto Tecnológico Superior de Uruapan, Carretera Uruapan-Carapan No. 5555 Col. La Basilia Uruapan, Michoacán. Este correo fue enviado para: "+to+" y fue enviado por</font> </font><font color=\"#2B53A3\" size=1 face=\"Sans Serif,arial,verdana\">FormuTec</font> </p>"+
                            "</footer>"+
                            "</body>";




            mimeMessage.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(mimeMessage);

            Message mimeMessage2 = new MimeMessage(session);
            mimeMessage2.setFrom(new InternetAddress(from));
            mimeMessage2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(from));
            mimeMessage2.setSubject(tipo);

            String htmlText3 = "<body> " +
                    "<hr>" +
                    "<p ALIGN=\"justify\"><font size=3 face=\"Sans Serif,arial,verdana\">"+"Petición de <strong>"+nombre+" "+to+
                    "</strong>, la cual menciona que("+tipo+"): "+"</font></p>"+
                    "<p ALIGN=\"center\"><font size=3 face=\"Sans Serif,arial,verdana\">"+message+"</font></p>"+
                    "<p><font size=3 face=\"Sans Serif,arial,verdana\">El equipo </font><font color=\"#2B53A3\" size=3 face=\"Sans Serif,arial,verdana\">FormuTec</font></p>"+
                    "<br>"+
                    "<hr>"+

                    "<footer>"+
                    "<p><font color=\"#C5BFBF\" size=2 face=\"Sans Serif,arial,verdana\">Gracias!!</font></p>"+
                    "<p ALIGN=\"justify\"><font color=\"#C5BFBF\" size=1 face=\"Sans Serif,arial,verdana\">©FormuTec from Instituto Tecnológico Superior de Uruapan, Carretera Uruapan-Carapan No. 5555 Col. La Basilia Uruapan, Michoacán.</font></p>"+
                    "</footer>"+
                    "</body>";

            mimeMessage2.setContent(htmlText3, "text/html; charset=utf-8");

            Transport.send(mimeMessage2);
        } catch (Exception e) {
            Toast.makeText(quejasSugerenciasActivity,"Correo electrónico invalido",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        Toast.makeText(quejasSugerenciasActivity, "Mensaje se ha enviado satisfactoriamente", Toast.LENGTH_LONG).show();

    }
}
