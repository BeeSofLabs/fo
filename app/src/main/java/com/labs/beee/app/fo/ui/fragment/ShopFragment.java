package com.labs.beee.app.fo.ui.fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.labs.beee.app.fo.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.io.IOException;
import java.util.List;

import app.beelabs.com.codebase.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.labs.beee.app.fo.ui.adapter.MenuShopAdapter;

/**
 * Created by ary on 6/20/17.
 */

public class ShopFragment extends BaseFragment implements OnMapReadyCallback {
    @BindView(R.id.shop_add)
    ImageView shopAdd;
    @BindView(R.id.menu_add)
    ImageView menuAdd;
    @BindView(R.id.list_menu)
    RecyclerView recyclerView;

    private String mLastQuery = "";
    private GoogleMap gMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, layout);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Shop");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new MenuShopAdapter(getActivity()));

        SupportMapFragment mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);


        shopAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialog = DialogPlus.newDialog(getContext())
                        .setContentHolder(new ViewHolder(R.layout.partial_dialog_shop_form))
//                .setCancelable(true)
//                .setGravity(gravity)
//                .setAdapter(adapter)
//                .setOnClickListener(dialogOnClick)
                .setExpanded(false)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();
                dialog.show();
            }
        });

        menuAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialog = DialogPlus.newDialog(getContext())
                        .setContentHolder(new ViewHolder(R.layout.partial_dialog_shopmenu_form))
//                .setCancelable(true)
//                .setGravity(gravity)
//                .setAdapter(adapter)
                .setExpanded(false)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .create();
                dialog.show();
            }
        });


        return layout;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        showGoogleMapLocation("Jakarta", false);

        gMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                gMap.clear();
                createMarker(gMap, latLng, true, "Dropbox", R.mipmap.ic_place_black_24dp);
            }
        });
    }

    public void createMarker(GoogleMap googleMap, LatLng place, boolean centerilize, String label, int resourceIconId) {
        Marker marker = null;
        if (resourceIconId > 0) {
            marker = googleMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(resourceIconId))
                    .position(place).title(label));
            marker.showInfoWindow();
        }

        if (centerilize) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place, 15f));
        }
    }

    public void showGoogleMapLocation(String query, boolean withMarker) {
        Geocoder geoCoder = new Geocoder(getContext());
        List<Address> addresses;

        gMap.clear();
        try {
            addresses = geoCoder.getFromLocationName(query, 1);
            if (addresses.size() > 0) {
                Double lat = (double) (addresses.get(0).getLatitude());
                Double lon = (double) (addresses.get(0).getLongitude());

                final LatLng latLng = new LatLng(lat, lon);

                if (withMarker)
                    createMarker(gMap, latLng, true, "DROPBOX", R.mipmap.ic_place_black_24dp);
                else createMarker(gMap, latLng, true, null, 0);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
