@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.theme.material

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.softartdev.theme.pref.Res
import com.softartdev.theme.pref.settings
import org.jetbrains.compose.resources.ExperimentalResourceApi
import com.softartdev.theme.pref.stringResource

@Composable
fun SettingsScaffold(
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) = Scaffold(
    topBar = { SettingsTopAppBar(onBackClick, actions) },
    content = content
)

@Composable
fun SettingsTopAppBar(
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    localizedText: String = stringResource(Res.string.settings),
    backVector: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
) = TopAppBar(
    title = { Text(localizedText) },
    navigationIcon = {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = backVector, contentDescription = backVector.name)
        }
    },
    actions = actions
)