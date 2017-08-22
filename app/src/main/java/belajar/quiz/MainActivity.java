package belajar.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText email;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        cb = (CheckBox) findViewById(R.id.term);
    }

    public void login(View view) {


        if (!user.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && cb.isChecked()) {
            Intent i = new Intent(MainActivity.this, Quis1.class);
            MainActivity.this.startActivity(i);
            MainActivity.this.finish();
        } else {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            alertDialogBuilder.setMessage("Isi Username dan Email dan klik Agree")
                    .setCancelable(true)
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();

            // menampilkan alert dialog
            alertDialog.show();

        }
    }
}
