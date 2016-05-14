package io.github.anthonyeef.guokrread.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.PagerAdapter;
import io.github.anthonyeef.guokrread.fragment.ExploreFragment;
import io.github.anthonyeef.guokrread.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Bind(R.id.tabs)
    TabLayout mTabs;

    @Bind(R.id.pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setupLayout();
        setupViewPager(mViewPager);
        setupDrawerContent(navigationView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new ExploreFragment(), "Explore");
        viewPager.setAdapter(adapter);

        mTabs.setupWithViewPager(viewPager);
    }

    private void setupLayout() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(" ₍₍ (ง ᐛ)ว ⁾⁾");
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }
}
