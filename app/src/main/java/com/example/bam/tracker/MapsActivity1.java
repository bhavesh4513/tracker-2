package com.example.bam.tracker;

import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements LocationInterface{
    private GoogleMap mMap;
    private final LatLng LOCATION_MUMBAI=new LatLng(19.0176147,72.8561644);
    private final LatLng LOCATION_DELHI=new LatLng(28.635308,77.22496);
    private final LatLng LOCATION_CHENNAI=new LatLng(13.060422,80.249583);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);

        SupportMapFragment f=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mMap=f.getMap();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Satellite",Toast.LENGTH_LONG).show();
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.Terrain:
                Toast.makeText(getApplicationContext(),"Terrain",Toast.LENGTH_LONG).show();
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            case R.id.Street:
                Toast.makeText(getApplicationContext(),"Street",Toast.LENGTH_LONG).show();
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }





    public void update(Double latitude,Double longitude) {
        final LatLng CURRENT=new LatLng(latitude,longitude);
        CameraUpdate update=CameraUpdateFactory.newLatLng(CURRENT);
        mMap.addMarker(new MarkerOptions().position(CURRENT).title("Current Location"));

        mMap.animateCamera(update);
    }
}
