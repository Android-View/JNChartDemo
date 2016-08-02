package com.pyz.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jn.chart.charts.CombinedChart;
import com.jn.chart.data.BarEntry;
import com.jn.chart.data.Entry;
import com.jn.chart.manager.CombinedChartManager;

import java.util.ArrayList;

/**
 * @Author: pyz
 * @Package: com.pyz.myproject
 * @Description: TODO
 * @Project: JNChartDemo
 * @Date: 2016/7/4 16:04
 */
public class Fragment3 extends Fragment {
    private CombinedChart combinedChart;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout,container,false);
        combinedChart = (CombinedChart) view.findViewById(R.id.combinedChart);
        this.context = getActivity();
        initChart(context, combinedChart);
        return view;
    }

    private void initChart(Context context, CombinedChart combinedChart) {
        combinedChart.setDescription("专业情况");

        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("移网");
        xValues.add("后付");
        xValues.add("预付");
        xValues.add("宽带");


        ArrayList<Entry> yValues2Line = new ArrayList<>();
        yValues2Line.add(new Entry((float) (-3.12),0));
        yValues2Line.add(new Entry((float) 0.53,1));
        yValues2Line.add(new Entry((float) 2.52,2));
        yValues2Line.add(new Entry((float) 4.53,3));

        CombinedChartManager.setLineUnit("单位：%");

        ArrayList<BarEntry> yValues2Bar = new ArrayList<>();
        yValues2Bar.add(new BarEntry((float) 100,0));
        yValues2Bar.add(new BarEntry((float) 145,1));
        yValues2Bar.add(new BarEntry((float) 54,2));
        yValues2Bar.add(new BarEntry((float) 99,3));
        CombinedChartManager.setBarUnit("单位：万户");

        CombinedChartManager.initCombinedChart(context,combinedChart,xValues,yValues2Line,yValues2Bar);

    }


}
