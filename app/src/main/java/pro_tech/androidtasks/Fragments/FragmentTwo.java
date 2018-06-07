package pro_tech.androidtasks.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import pro_tech.androidtasks.Adapter.FragmentoneAdapter;
import pro_tech.androidtasks.Adapter.FragmenttwoAdapter;
import pro_tech.androidtasks.Models.FragmentoneModel;
import pro_tech.androidtasks.R;

public class FragmentTwo extends Fragment {


    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private List<FragmentoneModel> datalist;

    public FragmentTwo() {
        // Required empty public constructor
    }
  

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("Video");
        datalist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getdata();

        return view;
    }

    private void getdata(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datalist.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FragmentoneModel model = postSnapshot.getValue(FragmentoneModel.class);
                    datalist.add(model);
                }
                Collections.reverse(datalist);
                //creating adapter
                FragmenttwoAdapter fragmenttwoAdapter = new FragmenttwoAdapter(datalist, getActivity());
                //attaching adapter to the listview
                recyclerView.setAdapter(fragmenttwoAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
