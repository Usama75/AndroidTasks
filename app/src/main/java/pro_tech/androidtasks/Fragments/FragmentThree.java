package pro_tech.androidtasks.Fragments;


import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;

import pro_tech.androidtasks.Config;
import pro_tech.androidtasks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {

    private String path1="EPfepz_aAgU";
  //  private FragmentActivity myContext;
    private YouTubePlayer YPlayer;
    //@Override
    public void onAttach(Activity activity) {

       /* if (activity instanceof FragmentActivity) {
            myContext = (FragmentActivity) activity;
        }*/

        super.onAttach(activity);
    }

    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(Config.DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {

                    // youTubePlayer.loadVideo("Z6szMwKsoX4");
                    YPlayer = youTubePlayer;
//                    YPlayer.loadVideo(path1);

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                // TODO Auto-generated method stub

            }
        });


            return view;
        }


    }

