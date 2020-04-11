package com.vicenteaguilera.formutec.Auxiliar;

import com.vicenteaguilera.formutec.Model.Area;
import com.vicenteaguilera.formutec.R;

import java.util.ArrayList;
import java.util.List;

public class FillRecyclerView
{
    List<Area> areaList;

    public List<Area> getAreaList()
    {
        areaList = new ArrayList<>();
        areaList.add(new Area(R.drawable.algebra,R.string.algebra,Statics.Algebra));
        areaList.add(new Area(R.drawable.algebra_lineal,R.string.algebra_lineal,Statics.Algebra));
        areaList.add(new Area(R.drawable.geometria,R.string.geometria,Statics.Geometria));
        areaList.add(new Area(R.drawable.geo_analitica,R.string.geometria_analitica,Statics.GeometriaAnalitica));
        areaList.add(new Area(R.drawable.trigonometria,R.string.trigonometria,Statics.Algebra));
        areaList.add(new Area(R.drawable.derivadas,R.string.calculo_diferencial,Statics.Derivadas));
        areaList.add(new Area(R.drawable.integrales,R.string.calculo_integral,Statics.Integrales));
        areaList.add(new Area(R.drawable.vectorial,R.string.calculo_vectorial,Statics.Vectorial));
        areaList.add(new Area(R.drawable.ecuacuaciones,R.string.ecuaciones_diferenciales,Statics.Algebra));
        areaList.add(new Area(R.drawable.probabilidad,R.string.probabilidad_estadistica,Statics.Algebra));
        areaList.add(new Area(R.drawable.financieras,R.string.matematicas_financieras,Statics.Finacieras));
        return  areaList;
    }
}
