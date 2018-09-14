package com.emedinaa.myfirstapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.listeners.OnContactListener;
import com.emedinaa.myfirstapp.model.ContactEntity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {} factory method to
 * create an instance of this fragment.
 */
public class ContactDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnContactListener mListener;
    private ImageView iviContact;
    private TextView tviName;
    private TextView tviPhone;
    private TextView tviEmail;
    private TextView tviGroup;


    public ContactDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactDetailFragment newInstance(String param1, String param2) {
        ContactDetailFragment fragment = new ContactDetailFragment();
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
        View view= inflater.inflate(R.layout.fragment_contact_detail, container, false);
        ui(view);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContactListener) {
            mListener = (OnContactListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnContactListener");
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
    }

    private void ui(View view) {
        iviContact=(ImageView)view.findViewById(R.id.iviContact);
        tviName=(TextView)view.findViewById(R.id.tviName);
        tviPhone=(TextView)view.findViewById(R.id.tviPhone);
        tviEmail=(TextView)view.findViewById(R.id.tviEmail);
        tviGroup=(TextView)view.findViewById(R.id.tviGroup);
    }

    public void renderContact(ContactEntity contactEntity){
        String name= contactEntity.getName();
        String phone= contactEntity.getPhone();
        String email= contactEntity.getEmail();
        String group= contactEntity.getGroup();

        tviName.setText(name);
        tviPhone.setText(phone);
        tviEmail.setText(email);
        tviGroup.setText(group);
        iviContact.setImageResource(contactEntity.getPhoto());
    }

}
