package com.ama.tourism_svg;


import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ama.tourism_svg.Fragments.Home.HomeFrag;
import com.ama.tourism_svg.Fragments.MainFrag;
import com.ama.tourism_svg.Fragments.MapFrag;
import com.ama.tourism_svg.Fragments.TestFrag;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.tbuonomo.morphbottomnavigation.MorphBottomNavigationView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HomeFrag.OnFragmentInteractionListener, MainFrag.OnFragmentInteractionListener{


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_search)
    SearchView toolSearch;

    @BindView(R.id.bottomNavigationView)
    MorphBottomNavigationView morphBar;


    final Fragment homeFrag = new HomeFrag();
    final Fragment testFrag = new TestFrag();
    final Fragment mainFrag = new MainFrag();
    final Fragment mapFrag = new MapFrag();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFrag;

    Drawer navDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.WHITE);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.hamburger_rounded));

//        toolSearch.setIconified(false);
//        toolSearch.clearFocus();

        toolbar.setNavigationOnClickListener(v -> Log.d("NavClick", "navigation clicked"));

        initNavDrawer();
        initFragments();
        initBottomNav();
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    //INITIALIZERS
    private void initNavDrawer(){

        DrawerBuilder builder = new DrawerBuilder().withActivity(this);

        navDrawer = builder
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .build();


    }

    public void initFragments(){


        fm.beginTransaction().add(R.id.main_container, mapFrag, "4").hide(mapFrag).commit();
        fm.beginTransaction().add(R.id.main_container, mainFrag, "3").hide(mainFrag).commit();
        fm.beginTransaction().add(R.id.main_container, testFrag, "2").hide(testFrag).commit();
        fm.beginTransaction().add(R.id.main_container, homeFrag, "1").commit();
    }

    public void initBottomNav(){
        morphBar.setOnNavigationItemSelectedListener(menuItem -> {
            switch(menuItem.getItemId()){
                case R.id.nav_camera:
                    fm.beginTransaction().hide(active).show(homeFrag).commit();
                    active = homeFrag;
                    return true;
                case R.id.nav_gallery:
                    //TODO Note#1: Tabs are hidden as a default, to show them simply click on the nav option again
                    fm.beginTransaction().hide(active).show(testFrag).commit();
                    active = testFrag;
                    return true;
                case R.id.nav_slideshow:
                    fm.beginTransaction().hide(active).show(mapFrag).commit();
                    active = mapFrag;
                    return true;
                case R.id.nav_manage:
                    fm.beginTransaction().hide(active).show(mainFrag).commit();
                    active = mainFrag;
                    return true;
                default:
                        fm.beginTransaction().hide(active).show(homeFrag).commit();
                        active = homeFrag;
                        Log.d("FragSwitch", "Default Behaviour");
                        return true;
            }
//                return false;
        });
    }

    //METHODS
    private void setupDrawer() {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void messageFromMainFragment(Uri uri) {
        Log.i("TAG", "received communication from parent fragment");
    }

    @Override
    public void messageFromHomeFragment(Uri uri) {
        Log.i("TAG", "received communication from child fragment");
    }
}
