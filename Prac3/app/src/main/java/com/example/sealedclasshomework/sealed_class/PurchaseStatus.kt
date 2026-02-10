package com.example.sealedclasshomework.sealed_class
//это при 2 варианте меняем open на sealed
//от
sealed class PurchaseStatus {
//до
    object InProgress: PurchaseStatus()

    object Ready: PurchaseStatus()

    data class Canceled(val reason: String): PurchaseStatus()
}

/**дефолт 1 и 3

package com.example.sealedclasshomework.sealed_class

open class PurchaseStatus {

    object InProgress: PurchaseStatus()

    object Ready: PurchaseStatus()

    data class Canceled(val reason: String): PurchaseStatus()
}
 */
