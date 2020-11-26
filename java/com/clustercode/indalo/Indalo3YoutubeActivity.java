package com.clustercode.indalo;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Indalo3YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private String url;
    private Class classBack, classNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        String textBack = getIntent().getStringExtra("textBack");
        String textNext = getIntent().getStringExtra("textNext");
        classBack = (Class) getIntent().getExtras().get("classBack");
        classNext = (Class) getIntent().getExtras().get("classNext");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_youtube);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(title);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), classBack);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(textBack);
        if (!textNext.isEmpty()) {
            ImageButton btNext = findViewById(R.id.btNext);
            btNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), classNext);
                    startActivity(intent);
                    finish();
                }
            });

            TextView txtNext = findViewById(R.id.txtNext);
            txtNext.setText(textNext);
        }

        youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.loadVideo(url);
            player.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format("Hubo un error cargando el video.", errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
}
