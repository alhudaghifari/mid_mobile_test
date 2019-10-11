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

    fun setLogin(isLoggedIn: Boolean) {
        editor = pref.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

}