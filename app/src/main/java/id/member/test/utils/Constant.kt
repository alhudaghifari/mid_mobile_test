package id.logique.hinoconnect.utils

import id.member.test.model.AwardsModel


/**
 * Created by Alhudaghifari on 22:26 28/09/19
 *
 */
object Constant {

    const val this_app = "mob1l3t3stmemb3r1d"

    enum class AWARDS_TYPE(val type: String) {
        VOUCHER("Vouchers"),
        PRODUCT("Product"),
        OTHER("Other")
    }

    enum class POINT_TYPE(val type: Int) {
        NO_POINT(-1),
        POINT_10000(0),
        POINT_MIDDLE(1),
        POINT_500000(2)
    }

    fun getData(): ArrayList<AwardsModel> {
        val list = ArrayList<AwardsModel>()

        list.add(AwardsModel(1, AWARDS_TYPE.VOUCHER, 500000, "Gift Card IDR 500.000","https://blog.traveloka.com/source/uploads/2018/02/26184452_1754649701510263_5690274773150466048_n-1024x1190.jpg"))
        list.add(AwardsModel(2, AWARDS_TYPE.PRODUCT, 500000, "Gift Card IDR 500.000","https://cf.shopee.co.id/file/1d9a20c3c91c68f7cc3ef2576ebca2dc"))
        list.add(AwardsModel(3, AWARDS_TYPE.VOUCHER, 250000, "Gift Card IDR 500.000","https://blog.traveloka.com/source/uploads/2018/02/26184452_1754649701510263_5690274773150466048_n-1024x1190.jpg"))
        list.add(AwardsModel(4, AWARDS_TYPE.PRODUCT, 500000, "Gift Card IDR 500.000","https://cf.shopee.co.id/file/1d9a20c3c91c68f7cc3ef2576ebca2dc"))
        list.add(AwardsModel(5, AWARDS_TYPE.VOUCHER, 250000, "Gift Card IDR 500.000","https://blog.traveloka.com/source/uploads/2018/02/26184452_1754649701510263_5690274773150466048_n-1024x1190.jpg"))
        list.add(AwardsModel(6, AWARDS_TYPE.PRODUCT, 250000, "Gift Card IDR 500.000","https://cf.shopee.co.id/file/1d9a20c3c91c68f7cc3ef2576ebca2dc"))
        list.add(AwardsModel(7, AWARDS_TYPE.VOUCHER, 500000, "Gift Card IDR 500.000","https://blog.traveloka.com/source/uploads/2018/02/26184452_1754649701510263_5690274773150466048_n-1024x1190.jpg"))
        list.add(AwardsModel(8, AWARDS_TYPE.PRODUCT, 250000, "Gift Card IDR 500.000","https://cf.shopee.co.id/file/1d9a20c3c91c68f7cc3ef2576ebca2dc"))
        list.add(AwardsModel(9, AWARDS_TYPE.OTHER, 500000, "Gift Card IDR 500.000","https://blog.traveloka.com/source/uploads/2018/02/26184452_1754649701510263_5690274773150466048_n-1024x1190.jpg"))
        list.add(AwardsModel(10, AWARDS_TYPE.OTHER, 250000, "Gift Card IDR 500.000","https://cf.shopee.co.id/file/1d9a20c3c91c68f7cc3ef2576ebca2dc"))

        return list
    }
}