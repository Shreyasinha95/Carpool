package com.team43.carpool;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import github.chenupt.springindicator.SpringIndicator;

public class SignIn extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_in);


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        SpringIndicator springIndicator = (SpringIndicator)findViewById(R.id.indicator);
        springIndicator.setViewPager(mViewPager);


        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String userId = loginResult.getAccessToken().getUserId();
                String token = loginResult.getAccessToken().getToken();

                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();

                // Facebook Email address
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                Log.v("LoginActivity Response ", response.toString());

                                try {
                                    name = object.getString("name");

                                    String FEmail = object.getString("email");
                                    Log.v("Email = ", " " + FEmail);
                                    Toast.makeText(getApplicationContext(), "Name " + name, Toast.LENGTH_LONG).show();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
                Toast.makeText(SignIn.this, "Successfully Logged in!"+name,
                        Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(SignIn.this,MyProfile.class);
                startActivity(intent1);
            }

            @Override
            public void onCancel() {
                Toast.makeText(SignIn.this, "Login attempt canceled.",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(SignIn.this, "Login attempt failed.",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Bind the title indicator to the adapter
       // CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.titles);
        //circlePageIndicator.setViewPager(mViewPager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
