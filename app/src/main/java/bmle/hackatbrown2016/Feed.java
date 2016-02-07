package bmle.hackatbrown2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Feed extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Button goBack = (Button) findViewById(R.id.button3);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feed.this, ChooseActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            System.out.println("yoyoyo");
        }
        else {
            String message = bundle.getString("message");
            TextView txtView = (TextView) findViewById(R.id.textView9);
            txtView.setText(message);
        }
    }


}
