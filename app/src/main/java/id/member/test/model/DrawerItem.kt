package id.logique.hinoconnect.model


/**
 * Created by Alhudaghifari on 10:30 23/09/19
 *
 */
class DrawerItem(itemName: String, imgResID: Int) {

    internal var itemName: String? = itemName
    internal var imgResID: Int = imgResID

    fun getItemName(): String? {
        return itemName
    }

    fun setItemName(itemName: String) {
        this.itemName = itemName
    }

    fun getImgResID(): Int {
        return imgResID
    }

    fun setImgResID(imgResID: Int) {
        this.imgResID = imgResID
    }
}