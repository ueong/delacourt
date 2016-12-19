package example.spatch.act.delacourt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DelacourtMenuDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delacourt_menu_detail);
        Intent intent = getIntent();
        DelacourtMenu item = intent.getParcelableExtra(Constants.ITEM);
        TextView koreanTitle = (TextView) findViewById(R.id.title_kor);
        TextView englishTitle = (TextView) findViewById(R.id.title_eng);
        TextView price = (TextView) findViewById(R.id.price);
        TextView payments = (TextView) findViewById(R.id.payments);
        TextView kcal = (TextView) findViewById(R.id.kcal);
        TextView floor = (TextView) findViewById(R.id.floor);
        TextView corner = (TextView) findViewById(R.id.corner);
        final ImageView imageView = (ImageView) findViewById(R.id.image);

        koreanTitle.setText(item.getKoreanTitle());
        englishTitle.setText(item.getEnglishTitle());
        price.setText(item.getPrice() + getResources().getString(R.string.won));
        price.setPaintFlags(payments.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); //취소선을 긋는다.
        payments.setText(item.getPayments() + getResources().getString(R.string.won));
        kcal.setText(item.getKcal());
        kcal.setTextColor(item.decorateKcalTextColor());
        corner.setText(item.getCorner());
        floor.setText(item.getFloor().toUpperCase());
        new LoadImageTask(this, imageView).execute(item);
    }

}
