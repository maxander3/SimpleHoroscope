# SimpleHoroscope
MainFragment
=====================

<img src="https://user-images.githubusercontent.com/105432796/180973749-e847d8ff-89db-489d-9536-4b91c9c21827.jpg" width="300" />   

Use case:
-----------------------------------

* Открыть PredictFragment из Api

* Открыть PredictsListFragment
________________________________________________________________________________________________________________________________________________________

PredictFragment
=====================

<img src="https://user-images.githubusercontent.com/105432796/180975164-3e26b147-8264-43db-a9a7-29b1eb7b58a0.jpg" width="300" />   <img src="https://user-images.githubusercontent.com/105432796/180973700-b53d901c-ca04-4515-b7f7-33c60e487d5d.jpg" width="300" />

Use case:
-----------------------------------

* Созранить прогноз в базу данных
* Закрыть фрагмент
________________________________________________________________________________________________________________________________________________________
PredictsListFragment
=====================
<img src="https://user-images.githubusercontent.com/105432796/180978744-46504f46-6426-4116-a9d2-5625a5f1247a.jpg" width="300" />  <img src="https://user-images.githubusercontent.com/105432796/180975764-0ef3a37e-f480-40f0-9973-471e1ed20eef.jpg" width="600" height = "300" />   

Use case:
-----------------------------------

* Открыть PredictFragment из базы данных

________________________________________________________________________________________________________________________________________________________
Использованные технологии:
=====================
1. Hilt
2. Room
3. Retrofit
4. Android Gif
5. Android Navigation
6. Gson

Архитектура
=====================
App модуль
* app
  * App
  * Constants
* di
  * DataModule
* presentation
  * single activity
  * fragments
  * viewModels
  * MainListAdapter
  * MainListDiffCallBack
Domain модуль
* domain
  * Usecases
  * HoroscopeRepository
Data модуль
* data
  * HoroscopeRepository - реализация
  * ApiProvider
  * База данных и обьект DAO
