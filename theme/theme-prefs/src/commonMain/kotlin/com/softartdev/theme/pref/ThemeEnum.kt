package com.softartdev.theme.pref

import androidx.compose.runtime.Composable
import io.github.softartdev.`theme-prefs`.generated.resources.Res
import io.github.softartdev.`theme-prefs`.generated.resources.dark
import io.github.softartdev.`theme-prefs`.generated.resources.light
import io.github.softartdev.`theme-prefs`.generated.resources.system_default
import org.jetbrains.compose.resources.ExperimentalResourceApi

enum class ThemeEnum {
    Light,
    Dark,
    SystemDefault;

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun toLocalizedString(): String = stringResource(
        resource = when (this) {
            Light -> Res.string.light
            Dark -> Res.string.dark
            SystemDefault -> Res.string.system_default
        }
    )
}