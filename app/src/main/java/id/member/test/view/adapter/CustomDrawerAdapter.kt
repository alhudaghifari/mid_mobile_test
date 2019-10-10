package id.logique.hinoconnect.view.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import id.logique.hinoconnect.R
import id.logique.hinoconnect.model.DrawerItem


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
            drawerHolder.tvMenu = view!!
                    .findViewById(R.id.tvMenu) as TextView
            drawerHolder.tvItemName = view
                    .findViewById(R.id.tvDrawerItemName) as TextView
            drawerHolder.ivIcon = view.findViewById(R.id.ivIconDrawer) as ImageView
            drawerHolder.ivEdgeColor = view.findViewById(R.id.ivEdgeColor) as ImageView
            drawerHolder.rellayItemLayout = view
                    .findViewById(R.id.rellayItemLayout) as RelativeLayout
            view.tag = drawerHolder
        } else {
            drawerHolder = view.tag as DrawerItemHolder
        }

        val dItem = this.drawerItemList[position]

        if (position != 0) {
            drawerHolder.tvMenu!!.visibility = View.GONE
        }

        Log.d("Custom", "position = $position and selectedItem = $selectedItem")

        if (position == selectedItem) {
            drawerHolder.ivEdgeColor!!.setImageResource(R.color.colorPrimaryDark)
        } else {
            drawerHolder.ivEdgeColor!!.setImageResource(R.color.white)
        }

        drawerHolder.ivIcon!!.setImageDrawable(view.resources.getDrawable(dItem.getImgResID(), null))
        drawerHolder.tvItemName!!.text = dItem.getItemName()

        return view
    }

    fun setSelectedItem(selectedItem: Int) {
        this.selectedItem = selectedItem
    }

    private class DrawerItemHolder {
        internal var tvMenu: TextView? = null
        internal var tvItemName: TextView? = null
        internal var ivIcon: ImageView? = null
        internal var ivEdgeColor: ImageView? = null
        internal var rellayItemLayout: RelativeLayout? = null
    }
}