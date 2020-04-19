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
        areaList.add(new Area(R.drawable.algebra,R.string.algebra, StaticsMenus.algebra));
        areaList.add(new Area(R.drawable.algebra_lineal,R.string.algebra_lineal, StaticsMenus.algebraLineal));
        areaList.add(new Area(R.drawable.geometria,R.string.geometria, StaticsMenus.geometria));
        areaList.add(new Area(R.drawable.geo_analitica,R.string.geometria_analitica, StaticsMenus.geometriaAnalitica));
        areaList.add(new Area(R.drawable.trigonometria,R.string.trigonometria, StaticsMenus.trigonometria));
        areaList.add(new Area(R.drawable.derivadas,R.string.calculo_diferencial, StaticsMenus.derivadas));
        areaList.add(new Area(R.drawable.integrales,R.string.calculo_integral, StaticsMenus.integrales));
        areaList.add(new Area(R.drawable.vectorial,R.string.calculo_vectorial, StaticsMenus.vectorial));
        areaList.add(new Area(R.drawable.ecuacuaciones,R.string.ecuaciones_diferenciales, StaticsMenus.ecuaciones));
        areaList.add(new Area(R.drawable.probabilidad,R.string.probabilidad_estadistica, StaticsMenus.pYE));
        areaList.add(new Area(R.drawable.financieras,R.string.matematicas_financieras, StaticsMenus.finacieras));
        return  areaList;
    }
}
