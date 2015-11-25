package io.github.anthonyeef.guokrread.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.PagerAdapter;
import io.github.anthonyeef.guokrread.fragment.ExploreFragment;
import io.github.anthonyeef.guokrread.fragment.HomeFragment;

public class UIHome extends AppCompatActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.nav)
    RelativeLayout mNavBar;
    @Bind(R.id.nav_menu)
    RelativeLayout mNavMenu;
    @Bind(R.id.nav_bottom_1)
    RelativeLayout mNavBtnLeft;
    @Bind(R.id.nav_bottom_2)
    RelativeLayout mNavBtnRight;
    @Bind(R.id.drawer_view)
    NavigationView mLeftDrawer;


    private HomeFragment mHomeFragment;
    private ExploreFragment mExploreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        initView();

        initPager();

        setupDrawerContent(navigationView);

    }


    private void initView() {
        mNavMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDrawerLayout.isDrawerOpen(mLeftDrawer))
                    mDrawerLayout.openDrawer(mLeftDrawer);
            }
        });
    }

    private void initPager() {
        mHomeFragment = new HomeFragment();
        Bundle homeBundle = new Bundle();
        homeBundle.putInt(HomeFragment.TAB_INDEX_FIELD, 0);
        mHomeFragment.setArguments(homeBundle);
        mHomeFragment.setOnScr

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
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), getString(R.string.home));
        adapter.addFragment(new ExploreFragment(), getString(R.string.explore));
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
