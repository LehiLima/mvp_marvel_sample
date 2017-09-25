package com.example.lehiteixeira.marvel.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.lehiteixeira.marvel.R;
import com.example.lehiteixeira.marvel.View.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, ItemFragment2.OnListFragmentInteractionListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, ItemFragment.getInstance(), "fragA").addToBackStack(null).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Fragment fragmentB = new ItemFragment2();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, fragmentB, "fragB").addToBackStack(null).commit();

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        overridePendingTransition(R.anim.alpha_out_right ,R.anim.alpha_in_left);


        Fragment fragment = new ItemFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment, "fragA").addToBackStack(null).commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

//}  private void animatedImage() {
//    objectanimator = ObjectAnimator.ofFloat(userimagecontainer,"translationY",-1500,0);
//    objectanimator.setDuration(1000);
//    objectanimator.start();
//    objectanimator.addListener(new Animator.AnimatorListener() {
//        @Override
//        public void onAnimationStart(Animator animator) {
//
//        }
//
//        @Override
//        public void onAnimationEnd(Animator animator) {
//            Animation anim = new ScaleAnimation(
//                    1f, 3f, // Start and end values for the X axis scaling
//                    1f, 3f, // Start and end values for the Y axis scaling
//                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
//                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
//            anim.setFillAfter(true); // Needed to keep the result of the animation
//            anim.setDuration(450);
//
//            userimagecontainer.startAnimation(anim);
//            anim.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    Animation anim = new ScaleAnimation(
//                            3f, 2f, // Start and end values for the X axis scaling
//                            3f, 2f, // Start and end values for the Y axis scaling
//                            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
//                            Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
//                    anim.setFillAfter(true); // Needed to keep the result of the animation
//                    anim.setDuration(450);
//                    userimagecontainer.startAnimation(anim);
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            });
//        }
//
//        @Override
//        public void onAnimationCancel(Animator animator) {
//
//        }
//
//        @Override
//        public void onAnimationRepeat(Animator animator) {
//
//        }
//    });

//    private void animatedImage() {
//
//        AnimationSet animationSet = new AnimationSet(true);
//        ScaleAnimation s = new ScaleAnimation(
//                0f, 1f, // Start and end values for the X axis scaling
//                0f, 1f, // Start and end values for the Y axis scaling
//                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
//                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
//        s.setDuration(2000);
//
//        TranslateAnimation a = new TranslateAnimation(
//                Animation.ABSOLUTE,Animation.ABSOLUTE, Animation.ABSOLUTE,Animation.ABSOLUTE,
//                Animation.ABSOLUTE,-1000, Animation.ABSOLUTE,0);
//        a.setDuration(2000);
//
//        animationSet.addAnimation(a);
//        a.setFillAfter(true); // Needed to keep the result of the animation
//
//        animationSet.addAnimation(s);
////
////        RotateAnimation r = new RotateAnimation(0f, -90f,200,200); // HERE
////        r.setStartOffset(1000);
////        r.setDuration(1000);
////        r.setFillAfter(true); //HERE
////        animationSet.addAnimation(r);
//
//        userimagecontainer.startAnimation(animationSet);
//        Drawable d = buble_anim.getDrawable();
//        ((Animatable) d).start();
//
//    }

}
