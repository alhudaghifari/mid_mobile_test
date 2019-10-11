package id.member.test.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.logique.hinoconnect.utils.Constant
import id.member.test.R
import id.member.test.model.AwardsModel


/**
 * Created by Alhudaghifari on 8:53 11/10/19
 *
 */
class AwardsAdapter(internal var data: ArrayList<AwardsModel>, internal var context: Context?)
    : RecyclerView.Adapter<AwardsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_awards, parent,
                false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = data[position]

        holder.tvAwardName.text = article.name
        holder.tvPoin.text = article.point.toString()

        Glide
            .with(context!!)
            .load(article.image)
            .centerCrop()
            .placeholder(R.drawable.btn_silver)
            .into(holder.ivTypeAwards)

        if (article.type == Constant.AWARDS_TYPE.VOUCHER) {
            holder.tvTypeAward.setText(Constant.AWARDS_TYPE.VOUCHER.type)
            holder.tvTypeAward.background = ContextCompat.getDrawable(context!!, R.drawable.btn_blue)
        } else if (article.type == Constant.AWARDS_TYPE.PRODUCT) {
            holder.tvTypeAward.setText(Constant.AWARDS_TYPE.PRODUCT.type)
            holder.tvTypeAward.background = ContextCompat.getDrawable(context!!, R.drawable.btn_orange)
        } else {
            holder.tvTypeAward.setText(Constant.AWARDS_TYPE.OTHER.type)
            holder.tvTypeAward.background = ContextCompat.getDrawable(context!!, R.drawable.btn_blue_dark)
        }
    }

    fun setData(newData: ArrayList<AwardsModel>) {
        data = newData
    }

    class ArticleViewHolder(mViewContainer: View) : RecyclerView.ViewHolder(mViewContainer) {
        internal var clParent : ConstraintLayout

        internal var tvTypeAward: TextView
        internal var tvPoin: TextView
        internal var tvAwardName: TextView

        internal var ivTypeAwards: ImageView

        init {
            clParent = mViewContainer.findViewById(R.id.clParent)

            tvTypeAward = mViewContainer.findViewById(R.id.tvTypeAward)
            tvPoin = mViewContainer.findViewById(R.id.tvPoin)
            tvAwardName = mViewContainer.findViewById(R.id.tvAwardName)

            ivTypeAwards = mViewContainer.findViewById(R.id.ivTypeAwards)
        }
    }
}