package com.emedinaa.myfirstapp.fragments.listener;

import com.emedinaa.myfirstapp.model.NoteBLEntity;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {


     void editNoteNetwork(NoteBLEntity noteEntity);
     void deleteNoteNetwork(NoteBLEntity noteEntity);

     void showLoading();
     void hideLoading();
}
