package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.emedinaa.myfirstapp.fragments.ContactDetailFragment;
import com.emedinaa.myfirstapp.fragments.ContactsFragment;
import com.emedinaa.myfirstapp.listeners.OnContactListener;
import com.emedinaa.myfirstapp.model.ContactEntity;

public class ContactsActivity extends AppCompatActivity implements OnContactListener {

    private static final String TAG = "Contacts";

    private ContactsFragment contactsFragment;
    private ContactDetailFragment contactDetailFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        app();
    }

    private void app() {
        fragmentManager= getSupportFragmentManager();
        contactsFragment= (ContactsFragment)fragmentManager.findFragmentById(R.id.fragContacts);
        contactDetailFragment= (ContactDetailFragment) fragmentManager.findFragmentById(R.id.fragContactDetail);

    }


    @Override
    public void onSendMessage(String msg) {

    }

    @Override
    public void selectedItemContact(ContactEntity contactEntity) {
        contactDetailFragment.renderContact(contactEntity);
    }

    @Override
    public void renderFirst(ContactEntity contactEntity) {
        selectedItemContact(contactEntity);
    }
}
