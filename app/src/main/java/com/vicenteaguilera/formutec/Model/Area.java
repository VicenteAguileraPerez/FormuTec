package com.vicenteaguilera.formutec.Model;

import android.widget.ImageView;

import java.util.List;

public class Area
{
    private int image;
    private int title;
    private List<String> array_subitems;
    private boolean expanded;

    public Area(int image, int title, List<String> array_subitems)
    {
        this.image = image;
        this.title = title;
        this.array_subitems = array_subitems;
        expanded=false;
    }

    public List<String> getArray_subitems() {
        return array_subitems;
    }

    public void setArray_subitems(List<String> array_subitems) {
        this.array_subitems = array_subitems;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
