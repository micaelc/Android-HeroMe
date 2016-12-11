package com.hangapps.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;

import com.hangapps.herome.Activities.MainActivity;
import com.hangapps.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webSlingingBtn;
    private Button laserVisionBtn;
    private Button superStrengthBtn;
    private Button backstoryBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        // Inflate the layout for this fragment

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webSlingingBtn = (Button)view.findViewById(R.id.webSlingingBtn);
        laserVisionBtn = (Button)view.findViewById(R.id.laserVisionBtn);
        superStrengthBtn= (Button)view.findViewById(R.id.superStrengthBtn);
        backstoryBtn = (Button)view.findViewById(R.id.backstoryBtn);

        // set Show Backstory Button to disable
        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webSlingingBtn.setOnClickListener(this);
        laserVisionBtn.setOnClickListener(this);
        superStrengthBtn.setOnClickListener(this);

        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity)getActivity();
                ma.loadBackstoryScreen();
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
    @Override
    public void onClick(View view){

        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        // reset the buttons
        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower,0,R.drawable.itemunselected,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thorshammer,0,R.drawable.itemunselected,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.supermancrest,0,R.drawable.itemunselected,0);
        webSlingingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,R.drawable.itemunselected,0);
        laserVisionBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision,0,R.drawable.itemunselected,0);
        superStrengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength,0,R.drawable.itemunselected,0);

        //grab the view
        Button btn = (Button)view;
        int leftDrawable = 0;

        MainActivity mainActivity = (MainActivity)getActivity();

        // see witch button is pressed and manage the selected drawable
        if (btn == turtleBtn){
            leftDrawable = R.drawable.turtlepower;
            mainActivity.setPowerSeleceted(MainActivity.POWER_TURTLE);
        } else if (btn == lightningBtn){
            leftDrawable = R.drawable.thorshammer;
            mainActivity.setPowerSeleceted(MainActivity.POWER_LIGHTNING);
        } else if (btn == flightBtn){
            leftDrawable = R.drawable.supermancrest;
            mainActivity.setPowerSeleceted(MainActivity.POWER_FLIGHT);
        } else if (btn == webSlingingBtn){
            leftDrawable = R.drawable.spiderweb;
            mainActivity.setPowerSeleceted(MainActivity.POWER_WEB_SLINGING);
        } else if (btn == laserVisionBtn){
            leftDrawable = R.drawable.laservision;
            mainActivity.setPowerSeleceted(MainActivity.POWER_LASER_VISION);
        } else if (btn == superStrengthBtn){
            leftDrawable = R.drawable.superstrength;
            mainActivity.setPowerSeleceted(MainActivity.POWER_SUPER_STRENGTH);
        }

        //setting the clicked button
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);
    }
}
