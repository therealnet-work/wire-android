package com.waz.zclient.preferences.pages

import android.content.Context
import android.view.View
import com.waz.zclient.KotlinServices
import com.waz.zclient.kotlinproxy.JavaInjectable
import com.waz.zclient.kotlinproxy.ContextInjectorOwner

class DevSettingsVieww(context: Context) : View(context),
    JavaInjectable by ContextInjectorOwner(context) {

    val accountManager = inject(KotlinServices::class.java)
}
