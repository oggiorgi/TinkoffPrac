# Tinkoff Android Kotlin Practice Portfolio

Здесь собраны все практические задания, выполненные в рамках курса Tinkoff Android Kotlin.

##  Структура портфолио

Каждая папка соответствует отдельному практическому заданию курса.

##  Список проектов

### [Prac1: Работа с классами и наследованием](Prac1/)
**Раздел курса:** 6. Классы (Задание 6.2-6.3)
**Дата выполнения:** Февраль 2026

#### 📝 Описание задания:
1. Создать класс-наследник от класса Employee с названием любимой профессии
2. Переопределить методы haveLunch() и goHome()
3. Создать объект своего класса в методе main()
4. Вызвать методы и проверить вывод в терминал

#### 💻 Мое решение:
Создан класс `DataScience`, который наследуется от `Employee`:

```kotlin
class DataScience: Employee() {
    override fun haveLunch() {
        println("Пойду на обед к 2")
    }
    override fun goHome() {
        println("Останусь пока не выполню задачу")
    }
}

```

В методе main():

```kotlin
fun main() {
    val dataScience = DataScience()
    dataScience.haveLunch()  // Вывод: Пойду на обед к 2
    dataScience.goHome()     // Вывод: Останусь пока не выполню задачу
}
```
#### Чему научился:

Наследование классов в Kotlin

Переопределение методов (override)

Работа с open классами и методами

Создание объектов и вызов методов

🔗 Ссылки на код:
### [📁 **ClassHomework.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac1/app/src/main/java/com/example/kotlinclasshomework/kotlinClass/ClassHomework.kt)

### [📁 **Employee.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac1/app/src/main/java/com/example/kotlinclasshomework/kotlinClass/Employee.kt)


---




### [Prac2: Работа с data-классами и фильтрацией коллекций](Prac2/)
**Раздел курса:** 7. Специальные виды классов (Задание 7.2)
**Дата выполнения:** Февраль 2026


### 📝 Описание задания:

Создать data-классы Language и Teacher

Реализовать фильтрацию списка учителей по опыту работы

Вывести имена учителей с опытом больше 5 лет

Если таких учителей нет, вывести сообщение "Учитель с таким опытом не найден"

💻 Мое решение:

Data-классы:

```kotlin
  } else {
        // TODO если список имен пустой, то выведи в терминал "Учитель с таким опытом не найден" отсюда

        println("Учитель с таким опытом не найден")
//досюда

    }
}

/**
 * Метод поиска опытного учителя из списка
 */
private fun getExperiencedTeacher(experience: Int, teacherList: List<Teacher>): List<String> {
    // TODO сейчас метод возвращает пустой список. Напиши здесь фильтрацию поиска учителя из списка teacherList
//от
    return teacherList
        .filter { teacher ->  teacher.progExperience > experience }
        .map {it.name}
//до
}
```


####   Чему научился:

Создание и использование data-классов в Kotlin

Работа с коллекциями (List)

Применение функций высшего порядка: filter() и map()

Использование лямбда-выражений

Обработка условий с проверкой пустоты коллекции

Синтаксис Kotlin для доступа к свойствам объектов (it.name)

🔗 Ссылки на код:

### [📁 **DataClassHomework.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac2/app/src/main/java/com/example/dataclasshomework/dataclass/DataClassHomework.kt)

### [📁 **Language.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac2/app/src/main/java/com/example/dataclasshomework/dataclass/Language.kt)

### [📁 **Teacher.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac2/app/src/main/java/com/example/dataclasshomework/dataclass/Teacher.kt)




---


### [Prac3: Работа с sealed классами и when-выражениями](Prac3/)
**Раздел курса:** 7. Специальные виды классов (Задание 7.4)  
**Дата выполнения:** Февраль 2026

#### 📝 Описание задания:
1. Исправить ошибку компиляции в методе `getPurchaseStatus()`
2. Изучить разницу между `open` и `sealed` классами
3. Реализовать три разных способа решения проблемы
4. Запустить программу и проверить вывод в терминале

#### 💻 Мое решение:

**Первый способ (с `open` классом и `else` branch):**

```kotlin
fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }
    else -> {}
}
```

Второй способ (использование sealed класса):
```kotlin
// PurchaseStatus.kt
sealed class PurchaseStatus {
    object InProgress: PurchaseStatus()
    object Ready: PurchaseStatus()
    data class Canceled(val reason: String): PurchaseStatus()
}

// SealedClassHomework.kt
fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }
}
```

Третий способ (без возвращаемого значения):

```kotlin
fun getPurchaseStatus(status: PurchaseStatus) {
    when (status) {
        PurchaseStatus.InProgress -> println("доставка в процессе")
        PurchaseStatus.Ready -> println("доставка готова")
        is PurchaseStatus.Canceled -> {
            println("Доставка отменена, причина: ${status.reason}")
        }
    }
}
```

