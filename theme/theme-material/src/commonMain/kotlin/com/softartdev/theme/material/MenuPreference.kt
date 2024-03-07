@file:OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.softartdev.theme.material

import androidx.compose.foundation.clickable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.SettingsBrightness
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

@Composable
fun ThemePreferencesCategory() = PreferenceCategory(
    title = stringResource(Res.string.theme),
    vector = Icons.Filled.Brightness4
)

@Composable
fun ThemePreferenceItem(themePrefs: ThemePrefs = LocalThemePrefs.current) = PreferenceItem(
    title = stringResource(Res.string.choose_theme),
    vector = Icons.Filled.SettingsBrightness,
    secondaryText = { Text(text = themePrefs.darkThemeState.value.toLocalizedString()) },
    onClick = themePrefs::showDialog
)

@Composable
fun PreferenceCategory(title: String, vector: ImageVector) = ListItem(
    icon = { Icon(imageVector = vector, contentDescription = title) },
    text = {
        Text(text = title,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.secondaryVariant)
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
    icon = { Icon(imageVector = vector, contentDescription = title) },
    text = { Text(text = title) },
    secondaryText = secondaryText,
    trailing = trailing
)
