package com.emedinaa.myfirstapp.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by emedinaa on 15/09/15.
 */
public class MyDialogFragment extends DialogFragment {

    private MyDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String title = getArguments().getString("TITLE");
        final int type = getArguments().getInt("TYPE");

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //((MyDialogListener)getActivity()).onPositiveListener(null,type);
                                if(listener!=null){
                                    listener.onPositiveListener(null,type);
                                }

                            }
                        }
                )
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                if(listener!=null){
                                   listener.onNegativeListener(null,type);
                                }
                                //((MyDialogListener)getActivity()).onNegativeListener(null,type);
                            }
                        }
                )
                .create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MyDialogListener){
            listener= (MyDialogListener)(context);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
