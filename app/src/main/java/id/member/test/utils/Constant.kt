package id.logique.hinoconnect.utils


/**
 * Created by Alhudaghifari on 22:26 28/09/19
 *
 */
object Constant {

    const val BASE_URL = "http://hino-sandbox-api.l72.logique.co.id/"
    const val this_app = "Id.l0g!qu3.H1n0CoNn3ct"

    enum class MaintenanceTabType(val type: Int) {
        UPCOMING(1),
        COMPLETED(2)
    }

    enum class TruckType(val type: Int) {
        BUS_GREEN(1),
        BUS_GREY(2),
        BUS_ORANGE(3),
        TRUCK_GREEN(4)
    }

    enum class ScoreViewType(val type: Int) {
        VEHICLE(1),
        DRIVER(2)
    }

    enum class NotificationType(val type: Int) {
        MAINTENANCE(1),
        OVERSPEED(2),
        DEVICE_OFF(3)
    }

    enum class TabType(val type: Int) {
        ALL(1),
        GOOD(2),
        MEDIUM(3),
        BAD(4)
    }
}