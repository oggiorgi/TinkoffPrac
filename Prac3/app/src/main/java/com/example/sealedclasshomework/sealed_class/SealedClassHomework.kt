package com.example.sealedclasshomework.sealed_class

/**
 * У нас есть метод getPurchaseStatus(), но сейчас Android Studio ругается на ошибку. Исправьте ее и запустите программу.
 * Что будет выведено в терминале?
 * ответ: 'when' expression must be exhaustive, add necessary 'else' branch
 * Помните, что задачу можно решить несколькими способами.
 */
fun main() {
    getPurchaseStatus(PurchaseStatus.InProgress)
}
/** Первый способ решения это как предлагает решить проблему сам компилятор через else при open class PurchaseStatus
fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }
от
    else -> {}
до
}
 */
// Второй способ сделать класс sealed, тк в отличие от open в нём не обязательно писать else. При sealed class PurchaseStatus
fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }

}

/** Третий вариант
fun getPurchaseStatus(status: PurchaseStatus) {
    when (status) {
        PurchaseStatus.InProgress -> println("доставка в процессе")
        PurchaseStatus.Ready -> println("доставка готова")
        is PurchaseStatus.Canceled -> {
            println("Доставка отменена, причина: ${status.reason}")
        }
    }
}
 */
