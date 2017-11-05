package com.example.megan.facebookapipoc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {

    private ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Bundle inBundle = getIntent().getExtras();
//        String name = inBundle.get("name").toString();
//        String surname = inBundle.get("surname").toString();
//        String imageUrl = inBundle.get("imageUrl").toString();
//
//        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
//        nameView.setText("" + name + " " + surname);
//
//        new DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageUrl);

        shareDialog = new ShareDialog(this);

        Button post = (Button) findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .setQuote("Hey, I'm looking to rent an iron. If anyone has one I can use, let me know through HotSwap!")
                        .build();
                shareDialog.show(content);
            }
        });

        FacebookSdk.sdkInitialize(getApplicationContext());

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });
    }
}
