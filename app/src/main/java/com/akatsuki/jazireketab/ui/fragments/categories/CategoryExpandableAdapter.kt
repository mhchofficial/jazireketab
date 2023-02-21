package com.akatsuki.jazireketab.ui.fragments.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.models.test.cat.Data

class CategoryExpandableAdapter internal constructor(
    private val context: Context,
    private val dataList: List<Data>,
) : BaseExpandableListAdapter() {
    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[listPosition].catSub[expandedListPosition]
    }
    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }
    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val expandedListText = dataList[listPosition].catSub[expandedListPosition].subName
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_spinner_sub_category, null)
        }
        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.category_subname)
        expandedListTextView.text = expandedListText
        return convertView
    }
    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[listPosition].catSub.size
    }
    override fun getGroup(listPosition: Int): Any {
        return this.dataList[listPosition]
    }
    override fun getGroupCount(): Int {
        return this.dataList.size
    }
    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }
    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = dataList[listPosition].catName
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_spinner_category, null)
        }
        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.category_subject)
        listTitleTextView.text = listTitle
        return convertView
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}