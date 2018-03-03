package xmts.gaintrain.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import xmts.gaintrain.Fragments.StatisticsFragment;
import java.util.ArrayList;
import xmts.gaintrain.Fragments.WorkoutListFragment;
import xmts.gaintrain.Models.Exercise;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;
import xmts.gaintrain.Utils.TestUtils;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListFragmentListener {

    private TextView mTextMessage;

    @Override
    public void onWorkoutSelected(Workout w) {
        //TODO: switch fragments to workout fragment view
        Toast.makeText(MainActivity.this, w.toString(), Toast.LENGTH_SHORT).show();
        //switchToWorkout();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchToHomeTab();
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

        TestUtils.getTestWorkoutHistory();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setupActionbar();

        // Chooses the home tab upon startup
        switchToHomeTab();
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
        //Workout fragment has a list of workouts and a listener
        WorkoutListFragment workoutListFragment = WorkoutListFragment.newInstance(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_frame_layout, workoutListFragment)
                .commit();
    }

    //endregion
    private void switchToHomeTab() {
        StatisticsFragment statisticsFragment = new StatisticsFragment();
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_activity_frame_layout, statisticsFragment)
            .commit();

    }

}
