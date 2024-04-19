@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.theme.pref

import androidx.compose.runtime.Composable
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource

//TODO: remove this file after fix iOS resources
suspend fun getString(resource: StringResource, tag: String = "🦄"): String = try {
    org.jetbrains.compose.resources.getString(resource)
} catch (e: Throwable) {
    e.printStackTrace()
    "$tag:${resource.key}"
}

@Composable
fun stringResource(resource: StringResource): String {
    return runBlocking { getString(resource, tag = "❌") }
//    return org.jetbrains.compose.resources.stringResource(resource)
}
