package com.juaracoding.tutorialrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView lstData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstData = findViewById(R.id.lstdata);
                setList();
    }

    public void setList(){
        recycleadapter itemArrayAdapter = new recycleadapter(createDataModel());
        lstData.setLayoutManager(new LinearLayoutManager(this));
        lstData.setItemAnimator(new DefaultItemAnimator());
        lstData.setAdapter(itemArrayAdapter);
    }
    public ArrayList<TemplateModel> createDataModel() {
        ArrayList<TemplateModel> dataDummy = new ArrayList<TemplateModel>();

        TemplateModel model = new TemplateModel();
        model.setTipe(recycleadapter.TIPE_UI_PERTAMA);
        model.setTxtnama("DWI SAMSARI");
        model.setTxtalamat("TAMPAN DAN BERANI");
        model.setTxttanggal("29 MARET 1997");
        model.setGambarbiodata("");

        dataDummy.add(model);

        model = new TemplateModel();
        model.setTipe(recycleadapter.TIPE_UI_KEDUA);
        model.setTxt1("GATOT");
        model.setTxt2("TAMBUNAN");
        model.setTxt3("HAHAHAHAHA");

        dataDummy.add(model);

        model = new TemplateModel();
        model.setTipe(recycleadapter.TIPE_UI_KETIGA);
        model.setGambar("");

        dataDummy.add(model);

        model = new TemplateModel();
        model.setTipe(recycleadapter.TIPE_UI_KEEMPAT);
        model.setGambar1("");
        model.setGambar2("");
        model.setGambar3("");


        dataDummy.add(model);
        return dataDummy;
    }
}

