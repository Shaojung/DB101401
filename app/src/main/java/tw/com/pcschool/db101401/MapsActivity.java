package tw.com.pcschool.db101401;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tpe1 = new LatLng(25.035, 121.448);
        LatLng tpe2 = new LatLng(25.085, 121.448);

        mMap.addMarker(new MarkerOptions().position(tpe1).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(tpe2).title("Taipei 2"));

        // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tpe1, 12));
        // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tpe1, 12), 5000, null);
        CameraPosition cameraPos = new CameraPosition.Builder().target(tpe1)
                .zoom(12.0f).build();
        // 定義地圖相機鏡頭移動
        CameraUpdate cameraUpt = CameraUpdateFactory
                .newCameraPosition(cameraPos);
        // 地圖相機鏡頭動畫行程設定
        mMap.animateCamera(cameraUpt, 10000, null);

        PolylineOptions options = new PolylineOptions();
        options.add(tpe1, tpe2);
        options.width(5);
        options.color(Color.MAGENTA);
        options.zIndex(1); // 疊層id( 數字越高圖層越上層)
        mMap.addPolyline(options);

        CircleOptions options2 = new CircleOptions();
        options2.center(tpe1); // 圓心位置
        options2.radius(200); // 半徑( 公尺)
        options2.strokeWidth(5); // 圓形外框寬度
        options2.strokeColor(Color.TRANSPARENT); // 圓形外框顏色
        options2.fillColor(Color.argb(150, 255, 0, 0));
        options.zIndex(3); // 疊層id( 數字越高圖層越上層)
        mMap.addCircle(options2);
    }
}
