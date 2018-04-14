package com.example.kirill.greenme;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.util.Log;

import com.here.android.mpa.common.ViewObject;
import com.here.android.mpa.mapping.MapGesture;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;

import java.util.List;

public class MyOnGestureListener implements MapGesture.OnGestureListener {

    private Context context;

    MyOnGestureListener(Context mContext) {
        super();
        context = mContext;
    }

    @Override
    public void onPanStart() {

    }

    @Override
    public void onPanEnd() {

    }

    @Override
    public void onMultiFingerManipulationStart() {

    }

    @Override
    public void onMultiFingerManipulationEnd() {

    }

    @Override
    public boolean onMapObjectsSelected(List<ViewObject> list) {
        for (ViewObject viewObject : list) {
            if (viewObject.getBaseType() == ViewObject.Type.USER_OBJECT) {
                MapObject mapObject = (MapObject) viewObject;

                if (mapObject.getType() == MapObject.Type.MARKER) {

                    MapMarker window_marker = ((MapMarker) mapObject);

                    runIntent(window_marker);

                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean onTapEvent(PointF pointF) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(PointF pointF) {
        return false;
    }

    @Override
    public void onPinchLocked() {

    }

    @Override
    public boolean onPinchZoomEvent(float v, PointF pointF) {
        return false;
    }

    @Override
    public void onRotateLocked() {

    }

    @Override
    public boolean onRotateEvent(float v) {
        return false;
    }

    @Override
    public boolean onTiltEvent(float v) {
        return false;
    }

    @Override
    public boolean onLongPressEvent(PointF pointF) {
        return false;
    }

    @Override
    public void onLongPressRelease() {

    }

    @Override
    public boolean onTwoFingerTapEvent(PointF pointF) {
        return false;
    }

    private void runIntent(MapMarker marker) {
        String s = marker.getDescription();
        if (s.equals("plant_tree")) {

        }
        if (s.equals("plant_flower")) {
            Intent intent = new Intent(context, FlowerAnimation.class);
            context.startActivity(intent);
        }
        if (s.equals("water_tree")) {

        }
        if (s.equals("water_flower")) {

        }
    }
}
