package com.vicenteaguilera.formutec.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.vicenteaguilera.formutec.R;

import java.util.List;

public class AdapterListView extends BaseAdapter {
    List<Integer> imagenes;
    Context context;
    LayoutInflater layoutInflater;

    public AdapterListView(List<Integer> imagenes, Context context)
    {
        this.imagenes = imagenes;
        this.context = context;
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

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {

        view = layoutInflater.inflate(R.layout.item_list_topic,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.imageView_topic);

        imageView.setImageResource(imagenes.get(position));


        return view;
    }
}
