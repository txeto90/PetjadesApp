package com.example.petjadesapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.petjadesapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoadActivity extends Activity {

    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

       mAuth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            boolean logOutInfo = extras.getBoolean("logOutInfo");
            if(logOutInfo){
                signOut();
            }
        }else{
            if(mAuth.getCurrentUser() != null){
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }

    public void signIn(View v){

        mAuth = FirebaseAuth.getInstance();
        LoadActivity instance = this;
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(instance, MainActivity.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoadActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });

    }


    public void signOut(){
        mAuth.signOut();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast toast = Toast.makeText(this.getApplicationContext(), R.string.error_connection, Toast.LENGTH_LONG);
                toast.show();

            }
        }
    }

    //posar en totes activities
    @Override
    public void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        final LoadActivity instance = this;
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(instance, MainActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast toast = Toast.makeText(getApplicationContext(), R.string.error_connection, Toast.LENGTH_LONG);
                            toast.show();
                            Snackbar.make(findViewById(R.id.lyloadActivity), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
