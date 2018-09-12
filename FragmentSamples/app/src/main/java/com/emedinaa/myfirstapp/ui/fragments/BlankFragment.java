package com.emedinaa.myfirstapp.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private BlankFragmentListener mListener;
    private View frameLayout;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        frameLayout= view.findViewById(R.id.frameLayout);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BlankFragmentListener) {
            mListener = (BlankFragmentListener) context;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView textViewMessage=getView().findViewById(R.id.textViewMessage);
        textViewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Mensaje desde Fragment",Toast.LENGTH_LONG).show();
            }
        });

        if(mListener!=null){
            mListener.loQueYoQuiera();
        }

        //((FragmentCommunicationActivity)getActivity()).otroMetodo();
        //FragmentCommunicationActivity.otroSuperMetodo();

        //( (FragmentBasicActivity)(getActivity())).llamarAPapa2();
        //FragmentBasicActivity.llamarAPapa();

        /*getView().findViewById(R.id.textViewMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Mensaje desde Fragment",Toast.LENGTH_LONG).show();

                //Enviar a la Activity
                //((FragmentCommunicationActivity)getActivity()).otroMetodo();
                if(mListener!=null){

                    //mListener.actionFragment("Mensaje desde Fragment a Activity");
                    mListener.actionActivityCambiarColor();
                }
            }
        });*/

        //Toast.makeText(getActivity(),"Hola desde fragment ",Toast.LENGTH_LONG).show();
        /*Log.v("CONSOLE", "1. BlankFragment");
        if(mListener!=null){
            Log.v("CONSOLE", "2. Enviar desde BlankFragment");
            mListener.callToActivity("Lo que sea ");
        }*/
    }

    public void ejecutarAccionDesdeFragment(String message){
        Toast.makeText(getActivity(),"Fragment "+message,Toast.LENGTH_LONG).show();
    }

    public void cambiarColorFondo(){
        Log.v("CONSOLE", "(2) 1" +
                "2 a BlankFragment");
        //getView().findViewById(R.id.frameLayout).setBackgroundColor(Color.GREEN);
        frameLayout.setBackgroundColor(Color.GREEN);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
