package com.example.uniform_management

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class customAdapter(var context: Context, var data:ArrayList<user>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtItemname:TextView
        var mTxtItemdescription:TextView
        var mTxtSizes:TextView
        init {
            this.mTxtItemname = row?.findViewById(R.id.mTvItemName) as TextView
            this.mTxtItemdescription = row?.findViewById(R.id.mTvItemDescription) as TextView
            this.mTxtSizes = row?.findViewById(R.id.mTvSizes) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.myitem_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:user = getItem(position) as user
        viewHolder.mTxtItemname.text = item.itemname
        viewHolder.mTxtItemdescription.text = item.itemdescription
        viewHolder.mTxtSizes.text = item.sizes
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
