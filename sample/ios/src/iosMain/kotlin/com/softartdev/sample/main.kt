@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.sample

import androidx.compose.ui.main.defaultUIKitMain
import androidx.compose.ui.window.ComposeUIViewController
import com.softartdev.shared.App
import com.softartdev.theme.pref.getString
import io.github.softartdev.theme_prefs.generated.resources.Res
import io.github.softartdev.theme_prefs.generated.resources.material_theme_prefs
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi

fun main() = defaultUIKitMain(
    executableName = runBlocking { getString(Res.string.material_theme_prefs) },
    rootViewController = ComposeUIViewController { App() }
)
