@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.softartdev.theme.material3

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.SettingsBrightness
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.softartdev.theme.pref.LocalThemePrefs
import com.softartdev.theme.pref.Res
import com.softartdev.theme.pref.ThemePrefs
import com.softartdev.theme.pref.choose_theme
import com.softartdev.theme.pref.theme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import com.softartdev.theme.pref.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ThemePreferencesCategory() = PreferenceCategory(
    title = stringResource(Res.string.theme),
    vector = Icons.Filled.Brightness4
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ThemePreferenceItem(themePrefs: ThemePrefs = LocalThemePrefs.current) = PreferenceItem(
    title = stringResource(Res.string.choose_theme),
    vector = Icons.Filled.SettingsBrightness,
    secondaryText = { Text(text = themePrefs.darkThemeState.value.toLocalizedString()) },
    onClick = themePrefs::showDialog
)

@Composable
fun PreferenceCategory(title: String, vector: ImageVector) = ListItem(
    leadingContent = { Icon(imageVector = vector, contentDescription = title) },
    headlineContent = {
        Text(text = title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary)
    }
)

@Composable
fun PreferenceItem(
    title: String,
    vector: ImageVector,
    onClick: () -> Unit = {},
    secondaryText: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) = ListItem(
    modifier = Modifier.clickable(onClick = onClick),
    leadingContent = { Icon(imageVector = vector, contentDescription = title) },
    headlineContent = { Text(text = title) },
    supportingContent = secondaryText,
    trailingContent = trailing
)
