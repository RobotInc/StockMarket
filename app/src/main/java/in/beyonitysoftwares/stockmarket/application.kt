package `in`.beyonitysoftwares.stockmarket

import android.app.Application
import io.multimoon.colorful.Defaults
import io.multimoon.colorful.ThemeColor
import io.multimoon.colorful.initColorful

class application: Application() {
    override fun onCreate() {
        super.onCreate()
        val defaults:Defaults = Defaults(
                primaryColor = ThemeColor.BLUE,
                accentColor = ThemeColor.YELLOW,
                useDarkTheme = true,
                translucent = true)
        initColorful(this, defaults)

    }
}