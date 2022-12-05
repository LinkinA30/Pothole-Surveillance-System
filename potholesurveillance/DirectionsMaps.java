package com.example.potholesurveillance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class DirectionsMaps extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    View back_to, get_route;
    String source, destination, route_number;
    AutoCompleteTextView from_source, to_destinaion;

    String from_locations[] = {"MIT WPU, Pune", "SNDT Bus Stand", "Dmart, Aundh", "GP, Pune", "Karve Statue"};
    String to_location[]= {"Hotel Durga", "Stanza Hostel", "IISER", "Khadki Railway St."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        back_to = (View) findViewById(R.id.back_to_dash);
        from_source = (AutoCompleteTextView) findViewById(R.id.from_s);
        to_destinaion = (AutoCompleteTextView) findViewById(R.id.to_d);
        get_route = (View) findViewById(R.id.route_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, from_locations);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, to_location);

        from_source.setThreshold(0);
        to_destinaion.setThreshold(0);
        from_source.setAdapter(adapter);
        to_destinaion.setAdapter(adapter2);

        back_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(DirectionsMaps.this, DashboardMain.class);
                startActivity(intent3);
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        get_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                source = from_source.getText().toString();
                destination = to_destinaion.getText().toString();

                if(source.equals("MIT WPU, Pune" ))
                {
                    if(destination.equals("Stanza Hostel")){

                        mMap.clear();
                        LatLng pothole1 = new LatLng(18.513914, 73.815412);
                        LatLng pothole2 = new LatLng(18.512315, 73.810421);
                        LatLng pothole3 = new LatLng(18.515603, 73.805885);
                        LatLng pothole4 = new LatLng(18.512368, 73.805977);
                        LatLng pothole5 = new LatLng(18.511088, 73.815627);
                        LatLng pothole6 = new LatLng(18.512405, 73.809026);
                        // Add a marker in Sydney and move the camera
                        LatLng loc = new LatLng(18.517845735590132, 73.81483968551389);

                        LatLng mit_stanza1 = new LatLng(18.517771, 73.815390);
                        LatLng mit_stanza2 = new LatLng(18.515814, 73.815387);
                        LatLng mit_stanza3 = new LatLng(18.515639, 73.815363);
                        LatLng mit_stanza4 = new LatLng(18.514099, 73.815392);
                        LatLng mit_stanza5 = new LatLng(18.513914, 73.815412);
                        LatLng mit_stanza6 = new LatLng(18.512835, 73.815514);
                        LatLng mit_stanza7 = new LatLng(18.511088, 73.815627);
                        LatLng mit_stanza8 = new LatLng(18.510457, 73.814185);
                        LatLng mit_stanza9 = new LatLng(18.510434, 73.813935);
                        LatLng mit_stanza10 = new LatLng(18.511870, 73.811665);
                        LatLng mit_stanza11 = new LatLng(18.512106, 73.811172);
                        LatLng mit_stanza12 = new LatLng(18.512261, 73.810805);
                        LatLng mit_stanza13 = new LatLng(18.512315, 73.810421);
                        LatLng mit_stanza14 = new LatLng(18.512353, 73.809458);
                        LatLng mit_stanza15 = new LatLng(18.512405, 73.809026);
                        LatLng mit_stanza16 = new LatLng(18.512510, 73.808744);
                        LatLng mit_stanza17 = new LatLng(18.512368, 73.805977);
                        LatLng mit_stanza18 = new LatLng(18.512520, 73.805885);
                        LatLng mit_stanza19 = new LatLng(18.515603, 73.805885);
                        LatLng mit_stanza20 = new LatLng(18.515682, 73.804815);
                        LatLng mit_stanza21 = new LatLng(18.515831, 73.803971);
                        LatLng mit_stanza22 = new LatLng(18.515948, 73.803852);
                        LatLng mit_stanza23 = new LatLng(18.516247, 73.803815);
                        LatLng mit_stanza24 = new LatLng(18.516604, 73.803808);

                        LatLng StanzaHouse = new LatLng(18.516611, 73.803673);

                        mMap.addMarker(new MarkerOptions()
                                .position(loc));

                        mMap.addMarker((new MarkerOptions()
                                .position(StanzaHouse)));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole1)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole2)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole3)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole4)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole5)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole6)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addPolyline((new PolylineOptions()).add(loc,mit_stanza1,mit_stanza2,mit_stanza3,mit_stanza4,mit_stanza5,mit_stanza6,
                                        mit_stanza7,mit_stanza8,mit_stanza9,mit_stanza10,mit_stanza11,mit_stanza12,mit_stanza13,mit_stanza14,mit_stanza15,
                                        mit_stanza16,mit_stanza17,mit_stanza18,mit_stanza19,mit_stanza20,mit_stanza21,mit_stanza22,mit_stanza23,
                                        mit_stanza24,StanzaHouse).
                                // below line is use to specify the width of poly line.
                                        width(15)
                                // below line is use to add color to our poly line.
                                .color(Color.RED)
                                // below line is to make our poly line geodesic.
                                .geodesic(true));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,15));
                        // Zoom in, animating the camera.
                        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

                    }
                }

                if(destination.equals("Hotel Durga")){
                    if(source.equals("SNDT Bus Stand")){

                        mMap.clear();

                        LatLng pothole1 = new LatLng(18.5059212, 73.8255008);

                        // Add a marker in Sydney and move the camera
                        LatLng durga_sndt1 = new LatLng(18.5070642, 73.8283470);
                        LatLng durga_sndt2 = new LatLng(18.5060970, 73.8259206);

                        LatLng durga_sndt3 = new LatLng(18.5059212, 73.8255008);

                        LatLng durga_sndt4 = new LatLng(18.5059269, 73.8253999);
                        LatLng durga_sndt5 = new LatLng(18.5059206, 73.8253033);
                        LatLng durga_sndt6 = new LatLng(18.5059307, 73.8252141);
                        LatLng durga_sndt7 = new LatLng(18.5059422, 73.8251528);
                        LatLng durga_sndt8 = new LatLng(18.5059342, 73.8251135);
                        LatLng durga_sndt9 = new LatLng(18.5059527, 73.8250405);
                        LatLng durga_sndt10 = new LatLng(18.5059527, 73.8250405);
                        LatLng durga_sndt11 = new LatLng(18.5060856, 73.8246336);
                        LatLng durga_sndt12 = new LatLng(18.5060655, 73.8246924);
                        LatLng durga_sndt13 = new LatLng(18.5061107, 73.8245624);
                        LatLng durga_sndt14 = new LatLng(18.5061867, 73.8244748);
                        LatLng durga_sndt15 = new LatLng(18.5066045, 73.8240056);
                        LatLng durga_sndt16 = new LatLng(18.5094795, 73.8215476);
                        LatLng durga_sndt17 = new LatLng(18.5098360, 73.8212730);
                        LatLng durga_sndt18 = new LatLng(18.5099694, 73.8209963);
                        LatLng durga_sndt19 = new LatLng(18.5100951, 73.8208261);
                        LatLng durga_sndt20 = new LatLng(18.5102333, 73.8206102);
                        LatLng durga_sndt21 = new LatLng(18.5104912, 73.8200492);
                        LatLng durga_sndt22 = new LatLng(18.5104724, 73.8197495);
                        LatLng durga_sndt23 = new LatLng(18.5104693, 73.8194885);
                        LatLng durga_sndt24 = new LatLng(18.5099091, 73.8157030);
                        LatLng durga_sndt25 = new LatLng(18.510177, 73.815601);
                        LatLng durga_sndt26 = new LatLng(18.510308, 73.815888);
                        LatLng durga_sndt27 = new LatLng(18.5104375, 73.8161808);


                        mMap.addMarker(new MarkerOptions()
                                .position(durga_sndt1));

                        mMap.addMarker((new MarkerOptions()
                                .position(durga_sndt27)));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole1)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addPolyline((new PolylineOptions()).add(durga_sndt1,durga_sndt2,durga_sndt3,durga_sndt4,durga_sndt5,durga_sndt6,
                                        durga_sndt7,durga_sndt8,durga_sndt9,durga_sndt10,durga_sndt11,durga_sndt12,durga_sndt13,durga_sndt14,durga_sndt15,
                                        durga_sndt16,durga_sndt17,durga_sndt18,durga_sndt19,durga_sndt20,durga_sndt21,durga_sndt22,durga_sndt23,
                                        durga_sndt24,durga_sndt25,durga_sndt26, durga_sndt27).
                                // below line is use to specify the width of poly line.
                                        width(15)
                                // below line is use to add color to our poly line.
                                .color(Color.GREEN)
                                // below line is to make our poly line geodesic.
                                .geodesic(true));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(durga_sndt1,15));
                        // Zoom in, animating the camera.
                        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

                    }

                    if(source.equals("Karve Statue")){

                        mMap.clear();

                        LatLng pothole1 = new LatLng(18.502380, 73.816766);
                        LatLng pothole2 = new LatLng(18.503305, 73.818254);
                        LatLng pothole3 = new LatLng(18.508566, 73.816110);

                        // Add a marker in Sydney and move the camera
                        LatLng durga_karvep1 = new LatLng(18.502158, 73.815100);
                        LatLng durga_karvep2 = new LatLng(18.502174, 73.815367);
                        LatLng durga_karvep3 = new LatLng(18.502380, 73.816766);
                        LatLng durga_karvep4 = new LatLng(18.502562, 73.817447);
                        LatLng durga_karvep5 = new LatLng(18.502840, 73.818374);
                        LatLng durga_karvep6 = new LatLng(18.502962, 73.818353);
                        LatLng durga_karvep7 = new LatLng(18.503305, 73.818254);
                        LatLng durga_karvep8 = new LatLng(18.503940, 73.818117);
                        LatLng durga_karvep9 = new LatLng(18.504221, 73.818063);
                        LatLng durga_karvep10 = new LatLng(18.505028, 73.817861);
                        LatLng durga_karvep11 = new LatLng(18.506127, 73.817537);
                        LatLng durga_karvep12 = new LatLng(18.505973, 73.816692);
                        LatLng durga_karvep13 = new LatLng(18.507700, 73.816307);
                        LatLng durga_karvep14 = new LatLng(18.508566, 73.816110);
                        LatLng durga_karvep15 = new LatLng(18.509878, 73.815700);
                        LatLng durga_karvep16 = new LatLng(18.510159, 73.815594);
                        LatLng durga_karvep17 = new LatLng(18.510308, 73.815888);
                        LatLng durga_karvep18 = new LatLng(18.5104375, 73.8161808);


                        mMap.addMarker(new MarkerOptions()
                                .position(durga_karvep1));

                        mMap.addMarker((new MarkerOptions()
                                .position(durga_karvep18)));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole1)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole2)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addMarker((new MarkerOptions()
                                .position(pothole3)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));

                        mMap.addPolyline((new PolylineOptions()).add(durga_karvep1,durga_karvep2,durga_karvep3,durga_karvep4,durga_karvep5,durga_karvep6,
                                        durga_karvep7,durga_karvep8,durga_karvep9,durga_karvep10,durga_karvep11,durga_karvep12,durga_karvep13,durga_karvep14,durga_karvep15,
                                        durga_karvep16, durga_karvep17, durga_karvep18).
                                // below line is use to specify the width of poly line.
                                        width(15)
                                // below line is use to add color to our poly line.
                                .color(Color.YELLOW)
                                // below line is to make our poly line geodesic.
                                .geodesic(true));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(durga_karvep1,15));
                        // Zoom in, animating the camera.
                        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

                    }
                }



            }
        });


    }
}
