package id.member.test.view.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.logique.hinoconnect.utils.Constant
import id.logique.hinoconnect.utils.SharedPrefManager
import id.member.test.R
import id.member.test.model.AwardsModel
import id.member.test.presenter.AwardsInterface
import id.member.test.presenter.AwardsPresenter
import id.member.test.view.activity.FilterActivity
import id.member.test.view.adapter.AwardsAdapter



/**
 * A simple [Fragment] subclass.
 */
class AwardsFragment : Fragment(), AwardsInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: AwardsPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: AwardsAdapter
    private lateinit var ivFilter: ImageView
    private lateinit var sharedPrefManager: SharedPrefManager
    private var data = ArrayList<AwardsModel>()
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_awards, container, false)
        recyclerView = v.findViewById(R.id.recyclerView)
        progressBar = v.findViewById(R.id.progressBar)
        ivFilter = v.findViewById(R.id.ivFilter)

        sharedPrefManager = SharedPrefManager(context!!)
        presenter = AwardsPresenter(this)
        presenter.callData(page)

        ivFilter.setOnClickListener({
            val intent = Intent(context, FilterActivity::class.java)
            startActivity(intent)
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == 0) {
                    if (page <= 3) {
                        page++
                        presenter.callData(page)
                    } else
                        page = 3
                }
            }
        })

        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.callData(page)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun callFinished(model: ArrayList<AwardsModel>) {
        if (page == 1) {
            setRecyclerView(filterData(model))
            data = filterData(model)
        } else {
            data.addAll(filterData(model))
            adapter.setData(data)
            adapter.notifyDataSetChanged()
            if (page <= 3)
                Toast.makeText(context!!,"new data loaded $page", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(context!!,"end of data", Toast.LENGTH_LONG).show()
        }
    }

    override fun showError(msg: String) {

    }

    private fun getPointFromFilter(item: AwardsModel, data: ArrayList<AwardsModel>): ArrayList<AwardsModel> {
        val point = sharedPrefManager.getFilterPoint()
        when(point) {
            Constant.POINT_TYPE.NO_POINT.type ->  {
                data.add(item)
            }
            Constant.POINT_TYPE.POINT_10000.type ->  {
                if (item.point < 10000) {
                    data.add(item)
                }
            }
            Constant.POINT_TYPE.POINT_MIDDLE.type ->  {
                if (item.point >= 10000 && item.point <= 500000) {
                    data.add(item)
                }
            }
            Constant.POINT_TYPE.POINT_500000.type ->  {
                if (item.point >= 500000) {
                    data.add(item)
                }
            }
        }

        return data
    }

    private fun filterData(model: ArrayList<AwardsModel>): ArrayList<AwardsModel> {
        var data = ArrayList<AwardsModel>()

        for (item in model) {
            Log.d("awards","1")
            if (sharedPrefManager.getFilterVoucher() && sharedPrefManager.getFilterProduct()) {
                if (item.type == Constant.AWARDS_TYPE.VOUCHER || item.type == Constant.AWARDS_TYPE.PRODUCT) {
                   data = getPointFromFilter(item, data)
                }
            } else if (sharedPrefManager.getFilterProduct()) {
                if (item.type == Constant.AWARDS_TYPE.PRODUCT) {
                    data = getPointFromFilter(item, data)
                }
            } else if (sharedPrefManager.getFilterVoucher()) {
                if (item.type == Constant.AWARDS_TYPE.VOUCHER) {
                    data = getPointFromFilter(item, data)
                }
            } else {
                data = getPointFromFilter(item, data)
            }
        }

        return data
    }

    private fun setRecyclerView(data: ArrayList<AwardsModel>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = AwardsAdapter(data!!, context)
        recyclerView.adapter = adapter
    }

}
