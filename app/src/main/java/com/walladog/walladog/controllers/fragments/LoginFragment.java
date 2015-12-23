package com.walladog.walladog.controllers.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.walladog.walladog.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by hadock on 19/12/15.
 *
 */

public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.getName();

    @Bind(R.id.email)
    TextView userEmail;

    @Bind(R.id.password)
    TextView userPassword;

    @Bind(R.id.email_sign_in_button)
    Button btnLogin;

    private OnLoginClickListener mOnLoginClickListener=null;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    public LoginFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View root = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,root);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnLoginClickListener != null) {
                    mOnLoginClickListener.onLoginSubmit(userEmail.getText().toString(), userPassword.getText().toString(),root);
                }
                Log.v("RAMON", "click");
            }
        });

        return root;
    }

    public interface OnLoginClickListener {
        void onLoginSubmit(String username, String password,View currentView);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mOnLoginClickListener = (OnLoginClickListener)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnLoginClickListener = null;
    }
}
