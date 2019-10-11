package id.member.test.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import id.logique.hinoconnect.utils.SharedPrefManager
import id.member.test.R
import id.member.test.model.DrawerItem
import id.member.test.view.adapter.CustomDrawerAdapter
import id.member.test.view.fragment.AwardsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit  var adapter: CustomDrawerAdapter
    private lateinit var dataList: MutableList<DrawerItem>
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefManager = SharedPrefManager(this)
        dataList = mutableListOf()

        dataList.add(DrawerItem("Home"))
        dataList.add(DrawerItem("Cards"))
        dataList.add(DrawerItem("Profile"))
        dataList.add(DrawerItem("Logout"))

        adapter = CustomDrawerAdapter(this, R.layout.item_drawer, dataList)

        left_drawer.adapter = adapter
        left_drawer.setOnItemClickListener(DrawerItemClickListener())

        ivOpenMenuDrawer.setOnClickListener({
            drawer_layout.openDrawer(GravityCompat.START)
        })

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame, AwardsFragment(), resources.getString(R.string.title_home))
            .commit()
    }

    fun selectItem(position: Int) {
        when (position) {
            0 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, AwardsFragment(), resources.getString(R.string.title_home))
                    .commit()
            }
            3 -> {
                sharedPrefManager.setLogin(false)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else -> {
            }
        }
        if (position != 1 && position != 2) {
            adapter.setSelectedItem(position)
            left_drawer.setItemChecked(position, true)
            title = dataList[position].getItemName()
        }
        drawer_layout.closeDrawers()

    }

    private inner class DrawerItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(
            parent: AdapterView<*>, view: View, position: Int,
            id: Long
        ) {
            selectItem(position)
        }
    }
}
