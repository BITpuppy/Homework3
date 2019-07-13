package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder,container,false);
        animationView = (LottieAnimationView)view.findViewById(R.id.animation_view);
        list = (ListView)view.findViewById(R.id.list);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
        String[] Item = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("Item","friend"+Item[i]);
            listItem.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),listItem,R.layout.item,new String[] {"Item"}, new int[] {R.id.title});
        list.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1.0f,0);
                animator1.setDuration(3000);
                animator1.start();
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(list,"alpha",0,1.0f);
                animator2.setDuration(3000);
                animator2.start();
            }
        }, 5000);
    }
}