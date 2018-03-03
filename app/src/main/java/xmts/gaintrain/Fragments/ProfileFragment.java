package xmts.gaintrain.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xmts.gaintrain.Models.Passenger;
import xmts.gaintrain.R;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends android.support.v4.app.Fragment {

    private Passenger mPassenger;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * newInstance method
     * @param p
     * @return
     */
    public static ProfileFragment newInstance(Passenger p) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        fragment.mPassenger = p;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView username = (TextView) view.findViewById(R.id.profileUserName);
        username.setText(mPassenger.getUsername());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

}
