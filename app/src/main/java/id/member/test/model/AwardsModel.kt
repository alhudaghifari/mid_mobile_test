package id.member.test.model

import id.logique.hinoconnect.utils.Constant


/**
 * Created by Alhudaghifari on 8:01 11/10/19
 *
 */
data class AwardsModel(
    val id: Int,
    val type: Constant.AWARDS_TYPE,
    val point: Long,
    val name: String,
    val image: String
)