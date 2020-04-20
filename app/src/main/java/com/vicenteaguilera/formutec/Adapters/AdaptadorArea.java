package com.vicenteaguilera.formutec.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.vicenteaguilera.formutec.Model.Area;
import com.vicenteaguilera.formutec.R;
import com.vicenteaguilera.formutec.layouts_principales.FormulaActivity;

import java.util.List;

public class AdaptadorArea extends RecyclerView.Adapter<AdaptadorArea.AreaViewHolder>
{

    private List<Area> listaAreas;
    public AdaptadorArea (List<Area> listaAreas)
    {
         this.listaAreas=listaAreas;
    }

    @NonNull
    @Override
    public AreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_container,parent,false);
        return  new AreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaViewHolder holder, int position) {
        holder.textView_area.setText(listaAreas.get(position).getTitle());
        holder.imageView_area.setImageResource(listaAreas.get(position).getImage());
        boolean expanded = listaAreas.get(position).isExpanded();
        holder.constraintLayout_expandible_layout.setVisibility(expanded?View.VISIBLE:View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(holder.view.getContext(),android.R.layout.simple_list_item_1,listaAreas.get(position).getArray_subitems());
        holder.listView_lista.setAdapter(adapter);

    }


    @Override
    public int getItemCount() {
        return listaAreas.size();
    }
    class AreaViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout constraintLayout_container;
        ImageView imageView_area;
        TextView textView_area;
        ConstraintLayout constraintLayout_expandible_layout;
        ListView listView_lista;
        View view;
        @SuppressLint("ClickableViewAccessibility")
        AreaViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout_container = itemView.findViewById(R.id.container);
            imageView_area = itemView.findViewById(R.id.imageView_image_area);
            textView_area = itemView.findViewById(R.id.TextView_titulo);
            constraintLayout_expandible_layout = itemView.findViewById(R.id.expandible_layout);
            listView_lista = itemView.findViewById(R.id.lista);
            view=itemView;


            constraintLayout_container.setOnClickListener(view -> {

                Area area = listaAreas.get(getAdapterPosition());
                area.setExpanded(!area.isExpanded());
                notifyItemChanged(getAdapterPosition());



            });
            listView_lista.setOnItemClickListener((adapterView, view2, i, l) -> {
                String titulo = itemView.getContext().getResources().getString(listaAreas.get(getAdapterPosition()).getTitle());
                Intent intent = new Intent(itemView.getContext(), FormulaActivity.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("area",getAdapterPosition());
                intent.putExtra("subarea",i);
                itemView.getContext().startActivity(intent);

            });

            // Setting on Touch Listener for handling the touch inside ScrollView
            listView_lista.setOnTouchListener((v, event) -> {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            });





        }
    }


}

