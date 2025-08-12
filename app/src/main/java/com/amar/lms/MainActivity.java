package com.amar.lms;

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

        // Example path: /sdcard/AmarLMS/Maths/Numbers/video1.mp4
        File videoFile = new File("/sdcard/AmarLMS/5thScience/video1.mp4");
        if (videoFile.exists()) {
            MediaItem item = MediaItem.fromUri(Uri.fromFile(videoFile));
            player.setMediaItem(item);
            player.prepare();
            player.play();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) player.release();
    }
}
