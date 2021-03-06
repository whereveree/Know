package io.wherevere.expandpopview.listview;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.wherevere.expandpopview.R;
import io.wherevere.expandpopview.callback.OnPopItemClickListener;
import io.wherevere.expandpopview.entity.KeyValue;

public class PopViewAdapter extends BaseAdapter {

    private List<KeyValue> mKeyValueList;
    private Context mContext;
    private OnPopItemClickListener mListener;

    private int mSelectBackground;
    private int mNormalBackground;

    private int mTextSize;
    private int mTextColor;
    private int mTextColorSelected;
    private int mSelectPosition = 0;

    public PopViewAdapter(Context context) {
        mContext = context;
        mKeyValueList = new ArrayList<>();
    }

    public PopViewAdapter(List<KeyValue> keyValueList, Context context) {
        mKeyValueList = keyValueList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mKeyValueList.size();
    }

    @Override
    public Object getItem(int position) {
        return mKeyValueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.expand_tab_item_text, null);
            viewHolder.mTvValue = convertView.findViewById(R.id.tv_expand_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (position == mSelectPosition) {
            if (mTextColorSelected == 0) {
                convertView.setBackgroundColor(mSelectBackground);
            } else {
                viewHolder.mTvValue.setTextColor(mTextColorSelected);
            }
        } else {
            viewHolder.mTvValue.setTextColor(mTextColor);
            convertView.setBackgroundColor(mNormalBackground);
        }

        viewHolder.mTvValue.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        viewHolder.mTvValue.setText(mKeyValueList.get(position).getKey());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(PopViewAdapter.this, position);
                }
            }
        });
        return convertView;
    }

    public void setKeyValueList(List<KeyValue> keyValueList) {
        mKeyValueList.clear();
        mKeyValueList.addAll(keyValueList);
        notifyDataSetChanged();
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    public void setTextColor(int textColor, int textColorSelected) {
        mTextColorSelected = textColorSelected;
        mTextColor = textColor;
    }

    public void setListener(OnPopItemClickListener listener) {
        mListener = listener;
    }

    public void setSelectPosition(int selectPosition) {
        mSelectPosition = selectPosition;
        notifyDataSetChanged();
    }

    public void setSelectorBackground(int normalBackground, int selectBackground) {
        mSelectBackground = selectBackground;
        mNormalBackground = normalBackground;
    }

    class ViewHolder {
        TextView mTvValue;
    }
}