Чему научился:
Разница между open и sealed классами

Исчерпывающие (exhaustive) when-выражения

Три способа решения ошибки компиляции в when-выражениях

Работа с object и data-классами внутри sealed иерархии

Условные ветвления в Kotlin


🔗 Ссылки на код:

### [📁 **SealedClassHomework.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac3/app/src/main/java/com/example/sealedclasshomework/sealed_class/SealedClassHomework.kt)

### [📁 **PurchaseStatus.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac3/app/src/main/java/com/example/sealedclasshomework/sealed_class/PurchaseStatus.kt)

---

### [Prac4: Android Activity & UI компоненты](Prac4/)
**Раздел курса:** 11. Компоненты приложения (Задание 11.3, 11.6, 11.10)
**Дата выполнения:** Апрель 2026

#### 📝 Описание задания:
1. Скачать проект по ссылке: `https://github.com/InternetEducation/android_activity_homework`
2. Исправить три файла по комментариям `TODO`:
   - `AndroidManifest.xml` — добавить разрешение на интернет и объявить `MainActivity` как стартовую
   - `res/layout/statistic_card_layout.xml` — настроить размеры и `id` UI-элементов
   - `MainActivity.kt` — добавить `setContentView()` и инициализацию компонентов
3. Запустить приложение и проверить отображение UI-элементов

#### 💻 Мое решение:
Исправлен `AndroidManifest.xml` — добавлены разрешения и объявлена стартовая Activity:

```xml
<!-- Добавил разрешение на использование интернета -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<application ... >
    <!-- Объявил MainActivity как стартовую Activity приложения -->
    <activity
        android:name=".presentation.main.MainActivity"
        android:exported="true"
        android:theme="@style/Theme.Android_homework">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```
Настроен макет statistic_card_layout.xml — заданы размеры и id элементов:
```xml
<!-- Задал ширину элемента равной ширине экрана -->
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/statistic_card_rectangle"
    android:elevation="16dp">

    <!-- Задал высоту и ширину элемента по содержимому + добавил id -->
    <TextView
        android:id="@+id/sum"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginVertical="8dp"
        android:textColor="#49454F"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/total_balance"
        tools:text="52 490 ₽" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
Исправлен MainActivity.kt — добавлен setContentView() и инициализация View:


```kotlin

// Добавил наследование от AppCompatActivity
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val operationAdapter = OperationAdapter()
    
    private lateinit var operationsRecyclerView: RecyclerView
    private lateinit var totalSum: TextView
    private lateinit var outcome: TextView
    private lateinit var income: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Добавил выведение макета activity_main на экран
        setContentView(R.layout.activity_main)

        // Инициализация View-элементов
        operationsRecyclerView = findViewById(R.id.operations_recycler)
        totalSum = findViewById(R.id.sum)
        outcome = findViewById(R.id.outcome)
        income = findViewById(R.id.income)
        progressBar = findViewById(R.id.progress_bar)

        initOperationsRecycler()
        subscribeToOperations()
        subscribeToTotal()
    }

    // Подписка на данные через ViewModel и lifecycleScope
    private fun subscribeToTotal() {
        lifecycleScope.launch {
            viewModel.total.collect { totalItem ->
                income.text = totalItem?.income.toString()
                outcome.text = totalItem?.outcome.toString()
                totalSum.text = totalItem?.total.toString()
                progressBar.progress = totalItem?.progress?.toInt() ?: 0
            }
        }
    }
}
```
Чему научился:
Работа с AndroidManifest.xml — добавление разрешений и объявление стартовой Activity

Верстка в ConstraintLayout — атрибуты match_parent, wrap_content и позиционирование через layout_constraint*

Жизненный цикл Activity — метод onCreate() и обязательный вызов setContentView()

Архитектурные компоненты — подписка на Flow через lifecycleScope и использование by viewModels<>()

Работа с Hilt DI — аннотация @AndroidEntryPoint для инъекции зависимостей

🔗 Ссылки на код:

### [📁 **MainActivity.kt**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac4/app/src/main/java/com/tinkoff/android_homework/presentation/main/MainActivity.kt?spm=a2ty_o01.29997173.0.0.6b645171szpdXB&file=MainActivity.kt)

### [📁 **AndroidManifest.xml**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac4/app/src/main/res/layout/statistic_card_layout.xml?spm=a2ty_o01.29997173.0.0.6b645171szpdXB&file=statistic_card_layout.xml)

### [📁 **statistic_card_layout.xml**](https://github.com/oggiorgi/TinkoffPrac/blob/main/Prac4/app/src/main/res/layout/statistic_card_layout.xml?spm=a2ty_o01.29997173.0.0.6b645171szpdXB&file=statistic_card_layout.xml)

---

