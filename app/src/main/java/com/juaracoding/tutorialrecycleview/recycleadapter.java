package com.juaracoding.tutorialrecycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TemplateModel> dataItemList;

    public static int TIPE_UI_PERTAMA = 0;
    public static int TIPE_UI_KEDUA =1;
    public static int TIPE_UI_KETIGA=2;
    public static int TIPE_UI_KEEMPAT=3;

    public recycleadapter(ArrayList<TemplateModel> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TIPE_UI_PERTAMA){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_biodata, parent, false);
            Penampung penampung = new Penampung(view);
            return penampung;
        }else if (viewType == TIPE_UI_KEDUA){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_full_text, parent, false);
            Penampung2 penampung2 = new Penampung2(view);
            return penampung2;
        }else if (viewType == TIPE_UI_KETIGA){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_full_image, parent, false);
            Penampung3 penampung3= new Penampung3(view);
            return penampung3;
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiga_image, parent, false);
            Penampung4 penampung4= new Penampung4(view);
            return penampung4;
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (dataItemList.get(position).getTipe()==0 ){
            return TIPE_UI_PERTAMA;
        }else if (dataItemList.get(position).getTipe()==1){
            return TIPE_UI_KEDUA;
        }else if (dataItemList.get(position).getTipe()==2){
            return TIPE_UI_KETIGA;
        }else{
            return TIPE_UI_KEEMPAT;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Penampung){
            TextView txtNama = ((Penampung)holder).txtNama;
            TextView txtAlamat = ((Penampung)holder).txtAlamat;
            TextView txtTanggal = ((Penampung)holder).txtTanggal;
            txtNama.setText(dataItemList.get(position).getTxtnama());
            txtAlamat.setText(dataItemList.get(position).getTxtalamat());
            txtTanggal.setText(dataItemList.get(position).getTxttanggal());
            ImageView gbrbiodata =  ((Penampung)holder).gbrbiodata;
        }else if (holder instanceof Penampung2){
            TextView txtsatu = ((Penampung2)holder).txtsatu;
            TextView txtdua = ((Penampung2)holder).txtdua;
            TextView txttiga = ((Penampung2)holder).txttiga;
            txtsatu.setText(dataItemList.get(position).getTxt1());
            txtdua.setText(dataItemList.get(position).getTxt2());
            txttiga.setText(dataItemList.get(position).getTxt3());
        }else if (holder instanceof Penampung3){
            ImageView imageView =  ((Penampung3)holder).imageView;
        }else if (holder instanceof Penampung4){
            ImageView imageView1 =  ((Penampung4)holder).imageView1;
            ImageView imageView2 =  ((Penampung4)holder).imageView2;
            ImageView imageView3 =  ((Penampung4)holder).imageView3;
        }

    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }


    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNama;
        public TextView txtAlamat;
        public TextView txtTanggal;
        public ImageView gbrbiodata;
        public Penampung(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNama = (TextView) itemView.findViewById(R.id.txtnama);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtalamat);
            txtTanggal = (TextView) itemView.findViewById(R.id.txttanggal);
            gbrbiodata = (ImageView)itemView.findViewById(R.id.gbrbiodata);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtNama.getText());
        }
    }

    static class Penampung2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtsatu;
        public TextView txtdua;
        public TextView txttiga;
        public Penampung2(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtsatu = (TextView) itemView.findViewById(R.id.textView);
            txtdua = (TextView) itemView.findViewById(R.id.textView2);
            txttiga = (TextView) itemView.findViewById(R.id.textView3);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtsatu.getText());
        }
    }
    static class Penampung3 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public Penampung3(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = (ImageView)itemView.findViewById(R.id.gambar);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " );
        }
    }
    static class Penampung4 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView1,imageView2,imageView3;
        public Penampung4(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView1 = (ImageView)itemView.findViewById(R.id.gbr1);
            imageView2 = (ImageView)itemView.findViewById(R.id.gbr2);
            imageView3 = (ImageView)itemView.findViewById(R.id.gbr3);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " );
        }
    }
}
