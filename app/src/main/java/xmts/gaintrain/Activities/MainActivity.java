package xmts.gaintrain.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import xmts.gaintrain.Fragments.WorkoutListFragment;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.bottom_nav_bar_workout:
                    switchToWorkoutTab();
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setupActionbar();

//        switchToWorkoutTab();
    }

    //region [ Activity Helpers ] ================================= //
    private void setupActionbar() {
        Toolbar tb = findViewById(R.id.app_toolbar);
        tb.setTitle(R.string.app_name);
        setSupportActionBar(tb);
    }

    //endregion

    //region [ Fragment Navigation ] ================================= //
    private void switchToWorkoutTab() {

        ArrayList<Workout> workouts = new ArrayList<>(2);
        workouts.add(new Workout("Workout 1"));
        workouts.add(new Workout("Workout 2"));

        WorkoutListFragment workoutListFragment = WorkoutListFragment.newInstance(workouts);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_frame_layout, workoutListFragment)
                .commit();

    }

    //endregion

}
