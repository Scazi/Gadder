package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import be.ap.eaict.gadder.Adapters.InvitationAdapter;
import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.FBRepository;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        populateList();
    }

    /*public void onResume(){
        super.onResume();
        populateList();
    }*/

    public void populateList(){
        final ListView friendInviteList = (ListView) findViewById(R.id.inviteFriendsInEventList);

        InvitationAdapter invitationAdapter = new InvitationAdapter(this, FBRepository.getInstance().getUsers());
        friendInviteList.setAdapter(invitationAdapter);
    }

    public void onClickEdit(View view){
        openEditActivity();
    }

    public void openEditActivity(){
        Intent intent = new Intent(DetailsActivity.this, EditActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }

    public void dateAvailableList(View view){
        Intent intent = new Intent(DetailsActivity.this, DateSelectActivity.class);
        startActivity(intent);
    }
}
