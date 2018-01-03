package com.example.wenjie.mediaplayerdm.onLineViedio;

import android.app.Fragment;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.example.wenjie.mediaplayerdm.R;

/**
 * Created by wen.jie on 2018/1/2.
 */

public class OnLinePlayFragment extends Fragment {
    private static final String TAG = "OnLinePlayFragment";
    private View mFragmentView;
    private SurfaceView mSurfaceView;


    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mHolder;
    private AudioManager mAudioManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_on_line, container, false);
        return mFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initPlayer();
    }

    private void initView() {
        mSurfaceView = mFragmentView.findViewById(R.id.surface_view);
    }

    private void initPlayer() {
        mMediaPlayer = new MediaPlayer();
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mMediaPlayer.setDisplay(holder);
            ;
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {

                    }
                });
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
      //  mMediaPlayer = new MediaPlayer();

    }
}