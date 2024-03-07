@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.sample

import androidx.compose.ui.main.defaultUIKitMain
import androidx.compose.ui.window.ComposeUIViewController
import com.softartdev.shared.App
import com.softartdev.theme.pref.Res
import com.softartdev.theme.pref.getString
import com.softartdev.theme.pref.material_theme_prefs
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi

fun main() = defaultUIKitMain(
    executableName = runBlocking { getString(Res.string.material_theme_prefs) },
    rootViewController = ComposeUIViewController { App() }
)
