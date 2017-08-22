package belajar.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//import belajar.quiz.R;

public class Result extends AppCompatActivity {
    Boolean jawaban1;
    Boolean jawaban2;
    Boolean jawaban3;
    Boolean jawaban4;
    Boolean jawaban5;
    double skor;
    int count;
//    Boolean hasil[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle jawaban = getIntent().getExtras();
        jawaban1 = jawaban.getBoolean("jawaban1");
        jawaban2 = jawaban.getBoolean("jawaban2");
        jawaban3 = jawaban.getBoolean("jawaban3");
        jawaban4 = jawaban.getBoolean("jawaban4");
        jawaban5 = jawaban.getBoolean("jawaban5");

        TextView txt = (TextView) findViewById(R.id.result1);
        txt.setText("Jumlah Soal Yang Berhasil Dijawab : "+"\n"+String.valueOf(result())+"/5");
        skor = (double)(result()*100)/5;
        TextView t = (TextView) findViewById(R.id.skor);
        t.setText("Skor : "+(String.valueOf(skor)));

    }



    public int result(){

        count = 0;
        Boolean hasil[]={jawaban1,jawaban2,jawaban3,jawaban4,jawaban5};
        for(int i = 0;i<hasil.length;i++){
            if(hasil[i]){

                count++;
            }
        }
        return count;
    }

    public void exit(View view) {
        this.finish();
    }
}
