package com.ama.tourism_svg.Fragments.Home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.ama.tourism_svg.Classes.AutoScrollViewPager;
import com.ama.tourism_svg.Classes.ZoomOutPageTransformer;
import com.ama.tourism_svg.Fragments.TestFrag;
import com.ama.tourism_svg.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFrag extends Fragment{

    @BindView(R.id.home_viewPager)
    AutoScrollViewPager viewPager;

    @BindView(R.id.indicator)
    TabLayout indicator;

    private PagerAdapter pagerAdapter;

    private OnFragmentInteractionListener mListener;

    public HomeFrag(){}

    public static HomeFrag newInstance(){
        HomeFrag homeFrag = new HomeFrag();
        Bundle args = new Bundle();
        homeFrag.setArguments(args);
        return homeFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_home_main, container, false);
        ButterKnife.bind(this, itemView);

        pagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        indicator.setupWithViewPager(viewPager);
        viewPager.setAutoScrollDurationFactor(9.5);
        viewPager.setStopScrollWhenTouch(true);
        viewPager.startAutoScroll(15000);
        viewPager.setInterval(10000);
        viewPager.setCycle(true);
        //TODO note: When viewpager gets to end, fade to first fragment and restart auto scrolling

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager.stopAutoScroll();
                viewPager.startAutoScroll(15000);
                return false;
            }


        });


        return itemView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void messageFromHomeFragment(Uri uri);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {


        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SeasideFrag();
                case 1:
                    return new HomeRestaurantsFrag();
                case 2:
                    return new GrenadinesFrag();
                 default:
                        return new TestFrag();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
