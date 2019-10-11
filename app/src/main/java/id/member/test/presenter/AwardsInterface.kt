package id.member.test.presenter

import id.member.test.model.AwardsModel


/**
 * Created by Alhudaghifari on 9:14 11/10/19
 *
 */
interface AwardsInterface {
    fun showLoading()
    fun hideLoading()
    fun callFinished(model: ArrayList<AwardsModel>)
    fun showError(msg: String)
}