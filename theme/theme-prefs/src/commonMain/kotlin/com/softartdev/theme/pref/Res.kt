@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.theme.pref

import androidx.compose.runtime.Composable
import io.github.softartdev.`theme-prefs`.generated.resources.cancel
import io.github.softartdev.`theme-prefs`.generated.resources.choose_theme
import io.github.softartdev.`theme-prefs`.generated.resources.dark
import io.github.softartdev.`theme-prefs`.generated.resources.error_title
import io.github.softartdev.`theme-prefs`.generated.resources.light
import io.github.softartdev.`theme-prefs`.generated.resources.material_theme_prefs
import io.github.softartdev.`theme-prefs`.generated.resources.material_version
import io.github.softartdev.`theme-prefs`.generated.resources.ok
import io.github.softartdev.`theme-prefs`.generated.resources.set_by_byttery_saver
import io.github.softartdev.`theme-prefs`.generated.resources.settings
import io.github.softartdev.`theme-prefs`.generated.resources.switch_to_material_design_2
import io.github.softartdev.`theme-prefs`.generated.resources.switch_to_material_design_3
import io.github.softartdev.`theme-prefs`.generated.resources.system_default
import io.github.softartdev.`theme-prefs`.generated.resources.theme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource
import io.github.softartdev.`theme-prefs`.generated.resources.Res as InternalRes

//TODO try to remove after update compose multiplatform
object Res {
    suspend fun readBytes(path: String): ByteArray = InternalRes.readBytes(path)

    public object drawable
    public object string
    public object font
}

val Res.string.cancel: StringResource
    get() = InternalRes.string.cancel

val Res.string.choose_theme: StringResource
    get() = InternalRes.string.choose_theme

val Res.string.dark: StringResource
    get() = InternalRes.string.dark

val Res.string.error_title: StringResource
    get() = InternalRes.string.error_title

val Res.string.light: StringResource
    get() = InternalRes.string.light

val Res.string.material_theme_prefs: StringResource
    get() = InternalRes.string.material_theme_prefs

val Res.string.material_version: StringResource
    get() = InternalRes.string.material_version

val Res.string.ok: StringResource
    get() = InternalRes.string.ok

val Res.string.set_by_byttery_saver: StringResource
    get() = InternalRes.string.set_by_byttery_saver

val Res.string.settings: StringResource
    get() = InternalRes.string.settings

val Res.string.switch_to_material_design_2: StringResource
    get() = InternalRes.string.switch_to_material_design_2

val Res.string.switch_to_material_design_3: StringResource
    get() = InternalRes.string.switch_to_material_design_3

val Res.string.system_default: StringResource
    get() = InternalRes.string.system_default

val Res.string.theme: StringResource
    get() = InternalRes.string.theme

suspend fun getString(resource: StringResource): String = "🦄 ${resource.key}"

@Composable
fun stringResource(resource: StringResource): String = "🦄 ${resource.key}"