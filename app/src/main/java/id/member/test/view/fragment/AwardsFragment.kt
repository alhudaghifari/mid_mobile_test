package id.member.test.view.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_awards, container, false)
        recyclerView = v.findViewById(R.id.recyclerView)
        progressBar = v.findViewById(R.id.progressBar)
        ivFilter = v.findViewById(R.id.ivFilter)

        presenter = AwardsPresenter(this)
        presenter.callData()

        ivFilter.setOnClickListener({
            val intent = Intent(context, FilterActivity::class.java)
            startActivity(intent)
        })

        return v
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun callFinished(model: ArrayList<AwardsModel>) {
        setRecyclerView(model)
    }

    override fun showError(msg: String) {

    }

    private fun setRecyclerView(data: ArrayList<AwardsModel>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = AwardsAdapter(data!!, context)
        recyclerView.adapter = adapter
    }

}
