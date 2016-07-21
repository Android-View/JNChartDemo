package com.pyz.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jn.chart.charts.LineChart;
import com.jn.chart.data.Entry;
import com.jn.chart.manager.LineChartManager;

import java.util.ArrayList;

/**
 * @Author: pyz
 * @Package: com.pyz.myproject
 * @Description: TODO
 * @Project: MyProject
 * @Company: 深圳君南信息系统有限公司
 * @Date: 2016/7/4 15:33
 */
public class Fragment1 extends android.support.v4.app.Fragment {
    private LineChart mLineChart;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        this.context = getActivity();
        mLineChart = (LineChart) view.findViewById(R.id.lineChart);
        //设置图表的描述
        mLineChart.setDescription("全省移网");

        //设置x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            xValues.add("" + i);
        }

        //设置y轴的数据
        ArrayList<Entry> yValue = new ArrayList<>();
        yValue.add(new Entry(13, 1));
        yValue.add(new Entry(6, 2));
        yValue.add(new Entry(3, 3));
        yValue.add(new Entry(7, 4));
        yValue.add(new Entry(2, 5));
        yValue.add(new Entry(5, 6));
        yValue.add(new Entry(12, 7));
        //设置折线的名称
        LineChartManager.setLineName("当月值");
        //创建一条折线的图表
//        LineChartManager.initSingleLineChart(context,mLineChart,xValues,yValue);

        //设置第二条折线y轴的数据
        ArrayList<Entry> yValue1 = new ArrayList<>();
        yValue1.add(new Entry(17, 1));
        yValue1.add(new Entry(3, 2));
        yValue1.add(new Entry(5, 3));
        yValue1.add(new Entry(4, 4));
        yValue1.add(new Entry(3, 5));
        yValue1.add(new Entry(7, 6));
        yValue1.add(new Entry(10, 7));
        LineChartManager.setLineName1("上月值");
        //创建两条折线的图表
        LineChartManager.initDoubleLineChart(context,mLineChart,xValues,yValue,yValue1);
        return view;
    }



}
