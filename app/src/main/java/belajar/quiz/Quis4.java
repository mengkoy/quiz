package belajar.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static belajar.quiz.R.id.radioGroup;

public class Quis4 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Boolean jawaban1;
    Boolean jawaban2;
    Boolean jawaban3;
    boolean jawaban4;

    RadioGroup rg;
    RadioButton rd1;
    RadioButton rd2;
    RadioButton rd3;
    RadioButton rd4;
    RadioButton rd5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quis4);

        rg = (RadioGroup) findViewById(radioGroup);
        rd1 = (RadioButton) findViewById(R.id.jawaban1);
        rd2 = (RadioButton) findViewById(R.id.jawaban2);
        rd3 = (RadioButton) findViewById(R.id.jawaban3);
        rd4 = (RadioButton) findViewById(R.id.jawaban4);
        rd5 = (RadioButton) findViewById(R.id.jawaban5);

        Bundle jawaban = getIntent().getExtras();
        jawaban1 = jawaban.getBoolean("jawaban1");
        jawaban2 = jawaban.getBoolean("jawaban2");
        jawaban3 = jawaban.getBoolean("jawaban3");
        rg.setOnCheckedChangeListener(this);
    }
    public void next(View view) {
        if (rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked() || rd5.isChecked()) {
            Intent i = new Intent(this, Quis5.class);
            Bundle jawaban = new Bundle();
            jawaban.putBoolean("jawaban1",jawaban1);
            jawaban.putBoolean("jawaban2",jawaban2);
            jawaban.putBoolean("jawaban3",jawaban3);
            jawaban.putBoolean("jawaban4",jawaban4);
            i.putExtras(jawaban);
            startActivity(i);
            finish();
        } else {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            alertDialogBuilder.setMessage("Soal belum dijawab")
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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (checkedId == R.id.jawaban1) {
            jawaban4 = true;
        }
        if (checkedId == R.id.jawaban2) {
            jawaban4 = false;
        }
        if (checkedId == R.id.jawaban3) {
            jawaban4 = false;
        }
        if (checkedId == R.id.jawaban4) {
            jawaban4 = false;
        }
        if (checkedId == R.id.jawaban5) {
            jawaban4 = false;
        }
    }
}
