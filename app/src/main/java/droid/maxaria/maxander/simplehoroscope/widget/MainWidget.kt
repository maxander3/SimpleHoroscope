package droid.maxaria.maxander.simplehoroscope.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.preference.PreferenceManager
import android.provider.Settings.Global.getString
import android.widget.RemoteViews
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.simplehoroscope.ERROR_String
import droid.maxaria.maxander.simplehoroscope.R
import droid.maxaria.maxander.simplehoroscope.bundleSharedName
import droid.maxaria.maxander.simplehoroscope.sharedPredictName
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


class MainWidget : AppWidgetProvider() {
    @Inject
    lateinit var getPredictUseCase:GetPredictUseCase
    private val data = MutableLiveData<ForecastModel>()
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }

    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {
    val views = RemoteViews(context.packageName, R.layout.main_widget)
    val prefs=context.getSharedPreferences("Sign",Context.MODE_PRIVATE)
    val sign = prefs.getString(bundleSharedName, ERROR_String)
    val predict = prefs.getString(sharedPredictName, ERROR_String)
    views.setTextViewText(R.id.widget_txt,predict)
    views.setTextViewText(R.id.widget_sign,sign)
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}