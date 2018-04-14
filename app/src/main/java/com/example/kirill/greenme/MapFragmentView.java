package com.example.kirill.greenme;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.ViewObject;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapGesture;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;
import com.nokia.maps.restrouting.GeoCoordinate;

import java.io.File;
import java.io.IOException;
import java.util.List;
//import java.util.Map;

public class MapFragmentView {
    private MapFragment m_mapFragment;
    private Activity m_activity;
    private Map m_map;

    public MapFragmentView(Activity activity) {
        m_activity = activity;
        initMapFragment();
        addPoints();
    }


    private void initMapFragment() {
        /* Locate the mapFragment UI element */
        m_mapFragment = (MapFragment) m_activity.getFragmentManager()
                .findFragmentById(R.id.mapfragment);

        m_mapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(
                    OnEngineInitListener.Error error) {
                if (error == OnEngineInitListener.Error.NONE) {
// now the map is ready to be used
                    m_mapFragment.getMapGesture().addOnGestureListener(new MyOnGestureListener());
                    m_map = m_mapFragment.getMap();


                    MapMarker point = new MapMarker();

//                    com.here.android.mpa.common.Image image = new Image();
//                    try {
//                        image.setImageResource(R.drawable.question);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    point.setCoordinate(new com.here.android.mpa.common.GeoCoordinate(59.965899, 30.304310));
//                    point.setIcon(image);
                    while (m_map == null) {
                        Log.v("ERROR", "MAP");
                    }
                    if (point == null) {
                        Log.v("ERROR", "POINT");
                    }
                    m_map.addMapObject(point);
//                    m_map = map;
                    m_map.setCenter(new com.here.android.mpa.common.GeoCoordinate(59.965899, 30.304310), Map.Animation.NONE);
// ...

                } else {
                    System.out.println("ERROR: Cannot initialize MapFragment");
                }
            }
        });


//        // Set path of isolated disk cache
//        String diskCacheRoot = Environment.getExternalStorageDirectory().getPath()
//                + File.separator + ".isolated-here-maps";
//        // Retrieve intent name from manifest
//        String intentName = "";
//        try {
//            ApplicationInfo ai = m_activity.getPackageManager().getApplicationInfo(m_activity.getPackageName(),
//                    PackageManager.GET_META_DATA);
//            Bundle bundle = ai.metaData;
//            intentName = bundle.getString("INTENT_NAME");
//        } catch (PackageManager.NameNotFoundException e) {
//            Log.e(this.getClass().toString(), "Failed to find intent name, NameNotFound: " + e.getMessage());
//        }
//
//        boolean success = com.here.android.mpa.common.MapSettings.setIsolatedDiskCacheRootPath(diskCacheRoot,
//                intentName);
//        if (!success) {
//            // Setting the isolated disk cache was not successful, please check if the path is valid and
//            // ensure that it does not match the default location
//            // (getExternalStorageDirectory()/.here-maps).
//            // Also, ensure the provided intent name does not match the default intent name.
//        } else {
//            if (m_mapFragment != null) {
//                /* Initialize the MapFragment, results will be given via the called back. */
//                m_mapFragment.init(new OnEngineInitListener() {
//                    @Override
//                    public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {
//                        Toast.makeText(m_activity, "RUN", Toast.LENGTH_LONG).show();
//                        if (error == Error.NONE) {
//                            /*
//                             * If no error returned from map fragment initialization, the map will be
//                             * rendered on screen at this moment.Further actions on map can be provided
//                             * by calling Map APIs.
//                             */
//                            m_map = m_mapFragment.getMap();
//
//                            /*
//                             * Map center can be set to a desired location at this point.
//                             * It also can be set to the current location ,which needs to be delivered by the PositioningManager.
//                             * Please refer to the user guide for how to get the real-time location.
//                             */
//
//                           // m_map.setCenter(new GeoCoordinate(49.258576, -123.008268), Map.Animation.NONE);
//                        } else {
////                            Toast.makeText(m_activity,
////                                    "ERROR: Cannot initialize Map with error " + error,
////                                    Toast.LENGTH_LONG).show();
//                            Log.v("error", error.toString());
//                        }
//                    }
//                });
//            }
//        }
    }

    private void addPoints() {
    }
}
