package id.logique.hinoconnect.utils

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Alhudaghifari on 2:07 08/10/19
 *
 */
class SharedPrefManager(context: Context) {

    private lateinit var editor: SharedPreferences.Editor
    private val PREF_NAME = Constant.this_app
    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private val KEY_IS_LOGGED_IN = "isLoggedIn"
    private val KEY_FILTER_POINT_VAL = "point"
    private val KEY_FILTER_PRODUCT = "filterprod"
    private val KEY_FILTER_VOUCHER = "voucherfilter"

    fun setLogin(isLoggedIn: Boolean) {
        editor = pref.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setFilterPoint(point: Int) {
        editor = pref.edit()
        editor.putInt(KEY_FILTER_POINT_VAL, point)
        editor.apply()
    }

    fun getFilterPoint(): Int {
        return pref.getInt(KEY_FILTER_POINT_VAL, Constant.POINT_TYPE.POINT_MIDDLE.type)
    }

    fun setFilterProduct(filter: Boolean) {
        editor = pref.edit()
        editor.putBoolean(KEY_FILTER_PRODUCT, filter)
        editor.apply()
    }

    fun getFilterProduct(): Boolean {
        return pref.getBoolean(KEY_FILTER_PRODUCT, true)
    }

    fun setFilterVoucher(filter: Boolean) {
        editor = pref.edit()
        editor.putBoolean(KEY_FILTER_VOUCHER, filter)
        editor.apply()
    }

    fun getFilterVoucher(): Boolean {
        return pref.getBoolean(KEY_FILTER_VOUCHER, true)
    }

    fun resetData() {
        editor = pref.edit()
        editor.clear()
        editor.apply()
    }
}