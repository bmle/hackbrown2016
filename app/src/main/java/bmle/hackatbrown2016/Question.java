package bmle.hackatbrown2016;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


public class Question extends ActionBarActivity {

    EditText TITLE, QUESTION;
    String title, quest;
    Button REG;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TITLE = (EditText) findViewById(R.id.editText);
        QUESTION = (EditText) findViewById(R.id.editText2);
        REG = (Button) findViewById(R.id.submit);
        REG.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                title = TITLE.getText().toString();
                quest = QUESTION.getText().toString();

                DatabaseOperations DB = new DatabaseOperations(ctx);
                DB.putInfo(DB, title, quest);
                Log.d("database operations", " " +title + " " + quest);
                finish();

                Intent intent1 = new Intent(Question.this, Feed.class);
                intent1.putExtra("message",title + " " + quest);
                startActivity(intent1);

                Intent intent = new Intent(Question.this, Submitted.class);
                startActivity(intent);
            }
        });

<<<<<<< Updated upstream
        Button goBack = (Button) findViewById(R.id.button6);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question.this, ChooseActivity.class);
                startActivity(intent);
            }
        });
=======
//        Button submit = (Button) findViewById(R.id.submit);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Question.this, Submitted.class);
//                startActivity(intent);
//            }
//        });
>>>>>>> Stashed changes
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
