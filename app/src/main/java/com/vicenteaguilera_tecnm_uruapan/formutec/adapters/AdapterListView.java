package com.vicenteaguilera_tecnm_uruapan.formutec.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.vicenteaguilera_tecnm_uruapan.formutec.R;
import java.util.List;

public class AdapterListView extends BaseAdapter {
    private List<Integer> imagenes;
    private LayoutInflater layoutInflater;

    public AdapterListView(List<Integer> imagenes, Context context)
    {
        this.imagenes = imagenes;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagenes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {

        view = layoutInflater.inflate(R.layout.item_list_topic,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.imageView_topic);

        imageView.setImageResource(imagenes.get(position));


        return view;
    }
}
