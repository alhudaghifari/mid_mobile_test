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
    private val KEY_TOKEN = "token31"

    /**
     * procedure untuk melakukan set apakah sudah login atau belum.
     * isLoggedIn bernilai true ketika berhasil melakukan login.
     * isLoggedIn bernilai false ketika dalam kondisi logout.
     * @param isLoggedIn boolean
     */
    fun setLogin(isLoggedIn: Boolean) {
        editor = pref.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    /**
     * function untuk melihat apakah sudah login atau belum
     * true : sudah
     * false : tidak login
     * @return boolean login
     */
    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setToken(token: String) {
        editor = pref.edit()
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return pref.getString(KEY_TOKEN, "")
    }
}