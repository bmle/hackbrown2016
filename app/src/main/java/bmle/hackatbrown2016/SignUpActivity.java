package bmle.hackatbrown2016;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Context;


public class SignUpActivity extends ActionBarActivity {

    EditText USER_NAME, USER_PASS, CON_PASS;
    String user_name,user_pass,con_pass;
    Button REG;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        USER_NAME = (EditText) findViewById(R.id.Username);
        USER_PASS = (EditText) findViewById(R.id.Password);
        CON_PASS = (EditText) findViewById(R.id.Confirm);
        REG = (Button) findViewById(R.id.bRegister);
        REG.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();

                if (!(user_pass.equals(con_pass))) {
                    Toast.makeText(getBaseContext(), "Passwords dont match", Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                } else {
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInfo(DB, user_name, user_pass);
                    Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

        });
        Button choose = (Button) findViewById(R.id.bRegister);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, ChooseActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
