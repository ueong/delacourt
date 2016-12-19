package example.spatch.act.delacourt;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static example.spatch.act.delacourt.R.id.corner;
import static example.spatch.act.delacourt.R.id.floor;
import static example.spatch.act.delacourt.R.id.kcal;
import static example.spatch.act.delacourt.R.id.payments;

public class DelacourtMenuAdapter extends BaseAdapter {
    private List<DelacourtMenu> itemList;

    public DelacourtMenuAdapter() {
        this.itemList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setMenus(List<DelacourtMenu> menus) {
        itemList.clear();
        itemList.addAll(menus);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delacourt_menu, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.context = parent.getContext();
            viewHolder.koreanTitle = (TextView) convertView.findViewById(R.id.title_kor);
            viewHolder.englishTitle = (TextView) convertView.findViewById(R.id.title_eng);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.payments = (TextView) convertView.findViewById(payments);
            viewHolder.kcal = (TextView) convertView.findViewById(kcal);
            viewHolder.floor = (TextView) convertView.findViewById(floor);
            viewHolder.corner = (TextView) convertView.findViewById(corner);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final DelacourtMenu item = itemList.get(position);
        viewHolder.setItem(item);
        return convertView;
    }

    public class ViewHolder {
        Context context;
        TextView koreanTitle;
        TextView englishTitle;
        TextView price;
        TextView payments;
        TextView kcal;
        TextView floor;
        TextView corner;
        ImageView imageView;

        public void setItem(DelacourtMenu item) {
            koreanTitle.setText(item.getKoreanTitle());
            englishTitle.setText(item.getEnglishTitle());
            price.setText(item.getPrice() + context.getResources().getString(R.string.won));
            price.setPaintFlags(payments.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); //취소선을 긋는다.
            payments.setText(item.getPayments() + context.getResources().getString(R.string.won));
            kcal.setText(item.getKcal());
            kcal.setTextColor(item.decorateKcalTextColor());
            corner.setText(item.getCorner());
            floor.setText(item.getFloor().toUpperCase());
            new LoadImageTask(context, imageView).execute(item);
        }
    }
}
