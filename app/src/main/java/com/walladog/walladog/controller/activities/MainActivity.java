package com.walladog.walladog.controller.activities;

/**
 * Created by f3rn4nd0 on 12/8/15.
 *
 */
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.walladog.walladog.R;
import com.walladog.walladog.controller.fragments.MainFragment;
import com.walladog.walladog.controller.fragments.ServiceFragment;


public class MainActivity extends AppCompatActivity implements MainFragment.OnWalladogItemSelectedListener,ServiceFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the com.walladog.walladog.menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onWaladogItemSelected(int wineIndex) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}