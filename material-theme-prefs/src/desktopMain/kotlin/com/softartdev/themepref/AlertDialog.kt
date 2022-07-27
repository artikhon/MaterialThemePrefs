@file:OptIn(ExperimentalMaterialApi::class)

package com.softartdev.themepref

import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

@Composable
actual fun AlertDialog(
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable (() -> Unit)?,
    onDismissRequest: () -> Unit
) = AlertDialog(
    title = title,
    text = text,
    confirmButton = confirmButton,
    dismissButton = dismissButton,
    onDismissRequest = onDismissRequest
)

@Composable
actual fun AlertDialog(
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    buttons: @Composable () -> Unit,
    onDismissRequest: () -> Unit
) = AlertDialog(
    title = title,
    text = text,
    buttons = buttons,
    onDismissRequest = onDismissRequest,
)