package com.example.amarlms;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    private PlayerView playerView;
    private ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.player_view);
        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        // Path to offline video on external storage
        File videoFile = new File("/sdcard/AmarLMS/5thScience/video1.mp4");
        if (videoFile.exists()) {
            Uri uri = Uri.fromFile(videoFile);
            MediaItem mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);
            player.prepare();
            player.play();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.release();
    }
}
