package com.pyz.myproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: pyz
 * @Package: com.pyz.myproject
 * @Description: TODO
 * @Project: JNChartDemo
 * @Date: 2016/7/4 16:05
 */
public class Fragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4_layout,container,false);
        return view;
    }




}
