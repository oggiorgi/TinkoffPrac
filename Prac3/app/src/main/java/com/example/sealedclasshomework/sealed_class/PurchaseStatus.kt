package com.example.sealedclasshomework.sealed_class

open class PurchaseStatus {

    object InProgress: PurchaseStatus()

    object Ready: PurchaseStatus()

    data class Canceled(val reason: String): PurchaseStatus()
}
