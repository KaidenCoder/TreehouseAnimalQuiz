package an.kurosaki.animalquiz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private ImageView mAnimalImage;
    private String[] mAnswers;
    private Result mResult = new Result();
    private String mImageTag;
    Button mPlayAgainButton;
    private TextView mCaptionText;
    private String mCaption;
    int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mAnimalImage = findViewById(R.id.resultImageView);
        mPlayAgainButton = findViewById(R.id.returnButton);
        mCaptionText = findViewById(R.id.captionTextView);

        Intent intent = getIntent();
        mAnswers = intent.getStringArrayExtra("answers");
        mCaption = intent.getStringExtra("caption");

        getResult();

        setResult();

        Toast.makeText(this, "You are a " + mImageTag + "!", Toast.LENGTH_SHORT).show();

        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getResult(){
        for(String answer: mAnswers){
            mPoints = 0;
            switch (answer){
                case "Strongly Agree":
                    mPoints += 1;
                case "Agree":
                    mPoints += 2;
                case "Neutral":
                    mPoints += 3;
                case "Disagree":
                    mPoints += 4;
                case "Strongly Disagree":
                    mPoints += 5;
            }
            if(mPoints > 3 && mPoints < 6){
                mResult.setImageId(R.drawable.tiger);
                mAnimalImage.setTag("tiger");
            }
            if (mPoints > 5 && mPoints < 8) {
                mResult.setImageId(R.drawable.cat);
                mAnimalImage.setTag("cat");
            }
            if (mPoints > 7 && mPoints < 9) {
                mResult.setImageId(R.drawable.turtle);
                mAnimalImage.setTag("turtle");
            }
            if (mPoints > 8 && mPoints < 11) {
                mResult.setImageId(R.drawable.monkey);
                mAnimalImage.setTag("monkey");
            }
            if (mPoints > 10 && mPoints < 13) {
                mResult.setImageId(R.drawable.whale);
                mAnimalImage.setTag("whale");
            }
            if (mPoints > 12 && mPoints < 15) {
                mResult.setImageId(R.drawable.dolphin);
                mAnimalImage.setTag("dolphin");
            }
            if (mPoints > 14 && mPoints < 17) {
                mResult.setImageId(R.drawable.elephant);
                mAnimalImage.setTag("elephant");
            }
            if (mPoints > 16 && mPoints < 19) {
                mResult.setImageId(R.drawable.rabbit);
                mAnimalImage.setTag("rabbit");
            }
            if (mPoints > 18 && mPoints < 22) {
                mResult.setImageId(R.drawable.redpanda);
                mAnimalImage.setTag("red panda");
            }
            if (mPoints > 21 ) {
                mResult.setImageId(R.drawable.dog);
                mAnimalImage.setTag("dog");
            }
        }
        mResult.setCaption(mCaption);
    }

    public void setResult(){
        Drawable drawable = getResources().getDrawable(mResult.getImageId());
        mAnimalImage.setImageDrawable(drawable);
        mCaptionText.setText(mResult.getCaption());

        mImageTag = mAnimalImage.getTag().toString();
    }
}
