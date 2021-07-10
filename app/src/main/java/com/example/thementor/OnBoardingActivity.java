package com.example.thementor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.thementor.Adapters.SlidePagerAdapter;
import com.example.thementor.Fragments.IntroFrag1;
import com.example.thementor.Fragments.IntroFrag2;
import com.example.thementor.Fragments.IntroFrag3;

import java.util.ArrayList;
import java.util.List;


public class OnBoardingActivity extends AppCompatActivity {




    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        //Folllowing is the code to set the status bar as color
        Window window= OnBoardingActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(OnBoardingActivity.this, R.color.colorMain));


        //Restricting the lanscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        //Following is the code, to make the activity over ride the status bar(Fir the Whole MobileScreen)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }



        viewPager=findViewById(R.id.viewpager_onboarding);

        List<Fragment> list=new ArrayList<>();
        list.add(new IntroFrag1()); //Adding the first fragment
        list.add(new IntroFrag2()); //Adding the second fragment
        list.add(new IntroFrag3()); //Adding the third fragment

        pagerAdapter=new SlidePagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);



    }
}