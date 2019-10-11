package id.member.test.model


/**
 * Created by Alhudaghifari on 10:30 23/09/19
 *
 */
class DrawerItem(itemName: String) {

    internal var itemName: String? = itemName

    fun getItemName(): String? {
        return itemName
    }

    fun setItemName(itemName: String) {
        this.itemName = itemName
    }

}