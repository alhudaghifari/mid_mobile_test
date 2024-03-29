package id.member.test.presenter

import id.logique.hinoconnect.utils.Constant


/**
 * Created by Alhudaghifari on 9:15 11/10/19
 *
 */
class AwardsPresenter(private val view: AwardsInterface) {

    fun callData(page: Int) {
        view.showLoading()
        view.callFinished(Constant.getData(page))
        view.hideLoading()
    }
}