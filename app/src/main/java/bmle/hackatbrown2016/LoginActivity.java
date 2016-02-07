package bmle.hackatbrown2016;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import android.content.Context;
import android.database.Cursor;

public class LoginActivity extends ActionBarActivity {
    Button Login;
    EditText USERNAME, USERPASS;
    String username,userpass;
    Context CTX = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = (Button) findViewById(R.id.bLogin);
        USERNAME = (EditText)findViewById(R.id.Username);
        USERPASS = (EditText)findViewById(R.id.Password);
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Bundle b = getIntent().getExtras();
                int status = b.getInt("status");
                if(status ==1) {
                    Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG);
                    username = USERNAME.getText().toString();
                    userpass = USERPASS.getText().toString();
                    DatabaseOperations DOP = new DatabaseOperations(CTX);
                    Cursor CR = DOP.getInformation(DOP);
                    CR.moveToFirst();
                    boolean loginstatus = false;
                    String NAME = "";
                    do {
                        if (username.equals(CR.getString(0)) && (userpass.equals(CR.getString(1)))) {
                            loginstatus = true;
                            NAME = CR.getString(0);
                        }
                    } while(CR.moveToNext());
                        if(loginstatus) {
                            Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else {
                            Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
                            finish();
                        }
                }
            }

        });
        Button choose = (Button) findViewById(R.id.bLogin);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ChooseActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
