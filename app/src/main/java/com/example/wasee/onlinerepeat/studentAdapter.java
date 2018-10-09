package com.example.wasee.onlinerepeat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class studentAdapter extends BaseAdapter {
    private Context activity;
    private ArrayList<User> allStudent = new ArrayList<>();
    private LayoutInflater layoutInflater = null;

    public studentAdapter(Context activity, ArrayList<User> allStudent) {
        this.activity = activity;
        this.allStudent = allStudent;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder{
        private TextView name, add,gen,dob,typ,bat;
    }
    private ViewHolder viewHolder = null;

    @Override
    public int getCount() {
        return allStudent.size();
    }

    @Override
    public User getItem(int position) {
        return allStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        final int pos = position;
        if(view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.row_cell_student,null);
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.add = view.findViewById(R.id.add);
            viewHolder.gen = view.findViewById(R.id.gen);
            viewHolder.dob = view.findViewById(R.id.dob);
            viewHolder.typ = view.findViewById(R.id.typ);
            viewHolder.bat = view.findViewById(R.id.bat);

            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(allStudent.get(pos).getName());
        viewHolder.add.setText(allStudent.get(pos).getAddress());
        viewHolder.gen.setText(allStudent.get(pos).getGender());
        viewHolder.dob.setText(allStudent.get(pos).getDate());
        viewHolder.typ.setText(allStudent.get(pos).getType());
        viewHolder.bat.setText(allStudent.get(pos).getBatch());

        return view;
    }


}
