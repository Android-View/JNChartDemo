package com.pyz.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jn.chart.charts.BarChart;
import com.jn.chart.data.BarEntry;
import com.jn.chart.manager.BarChartManager;

import java.util.ArrayList;

/**
 * @Author: pyz
 * @Package: com.pyz.myproject
 * @Description: TODO
 * @Project: MyProject
 * @Company: 深圳君南信息系统有限公司
 * @Date: 2016/7/4 16:04
 */
public class Fragment2 extends Fragment {
    private BarChart barChart;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        barChart = (BarChart) view.findViewById(R.id.barChart);
        this.context = getActivity();
        initChart(context,barChart);
        return view;
    }

    private void initChart(Context context, BarChart barChart) {
        barChart.setDescription("专业情况（不含ICT）");

        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("总计");
        xValues.add("移网");
        xValues.add("固网");
        xValues.add("后付");
        xValues.add("预付");
        xValues.add("登4G");

        ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry((float) 2.09,0));
        yValues.add(new BarEntry((float) 2.81,1));
        yValues.add(new BarEntry((float) (-1.49),2));
        yValues.add(new BarEntry((float) 5.19,3));
        yValues.add(new BarEntry((float) (-0.05),4));
        yValues.add(new BarEntry((float) 3.86,5));
        BarChartManager.setUnit("单位：万户");
        BarChartManager.initBarChart(context,barChart,xValues,yValues);
    }
}
