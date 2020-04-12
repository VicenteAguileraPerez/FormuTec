package com.vicenteaguilera.formutec.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.vicenteaguilera.formutec.R;

import java.util.List;

public class AdapterSubareas extends BaseAdapter
{
    Context context;
    List<Integer> imagenes;
    LayoutInflater layoutInflater;

    public AdapterSubareas(Context context, List<Integer> imagenes)
    {
        this.context = context;
        this.imagenes = imagenes;
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
        ImageView imageView;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.item_subarea,viewGroup,false);

        imageView = view1.findViewById(R.id.image_subarea);
        imageView.setImageResource(imagenes.get(position));
        return view1;
    }
}
