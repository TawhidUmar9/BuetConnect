package com.example.buet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.buet.departments.Department;
import java.util.List;

public class DepartmentAdapter extends BaseAdapter {
    private final Context context;
    private final List<Department> departmentList;

    public DepartmentAdapter(Context context, List<Department> departmentList) {
        this.context = context;
        this.departmentList = departmentList;
    }

    @Override
    public int getCount() {
        return departmentList != null ? departmentList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return departmentList != null ? departmentList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_departments, parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.departmentImage);
        TextView textView = convertView.findViewById(R.id.departmentName);
        imageView.setImageResource(departmentList.get(position).getDepartmentImage());
        textView.setText(departmentList.get(position).getDepartmentName());

        return convertView;
    }
}
