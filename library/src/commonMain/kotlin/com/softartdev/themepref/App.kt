package com.softartdev.themepref

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun App() {
    val writePref: (ThemeEnum) -> Unit = { /*TODO*/ }
    val dialogHolder: DialogHolder = remember { DialogHolder() }
    val darkThemeState: MutableState<ThemeEnum> = remember { mutableStateOf(ThemeEnum.SystemDefault) }
    val materialThemeColors = when (darkThemeState.value) {
        ThemeEnum.Light -> lightColors()
        ThemeEnum.Dark -> darkColors()
        ThemeEnum.SystemDefault -> if (isSystemInDarkTheme()) darkColors() else lightColors()
    }
    MaterialTheme(colors = materialThemeColors) {
        SettingsScreenBody(
            changeTheme = { dialogHolder.showThemeChange(darkThemeState, writePref) },
            showDialogIfNeed = dialogHolder.showDialogIfNeed,
            currentThemeTextContent = { Text(text = darkThemeState.value.toLocalizedString()) },
        )
    }
}
