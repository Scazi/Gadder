package be.ap.eaict.gadder.DOM;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by joeri on 28/12/2017.
 */

public class FBRepository implements IRepository {
    private static FBRepository repo = null;
    private List<Event> eventCache;

    public static FBRepository getInstance() {
        if (repo == null) {
            repo = new FBRepository();
        }
        return repo;
    }

    public FBRepository(){
        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();
        List<Event> events = new ArrayList<>();

        //Events
        events.add(new Event(0, "Stuff", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(1, "Things", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(2, "firebaserepo", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(3, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(4, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(5, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(6, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(7, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(8, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(9, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(10, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(11, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(12, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(13, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));

        fbdb.getReference("events").setValue(events);
        DatabaseReference ref = fbdb.getReference("events");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Event> reply = new ArrayList<Event>();
                for (DataSnapshot event :dataSnapshot.getChildren()){
                    reply.add(event.getValue(Event.class));
                }
                FBRepository.getInstance().updateEventCache(reply);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public List<Event> getEvents() {
        return eventCache;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<Place> getPlaces() {
        return null;
    }

    @Override
    public List<UsersPerEvent> getUsersPerEvents() {
        return null;
    }

    @Override
    public List<FriendsPerUser> getFriendsPerUsers() {
        return null;
    }

    @Override
    public List<EventdatePerUser> getEventdatePerUsers() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void createEvent(Event event) {

    }

    @Override
    public void updateEvent(Event event) {

    }

    //
    public void updateEventCache(List<Event> eList){
        eventCache = eList;
    }

}
