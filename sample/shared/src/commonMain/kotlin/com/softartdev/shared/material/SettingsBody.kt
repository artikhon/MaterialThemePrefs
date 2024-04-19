@file:OptIn(ExperimentalResourceApi::class)

package com.softartdev.shared.material

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Style
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.softartdev.shared.AppState
import com.softartdev.theme.material.PreferenceItem
import com.softartdev.theme.material.SettingsScaffold
import com.softartdev.theme.material.ThemePreferenceItem
import com.softartdev.theme.material.ThemePreferencesCategory
import com.softartdev.theme.pref.PreferableMaterialTheme.themePrefs
import io.github.softartdev.theme_prefs.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import com.softartdev.theme.pref.stringResource
import io.github.softartdev.theme_prefs.generated.resources.material_version
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
@Composable
fun SettingsBody(
    onBackClick: () -> Unit = { AppState.showNote.value = !AppState.showNote.value },
) = SettingsScaffold(onBackClick, barActions()) { // includes TopAppBar
    Box(modifier = Modifier.padding(it)) {
        Column {
            ThemePreferencesCategory() // subtitle
            ThemePreferenceItem() // menu item
            MaterialSwitchPreferenceItem()
        }
        themePrefs.showDialogIfNeed() // shows when menu item clicked
    }
}

@Composable
fun MaterialSwitchPreferenceItem() = PreferenceItem(
    title = stringResource(Res.string.material_version),
    vector = Icons.Filled.Style,
    secondaryText = { Text(AppState.secondaryText) },
    onClick = AppState.switchMaterialCallback,
    trailing = { Switch(checked = AppState.showMaterial3.value, onCheckedChange = AppState.changeMaterialCallback) }
)
