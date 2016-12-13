package com.hangapps.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hangapps.herome.Activities.MainActivity;
import com.hangapps.herome.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackstoryFragment.BackstoryInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackstoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackstoryFragment extends Fragment {

    private Button primaryBtn;
    private Button secondaryBtn;
    private Button startOverBtn;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private BackstoryInteractionListener mListener;

    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);
        // Inflate the layout for this fragment
        primaryBtn = (Button)view.findViewById(R.id.primaryBtn);
        secondaryBtn = (Button)view.findViewById(R.id.secondaryBtn);
        startOverBtn = (Button)view.findViewById(R.id.startOverBtn);

        int primaryPower = populatePrimaryBtn(primaryBtn);
        populateSecondaryBtn(secondaryBtn, primaryPower);

        startOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity)getActivity();
                ma.loadMainFragment();

            }
        });

        return view;
    }


    private int populatePrimaryBtn(Button primaryBtn) {
        MainActivity ma = (MainActivity)getActivity();
        int leftDrawable = 0;
        String buttonText = "";
        int primaryPower = 0;

        if(ma.getPowerSeleceted() != null || !ma.getPowerSeleceted().isEmpty()) {
            switch (ma.getPowerSeleceted()) {
                case MainActivity.POWER_TURTLE:
                    leftDrawable = R.drawable.turtlepower;
                    buttonText = "Turtle Power";
                    primaryPower = 1;
                    break;
                case MainActivity.POWER_LIGHTNING:
                    leftDrawable = R.drawable.thorshammer;
                    buttonText = "Lightning";
                    primaryPower = 2;
                    break;
                case MainActivity.POWER_FLIGHT:
                    leftDrawable = R.drawable.supermancrest;
                    buttonText = "Flight";
                    primaryPower = 3;
                    break;
                case MainActivity.POWER_WEB_SLINGING:
                    leftDrawable = R.drawable.spiderweb;
                    buttonText = "Web Slinging";
                    primaryPower = 4;
                    break;
                case MainActivity.POWER_LASER_VISION:
                    leftDrawable = R.drawable.laservision;
                    buttonText = "Laser Vision";
                    primaryPower = 5;
                    break;
                case MainActivity.POWER_SUPER_STRENGTH:
                    leftDrawable = R.drawable.superstrength;
                    buttonText = "Super Strength";
                    primaryPower = 6;
                    break;
            }
            primaryBtn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.itemunselected, 0);
            primaryBtn.setText(buttonText);

        }
        return primaryPower;
    }

    private void populateSecondaryBtn(Button secondaryBtn, int primaryPower) {
        if(primaryPower != 0){
            int[] numbers = {1,2,3,4,5,6};
            ArrayList options = new ArrayList();
            for (int i = 0; i < numbers.length ; i++) {
                options.add(numbers[i]);
            }
            options.remove(options.indexOf(primaryPower));
            Random r = new Random();
            int index = r.nextInt(options.size()-1);
            int secondaryPower = Integer.parseInt(options.get(index).toString());

            int leftDrawable = 0;
            String buttonText = "";
            switch (secondaryPower){
                case 1:
                    leftDrawable = R.drawable.turtlepower;
                    buttonText = "Turtle Power";
                    break;
                case 2:
                    leftDrawable = R.drawable.thorshammer;
                    buttonText = "Lightning";
                    break;
                case 3:
                    leftDrawable = R.drawable.supermancrest;
                    buttonText = "Flight";
                    break;
                case 4:
                    leftDrawable = R.drawable.spiderweb;
                    buttonText = "Web Slinging";
                    break;
                case 5:
                    leftDrawable = R.drawable.laservision;
                    buttonText = "Laser Vision";
                    break;
                case 6:
                    leftDrawable = R.drawable.superstrength;
                    buttonText = "Super Strength";
                    break;
            }
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.itemunselected, 0);
            secondaryBtn.setText(buttonText);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackstoryInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackstoryInteractionListener) {
            mListener = (BackstoryInteractionListener) context;
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
    public interface BackstoryInteractionListener {
        // TODO: Update argument type and name
        void onBackstoryInteraction(Uri uri);
    }
}
