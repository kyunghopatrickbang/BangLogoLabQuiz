package com.bang.logolabquiz;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputUserName, inputPassword;
    Button remember, login;
    SharedPreferences preferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUserName = (EditText) findViewById(R.id.editText);
        inputPassword = (EditText) findViewById(R.id.editText2);
        remember = (Button) findViewById(R.id.btnremember);
        login = (Button) findViewById(R.id.btnlogin);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void rememberMe(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", inputUserName.getText().toString());
        editor.putString("password", inputPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }


    public void nextActivity(View view) {
        String username = String.valueOf(inputUserName.getText());
        String password = String.valueOf(inputPassword.getText());

        // Validates the User name and Password for admin, admin
        if (username.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
        }
    }
}