package id.sch.smktelkom_mlg.tugas01.xirpl1019.formregistrasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText nama;
    EditText umur;
    RadioButton rpl, tkj;
    Button checkout;
    Spinner kelas;
    RadioGroup jurusan;
    CheckBox asp, oracle, android, java;
    TextView hasil, judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.nama);
        umur = (EditText) findViewById (R.id.umur);
        rpl = (RadioButton) findViewById(R.id.rpl);
        tkj = (RadioButton) findViewById(R.id.tkj);
        checkout = (Button) findViewById(R.id.checkout);
        kelas = (Spinner) findViewById(R.id.kelas);
        jurusan = (RadioGroup) findViewById(R.id.jurusan);
        asp = (CheckBox) findViewById(R.id.asp);
        oracle = (CheckBox) findViewById(R.id.oracle);
        android = (CheckBox) findViewById(R.id.android);
        java = (CheckBox) findViewById(R.id.java);
        asp.setOnCheckedChangeListener(this);
        oracle.setOnCheckedChangeListener(this);
        android.setOnCheckedChangeListener(this);
        hasil = (TextView) findViewById(R.id.hasil);
        judul = (TextView) findViewById(R.id.judul);

    checkout.setOnClickListener(new View.OnClickListener(){
     @Override
        public void onClick(View view){
            doClick();
        }
    });
    }

    private void doClick()
    {
        String jurusan1 = tkj.getText().toString(); rpl.getText().toString();
        String nama1 = nama.getText().toString();
        String umur1 = umur.getText().toString();
        String minat = "";
        String kelas1 = kelas.getSelectedItem().toString();
        int startlen = hasil.length();

        if(rpl.isChecked()){
            jurusan1 += rpl.getText().toString();}
        else if  (tkj.isChecked()){
            jurusan1 += tkj.getText().toString();}
        else {jurusan1 += "Tambahkan jurusan Anda";}

         if(asp.isChecked()) {minat += asp.getText()+"";}
        else if(oracle.isChecked()) {minat += oracle.getText()+"";}
        else if (android.isChecked()){minat += android.getText()+"";}
         else if(java.isChecked()) {minat += java.getText()+"";}
        else  {minat += "Tambahkan minat Anda";}


        if(jurusan.getCheckedRadioButtonId() != -1){
            RadioButton rb = (RadioButton)
                    findViewById(jurusan.getCheckedRadioButtonId());
            jurusan1 = rb.getText().toString();
        }

        if(nama1.isEmpty()){
            nama.setError("Nama belum diisi");
        } else {nama.setError(null);}

        if(umur1.isEmpty()){
            umur.setError("Umur belum diisi");
        } else {umur.setError(null);}

        hasil.setText(nama1 + " siswa berumur " + umur1 + " tahun, kelas " + kelas1 + " telah terdaftar di kelas Visionet dengan minat " + minat + " untuk standar " +jurusan1);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}