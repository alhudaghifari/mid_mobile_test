package id.member.test.view.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import id.member.test.R
import id.member.test.model.DrawerItem


/**
 * Created by Alhudaghifari on 13:55 23/09/19
 *
 */
class CustomDrawerAdapter(context: Context, resource: Int, drawerItem: MutableList<DrawerItem>) : ArrayAdapter<DrawerItem>(context, resource, drawerItem) {

    internal var context: Context = context
    internal var drawerItemList: List<DrawerItem> = drawerItem
    internal var layoutResID: Int = resource
    private var selectedItem: Int = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val drawerHolder: DrawerItemHolder
        var view = convertView

        if (view == null) {
            val inflater = (context as Activity).layoutInflater
            drawerHolder = DrawerItemHolder()

            view = inflater.inflate(layoutResID, parent, false)
            drawerHolder.tvAwardsMenu = view!!
                    .findViewById(R.id.tvAwardsMenu) as TextView
            drawerHolder.ivIcon = view.findViewById(R.id.ivIcon) as ImageView
            drawerHolder.tvItemName = view.findViewById(R.id.tvItemName) as TextView
            view.tag = drawerHolder
        } else {
            drawerHolder = view.tag as DrawerItemHolder
        }

        val dItem = this.drawerItemList[position]

        if (position != 0) {
            drawerHolder.tvAwardsMenu!!.visibility = View.GONE
            drawerHolder.ivIcon!!.visibility = View.GONE
        }

        if (position == selectedItem) {
            drawerHolder.tvItemName!!.setTextColor(ContextCompat.getColor(context, R.color.black))
        } else {
            drawerHolder.tvItemName!!.setTextColor(ContextCompat.getColor(context, R.color.silver_grey))
        }

        drawerHolder.tvItemName!!.text = dItem.getItemName()

        return view
    }

    fun setSelectedItem(selectedItem: Int) {
        this.selectedItem = selectedItem
    }

    private class DrawerItemHolder {
        internal var tvAwardsMenu: TextView? = null
        internal var tvItemName: TextView? = null
        internal var ivIcon: ImageView? = null
    }
}