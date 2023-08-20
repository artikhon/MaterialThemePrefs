package com.softartdev.theme.material3

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import com.softartdev.theme.pref.*

class Material3ThemePrefs(
    preferenceHelper: PreferenceHelper,
    dialogHolder: DialogHolder = DialogHolder(),
    val darkColorScheme: ColorScheme = darkColorScheme(),
    val lightColorScheme: ColorScheme = lightColorScheme()
) : ThemePrefs(preferenceHelper, dialogHolder) {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = when (darkThemeState.value) {
            ThemeEnum.Light -> lightColorScheme
            ThemeEnum.Dark -> darkColorScheme
            ThemeEnum.SystemDefault -> if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme
        }
}

val ThemePrefs.colorScheme: ColorScheme
    @Composable
    @ReadOnlyComposable
    get() {
        val material3ThemePrefs = this as Material3ThemePrefs
        return material3ThemePrefs.colorScheme
    }

fun ThemePrefs.showDialog() = dialogHolder.showThemeChange(
    darkThemeState = darkThemeState,
    writePref = preferenceHelper::themeEnum::set
)

@Composable
fun rememberThemePrefs(): Material3ThemePrefs {
    val preferenceHelper = rememberPreferenceHelper()
    return remember { Material3ThemePrefs(preferenceHelper) }
}

@Composable
fun rememberThemePrefs(
    preferHelper: PreferenceHelper = rememberPreferenceHelper(),
    dialogHolder: DialogHolder = DialogHolder(),
    darkColorScheme: ColorScheme = darkColorScheme(),
    lightColorScheme: ColorScheme = lightColorScheme()
) = remember(
    key1 = dialogHolder,
    key2 = darkColorScheme,
    key3 = lightColorScheme
) {
    Material3ThemePrefs(
        preferenceHelper = preferHelper,
        dialogHolder = dialogHolder,
        darkColorScheme = darkColorScheme,
        lightColorScheme = lightColorScheme
    )
}
