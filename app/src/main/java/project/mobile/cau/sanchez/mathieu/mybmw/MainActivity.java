package project.mobile.cau.sanchez.mathieu.mybmw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List< MenuModel > headerList = new ArrayList<>();
    HashMap< MenuModel, List< MenuModel > > childList = new HashMap<>();
    DrawerLayout drawer;

    // Fragments
    MainFragment mainFragment = new MainFragment();
    ContentFragment contentFragment = new ContentFragment();
    SerieFragment serieFragment = new SerieFragment();

    Boolean isMainFragment = true;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        expandableListView = findViewById( R.id.expandableListView );

        prepareMenuData();
        populateExpandableList();

        drawer = findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        setFragment( mainFragment );
    }

    private void setFragment( Fragment fragment ) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace( R.id.fragment_container, fragment );
        fragmentTransaction.commit();
        drawer.closeDrawer( Gravity.LEFT );

        isMainFragment = fragment.getClass().equals( mainFragment.getClass() );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );

        if ( drawer.isDrawerOpen( GravityCompat.START ) ) {
            drawer.closeDrawer( GravityCompat.START );
        } else if ( !isMainFragment ) {
            setFragment( mainFragment );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item ) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if ( id == R.id.nav_gallery ) {

        } else if ( id == R.id.nav_slideshow ) {

        } else if ( id == R.id.nav_manage ) {

        } else if ( id == R.id.nav_share ) {

        } else if ( id == R.id.nav_send ) {

        }

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    private void prepareMenuData() {
        List< MenuModel > childModelsList;

        for ( int i = 1; i < 9; i++ ) {
            MenuModel menuModel = new MenuModel( Integer.toString( i ) + " Serie", true, true );
            headerList.add( menuModel );

            childModelsList = new ArrayList<>();

            switch ( i ) {
                case 1:
                    childModelsList.add( new MenuModel( "E81/E82/E87/E88", false, false ) );
                    childModelsList.add( new MenuModel( "F20/F21", false, false ) );
                    childModelsList.add( new MenuModel( "F52", false, false ) );
                    break;
                case 2:
                    childModelsList.add( new MenuModel( "F22", false, false ) );
                    childModelsList.add( new MenuModel( "F45", false, false ) );
                    childModelsList.add( new MenuModel( "F46", false, false ) );
                    break;
                case 3:
                    childModelsList.add( new MenuModel( "E21", false, false ) );
                    childModelsList.add( new MenuModel( "E30", false, false ) );
                    childModelsList.add( new MenuModel( "E36", false, false ) );
                    childModelsList.add( new MenuModel( "E46", false, false ) );
                    childModelsList.add( new MenuModel( "E90/E91/E92/E93", false, false ) );
                    childModelsList.add( new MenuModel( "F30/F31/F34", false, false ) );
                    childModelsList.add( new MenuModel( "G20", false, false ) );
                    break;
                case 4:
                    childModelsList.add( new MenuModel( "F32/F33/F36", false, false ) );
                    break;
                case 5:
                    childModelsList.add( new MenuModel( "E12", false, false ) );
                    childModelsList.add( new MenuModel( "E28", false, false ) );
                    childModelsList.add( new MenuModel( "E34", false, false ) );
                    childModelsList.add( new MenuModel( "E39", false, false ) );
                    childModelsList.add( new MenuModel( "E60/E61", false, false ) );
                    childModelsList.add( new MenuModel( "F10/F11/F07", false, false ) );
                    childModelsList.add( new MenuModel( "G30/G31/G38", false, false ) );
                    break;
                case 6:
                    childModelsList.add( new MenuModel( "E24", false, false ) );
                    childModelsList.add( new MenuModel( "E63/E64", false, false ) );
                    childModelsList.add( new MenuModel( "F06/F12/F13", false, false ) );
                    childModelsList.add( new MenuModel( "G32", false, false ) );
                    break;
                case 7:
                    childModelsList.add( new MenuModel( "E23", false, false ) );
                    childModelsList.add( new MenuModel( "E32", false, false ) );
                    childModelsList.add( new MenuModel( "E38", false, false ) );
                    childModelsList.add( new MenuModel( "E65/E66/E67/E68", false, false ) );
                    childModelsList.add( new MenuModel( "F01/F02/F03/F04", false, false ) );
                    childModelsList.add( new MenuModel( "G11/G12", false, false ) );
                    break;
                case 8:
                    childModelsList.add( new MenuModel( "E31", false, false ) );
                    childModelsList.add( new MenuModel( "G14/G15/G16", false, false ) );
                    break;
            }

            if ( menuModel.hasChildren ) {
                childList.put( menuModel, childModelsList );
            }
        }
    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter( this, headerList, childList );
        expandableListView.setAdapter( expandableListAdapter );

        expandableListView.setOnGroupClickListener( new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick( ExpandableListView parent, View v, int groupPosition, long id ) {

                if ( headerList.get( groupPosition ).isGroup ) {
                    if ( !headerList.get( groupPosition ).hasChildren ) {
                        onBackPressed();
                    }
                }

                return false;
            }
        } );

        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick( ExpandableListView parent, View v, int groupPosition, int childPosition, long id ) {

                if ( childList.get( headerList.get( groupPosition ) ) != null ) {
                    List list = childList.get( headerList.get( groupPosition ) );
                    assert list != null;
                    MenuModel model = (MenuModel) list.get( childPosition );

                    sendDataFragment( contentFragment, model.menuName );
                    setFragment( contentFragment );
//                    Log.d( TAG, model.menuName );
                }

                return false;
            }
        } );
    }

    public void sendDataFragment( Fragment fragment, String data ) {
        Bundle bundle = new Bundle();

        bundle.putString( "title", data );
        fragment.setArguments( bundle );
    }

    public void sendDataFragment( Fragment fragment, String data, List<MenuModel> list ) {
        Bundle bundle = new Bundle();
        ArrayList< MenuModel > arrayList = new ArrayList<>( list );

        bundle.putString( "title", data );
        bundle.putSerializable( "list", arrayList );

        fragment.setArguments( bundle );
    }

    public void onClickSerie1( View view ) {
        sendDataFragment( serieFragment, "1 Serie", childList.get( headerList.get( 0 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie2( View view ) {
        sendDataFragment( serieFragment, "2 Serie", childList.get( headerList.get( 1 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie3( View view ) {
        sendDataFragment( serieFragment, "3 Serie", childList.get( headerList.get( 2 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie4( View view ) {
        sendDataFragment( serieFragment, "4 Serie", childList.get( headerList.get( 3 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie5( View view ) {
        sendDataFragment( serieFragment, "5 Serie", childList.get( headerList.get( 4 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie6( View view ) {
        sendDataFragment( serieFragment, "6 Serie", childList.get( headerList.get( 5 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie7( View view ) {
        sendDataFragment( serieFragment, "7 Serie", childList.get( headerList.get( 6 ) ) );
        setFragment( serieFragment );
    }

    public void onClickSerie8( View view ) {
        sendDataFragment( serieFragment, "8 Serie", childList.get( headerList.get( 7 ) ) );
        setFragment( serieFragment );
    }

}
