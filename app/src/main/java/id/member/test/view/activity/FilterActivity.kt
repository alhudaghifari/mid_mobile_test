package id.member.test.view.activity

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import id.logique.hinoconnect.utils.Constant
import id.logique.hinoconnect.utils.SharedPrefManager
import kotlinx.android.synthetic.main.activity_filter.*



class FilterActivity : AppCompatActivity() {

    private lateinit var sharedPrefManager: SharedPrefManager
    private var point = Constant.POINT_TYPE.POINT_MIDDLE.type
    private var isPointFilterActive = false
    private var isTypeFilterActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(id.member.test.R.layout.activity_filter)

        sharedPrefManager = SharedPrefManager(this)

        point = sharedPrefManager.getFilterPoint()

        if (sharedPrefManager.getFilterProduct() && sharedPrefManager.getFilterVoucher()) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Voucher, Product"
            isTypeFilterActive = true
        } else if (!sharedPrefManager.getFilterProduct() && sharedPrefManager.getFilterVoucher()) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Product"
            isTypeFilterActive = true
        } else if (sharedPrefManager.getFilterProduct() && !sharedPrefManager.getFilterVoucher()) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Voucher"
            isTypeFilterActive = true
        } else {
            linlayType.visibility = View.GONE
            isTypeFilterActive = false
        }

        setPointHistory()

        ivClose.setOnClickListener({
            finish()
        })

        ivClosePoint.setOnClickListener({
            if (isPointFilterActive) {
                isPointFilterActive = false
                linlayBtnPoint.visibility = View.GONE
            }
        })

        ivCloseType.setOnClickListener({
            if (cb2Voucher.isChecked || cb3Products.isChecked) {
                cb2Voucher.isChecked = false
                cb3Products.isChecked = false
                setTypeAwardHistory()
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                point = progress
                setPointHistory()
                setVisibilityClearText()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        cb1AllType.setOnClickListener({
            if (cb1AllType.isChecked) {
                cb2Voucher.isChecked = cb1AllType.isChecked
                cb3Products.isChecked = cb1AllType.isChecked
                cb4Others.isChecked = cb1AllType.isChecked
                setTypeAwardHistory()
                setVisibilityClearText()
            }
        })

        cb2Voucher.setOnClickListener({
            setTypeAwardHistory()
            setVisibilityClearText()
        })

        cb3Products.setOnClickListener({
            setTypeAwardHistory()
            setVisibilityClearText()
        })

        btnClear.setOnClickListener({
            if (isPointFilterActive && isTypeFilterActive) {
                btnClear.visibility = View.GONE
                linlayBtnPoint.visibility = View.GONE
                linlayType.visibility = View.GONE
                isPointFilterActive = false
                isTypeFilterActive = false
                cb1AllType.isChecked = false
                cb2Voucher.isChecked = false
                cb3Products.isChecked = false
            }
        })

        btnFilterDone.setOnClickListener({
            sharedPrefManager.setFilterProduct(cb3Products.isChecked)
            sharedPrefManager.setFilterVoucher(cb2Voucher.isChecked)
            if (isPointFilterActive)
                sharedPrefManager.setFilterPoint(seekBar.progress)
            else
                sharedPrefManager.setFilterPoint(Constant.POINT_TYPE.NO_POINT.type)
            finish()
        })
    }

    private fun setVisibilityClearText() {
        if (isPointFilterActive && isTypeFilterActive) {
            btnClear.visibility = View.VISIBLE
        } else {
            btnClear.visibility = View.GONE
        }
    }

    private fun setTypeAwardHistory() {
        isTypeFilterActive = true
        if (cb3Products.isChecked && cb2Voucher.isChecked) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Voucher, Product"
        } else if (!cb3Products.isChecked && cb2Voucher.isChecked) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Product"
        } else if (cb3Products.isChecked && !cb2Voucher.isChecked) {
            linlayType.visibility = View.VISIBLE
            tvTypeAward.text = "Type: Voucher"
        } else {
            linlayType.visibility = View.GONE
            isTypeFilterActive = false
        }
    }

    private fun setPointHistory() {
        when(point) {
            Constant.POINT_TYPE.NO_POINT.type ->  {
                seekBar.progress = Constant.POINT_TYPE.NO_POINT.type
                linlayBtnPoint.visibility = View.GONE
                isPointFilterActive = false
            }
            Constant.POINT_TYPE.POINT_10000.type ->  {
                seekBar.progress = Constant.POINT_TYPE.POINT_10000.type
                linlayBtnPoint.visibility = View.VISIBLE
                tvPoint.text = "Point: 10.000"
                isPointFilterActive = true
            }
            Constant.POINT_TYPE.POINT_MIDDLE.type ->  {
                seekBar.progress = Constant.POINT_TYPE.POINT_MIDDLE.type
                linlayBtnPoint.visibility = View.VISIBLE
                tvPoint.text = "Point: 10000 - 500.000"
                isPointFilterActive = true
            }
            Constant.POINT_TYPE.POINT_500000.type ->  {
                seekBar.progress = Constant.POINT_TYPE.POINT_500000.type
                linlayBtnPoint.visibility = View.VISIBLE
                tvPoint.text = "Point: 500.000"
                isPointFilterActive = true
            }
        }
    }
}
