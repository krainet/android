package com.walladog.walladog.controller.fragments;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.walladog.walladog.R;
import com.walladog.walladog.controller.activities.AddProductActivity;
import com.walladog.walladog.model.Services;


public class ServiceFragment extends Fragment {

    private static final String TAG = MainFragment.class.getName();

    public static final String ARG_WDSERVICE = null;
    private Services wdservice;

    private static TextView serviceTitle = null;
    private static ImageView serviceImage = null;

    private OnFragmentInteractionListener mListener;

    public static ServiceFragment newInstance(Services service) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_WDSERVICE, service);
        fragment.setArguments(args);
        return fragment;
    }

    public ServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            wdservice = (Services) getArguments().getSerializable(ARG_WDSERVICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_service, container, false);

        // Linking with view
        serviceTitle = (TextView) root.findViewById(R.id.txt_service_title);
        serviceImage = (ImageView) root.findViewById(R.id.img_service2);

        // Sync view & model
        serviceTitle.setText(wdservice.getName());
        Picasso.with(getActivity().getApplicationContext())
                .load(wdservice.getServiceImage())
                .placeholder(R.drawable.walladogt)
                .into(serviceImage);

        serviceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Click");
                Intent i = new Intent(getActivity().getApplicationContext(), AddProductActivity.class);
                startActivity(i);
            }
        });

        return root;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
