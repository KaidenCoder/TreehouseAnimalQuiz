package an.kurosaki.animalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaring statement variables
    private TextView mStatement1;
    private TextView mStatement2;
    private TextView mStatement3;
    private TextView mStatement4;
    private TextView mStatement5;
    private TextView mStatement6;
    private TextView mStatement7;
    private TextView mStatement8;
    private TextView mStatement9;
    private TextView mStatement10;

    //declaring answers for the statements
    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;
    private Spinner mSpinner4;
    private Spinner mSpinner5;
    private Spinner mSpinner6;
    private Spinner mSpinner7;
    private Spinner mSpinner8;
    private Spinner mSpinner9;
    private Spinner mSpinner10;
    Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatement1 = (TextView) findViewById(R.id.statementTextView1);
        mStatement2 = (TextView) findViewById(R.id.statementTextView2);
        mStatement3 = (TextView) findViewById(R.id.statementTextView3);
        mStatement4 = (TextView) findViewById(R.id.statementTextView4);
        mStatement5 = (TextView) findViewById(R.id.statementTextView5);
        mStatement6 = (TextView) findViewById(R.id.statementTextView6);
        mStatement7 = (TextView) findViewById(R.id.statementTextView7);
        mStatement8 = (TextView) findViewById(R.id.statementTextView8);
        mStatement9 = (TextView) findViewById(R.id.statementTextView9);
        mStatement10 = (TextView) findViewById(R.id.statementTextView10);

        mSpinner1 = (Spinner) findViewById(R.id.spinner1);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);
        mSpinner3 = (Spinner) findViewById(R.id.spinner3);
        mSpinner4 = (Spinner) findViewById(R.id.spinner4);
        mSpinner5 = (Spinner) findViewById(R.id.spinner5);
        mSpinner6 = (Spinner) findViewById(R.id.spinner6);
        mSpinner7 = (Spinner) findViewById(R.id.spinner7);
        mSpinner8 = (Spinner) findViewById(R.id.spinner8);
        mSpinner9 = (Spinner) findViewById(R.id.spinner9);
        mSpinner10 = (Spinner) findViewById(R.id.spinner10);
        mButton = (Button) findViewById(R.id.finishButton);
        mEditText = (EditText) findViewById(R.id.captionEditText);
        mEditText.setHint("Please enter a caption");

        setStatementOptions();
        setSpinner();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] answers = new String[10];
                answers[0] = mSpinner1.getSelectedItem().toString();
                answers[1] = mSpinner2.getSelectedItem().toString();
                answers[2] = mSpinner3.getSelectedItem().toString();
                answers[3] = mSpinner4.getSelectedItem().toString();
                answers[4] = mSpinner5.getSelectedItem().toString();
                answers[5] = mSpinner6.getSelectedItem().toString();
                answers[6] = mSpinner7.getSelectedItem().toString();
                answers[7] = mSpinner8.getSelectedItem().toString();
                answers[8] = mSpinner9.getSelectedItem().toString();
                answers[9] = mSpinner10.getSelectedItem().toString();
                String caption = mEditText.getText().toString();
               getResult(answers,caption);
            }
        });
    }

    public void getResult(String[] answers, String caption){
        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("caption", caption);
        intent.putExtra("answers", answers);
        startActivity(intent);
    }

    public void setStatementOptions(){
        mStatement1.setText("I am charismatic.");
        mStatement2.setText("I like food more than anything");
        mStatement3.setText("I like playing games");
        mStatement4.setText("I like making friends");
        mStatement5.setText("I am very forgetful");
        mStatement6.setText("I can stay hidden for very long");
        mStatement7.setText("I take things slow and steadily");
        mStatement8.setText("I can be your best friend");
        mStatement9.setText("I like bamboo and sugarcane");
        mStatement10.setText("I am very loyal");
    }

    public void setSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1.setAdapter(adapter);
        mSpinner2.setAdapter(adapter);
        mSpinner3.setAdapter(adapter);
        mSpinner4.setAdapter(adapter);
        mSpinner5.setAdapter(adapter);
        mSpinner6.setAdapter(adapter);
        mSpinner7.setAdapter(adapter);
        mSpinner8.setAdapter(adapter);
        mSpinner9.setAdapter(adapter);
        mSpinner10.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSpinner1.setSelection(2);
        mSpinner2.setSelection(2);
        mSpinner3.setSelection(2);
        mSpinner4.setSelection(2);
        mSpinner5.setSelection(2);
        mSpinner6.setSelection(2);
        mSpinner7.setSelection(2);
        mSpinner8.setSelection(2);
        mSpinner9.setSelection(2);
        mSpinner10.setSelection(2);
        mEditText.setText("");
    }
}
