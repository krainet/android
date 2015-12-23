package com.walladog.walladog.controllers.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.walladog.walladog.R;
import com.walladog.walladog.controllers.adapters.ProductListAdapter;
import com.walladog.walladog.model.WDServices;

/**
 * Created by hadock on 14/12/15.
 *
 */

public class WDServiceFragment extends Fragment  {

    private static final String TAG = MainFragment.class.getName();

    public static final String ARG_WDSERVICE = null;
    private WDServices wdservice;

    private static TextView serviceTitle = null;
    private static ImageView serviceImage = null;


    public static WDServiceFragment newInstance(WDServices service) {
        WDServiceFragment fragment = new WDServiceFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_WDSERVICE, service);
        fragment.setArguments(args);
        return fragment;
    }

    public WDServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            wdservice = (WDServices) getArguments().getSerializable(ARG_WDSERVICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_service, container, false);

        // Linking with view
        serviceTitle = (TextView) root.findViewById(R.id.txt_service_title);
        serviceImage = (ImageView) root.findViewById(R.id.img_service3);

        // Sync view & model
        serviceTitle.setText(wdservice.getName());
        Picasso.with(getActivity().getApplicationContext())
                .load(wdservice.getServiceImage())
                .placeholder(R.drawable.walladogt)
                .into(serviceImage);

        serviceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Click on Services");
/*                Intent i = new Intent(getActivity().getApplicationContext(), AddProductActivity.class);
                startActivity(i);*/
                getParentFragment().getFragmentManager().beginTransaction()
                        .addToBackStack(WDServiceFragment.class.getName())
                        .replace(R.id.container, ProductListFragment.newInstance())
                        .commit();

            }
        });
        return root;
    }


}
