package pro_tech.androidtasks.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import pro_tech.androidtasks.Models.FragmentoneModel;
import pro_tech.androidtasks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private List<FragmentoneModel> datalist;
    private FloatingActionButton floatingActionButton;
    private ProgressDialog progressDialog;
    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("Video");
//        progressDialog.setMessage("Loading ...");
//        progressDialog.show();
        datalist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        floatingActionButton =  view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getActivity() , ActivityFour.class);
                startActivity(intent);
//            ActivityFour fragmentFour = new ActivityFour();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container,fragmentFour).addToBackStack(null).commit();
                }
        });
        getdata();
        return view;
    }
        private void getdata(){
//            Query lastQuery = .orderByKey().limitToLast(mCurrent*Total_item_load);

            //attaching value event listener
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    datalist.clear();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        FragmentoneModel model = postSnapshot.getValue(FragmentoneModel.class);
                        datalist.add(model);
//                        progressDialog.cancel();
                    }
                    Collections.reverse(datalist);
                    //creating adapter
                    FragmentoneAdapter fragmentoneAdapter = new FragmentoneAdapter(datalist, getActivity());
                    //attaching adapter to the listview
                    recyclerView.setAdapter(fragmentoneAdapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }


