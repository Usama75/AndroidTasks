package pro_tech.androidtasks.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pro_tech.androidtasks.Adapter.FragmentFourAdapter;
import pro_tech.androidtasks.Models.FragmentFourModel;
import pro_tech.androidtasks.R;


public class ActivityFour extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private List<FragmentFourModel> datalist;

    public ActivityFour() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment_four);
        databaseReference = FirebaseDatabase.getInstance().getReference("Pranks").child("Urdu").child("p4 pakao");
        datalist = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false));
        getdata();

    }

    private void getdata(){
//            Query lastQuery = .orderByKey().limitToLast(mCurrent*Total_item_load);

        //attaching value event listener
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datalist.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FragmentFourModel model = postSnapshot.getValue(FragmentFourModel.class);
                    datalist.add(model);
                }
                Collections.reverse(datalist);
                //creating adapter
                FragmentFourAdapter fragmentFourAdapter = new FragmentFourAdapter(datalist, ActivityFour.this);
                //attaching adapter to the listview
                recyclerView.setAdapter(fragmentFourAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
