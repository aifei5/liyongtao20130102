package bwie.com.liyongtao20130102.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bwie.com.liyongtao20130102.R;
import bwie.com.liyongtao20130102.bean.FousBean;

public class HomeAdapter extends BaseAdapter {
    private List<FousBean.DataBean.TuijianBean.ListBeanX> list;
    private Context context;

    public HomeAdapter(List<FousBean.DataBean.TuijianBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            view = View.inflate(context, R.layout.mybase, null);
            holder.imageView = view.findViewById(R.id.image1);
            holder.textView = view.findViewById(R.id.text1);
            holder.textView2 = view.findViewById(R.id.text5);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(list.get(i).getSubhead());
        holder.textView2.setText(list.get(i).getTitle());
        ImageLoader.getInstance().displayImage(list.get(i).getImages(),holder.imageView);
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView, textView2;
    }
}
