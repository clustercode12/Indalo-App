package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TestimoniesActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private YouTubePlayer youTubePlayer;
    private String url1 = "tompq_2IE0o", url2 = "DRk7mdBQMXU";
    private Class classBack, classNext;
    private Button btNextVideo, btPreviousVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonies);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_testimonies);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_products));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setVisibility(View.GONE);

        youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        btNextVideo = findViewById(R.id.button);
        btPreviousVideo = findViewById(R.id.button2);
        btPreviousVideo.setVisibility(View.GONE);
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            if(youTubePlayer == null){
                youTubePlayer = player;
                youTubePlayer.loadVideo(url1);
            }
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

    public void btNextVideoClicked (View v){
        btNextVideo.setVisibility(View.GONE);
        btPreviousVideo.setVisibility(View.VISIBLE);

        if(youTubePlayer != null){
            youTubePlayer.loadVideo(url2);
        }
    }

    public void btPreviousVideoClicked (View v) {
        btNextVideo.setVisibility(View.VISIBLE);
        btPreviousVideo.setVisibility(View.GONE);

        if(youTubePlayer != null){
            youTubePlayer.loadVideo(url1);
        }
    }
}
