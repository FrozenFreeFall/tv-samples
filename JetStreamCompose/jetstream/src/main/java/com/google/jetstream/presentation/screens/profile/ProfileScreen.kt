/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.jetstream.presentation.screens.profile

import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.tv.foundation.ExperimentalTvFoundationApi
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetstream.R
import com.google.jetstream.presentation.screens.dashboard.rememberChildPadding
import com.google.jetstream.presentation.theme.JetStreamTheme
import com.google.jetstream.presentation.utils.FocusGroup
import com.google.jetstream.tvmaterial.DenseListItem
import com.google.jetstream.tvmaterial.ListItemDefaults

@OptIn(
    ExperimentalTvFoundationApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun ProfileScreen(
    @FloatRange(from = 0.0, to = 1.0)
    sidebarWidthFraction: Float = 0.32f
) {
    val childPadding = rememberChildPadding()
    val profileNavController = rememberNavController()

    val backStack by profileNavController.currentBackStackEntryAsState()
    val currentDestination =
        remember(backStack?.destination?.route) { backStack?.destination?.route }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var isLeftColumnFocused by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = childPadding.start, vertical = childPadding.top)
    ) {
        FocusGroup {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = sidebarWidthFraction)
                    .fillMaxHeight()
                    .onFocusChanged {
                        isLeftColumnFocused = it.hasFocus
                    },
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProfileScreens.values().forEachIndexed { index, profileScreen ->
                    DenseListItem(
                        icon = {
                            Icon(
                                modifier = Modifier
                                    .padding(vertical = 2.dp)
                                    .padding(start = 4.dp)
                                    .size(20.dp),
                                painter = painterResource(id = profileScreen.icon),
                                contentDescription = stringResource(
                                    id = R.string.profile_screen_listItem_icon_content_description,
                                    profileScreen.tabTitle
                                )
                            )
                        },
                        headlineText = {
                            Text(
                                text = profileScreen.tabTitle,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        isSelected = currentDestination == profileScreen.name,
                        onSelectionChanged = { focusManager.moveFocus(FocusDirection.Right) },
                        modifier = Modifier
                            .restorableFocus()
                            .fillMaxWidth()
                            .then(
                                if (index == 0) Modifier.focusRequester(focusRequester) else Modifier
                            )
                            .onFocusChanged {
                                if (it.isFocused && currentDestination != profileScreen.name) {
                                    profileNavController.navigate(profileScreen()) {
                                        currentDestination?.let { nnCurrentDestination ->
                                            popUpTo(nnCurrentDestination) { inclusive = true }
                                        }
                                        launchSingleTop = true
                                    }
                                }
                            },
                        scale = ListItemDefaults.scale(focusedScale = 1f),
                        color = ListItemDefaults.color(
                            focusedColor = MaterialTheme.colorScheme.inverseSurface,
                            selectedColor = MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.4f)
                        ),
                        contentColor = ListItemDefaults.contentColor(
                            selectedColor = MaterialTheme.colorScheme.surface
                        ),
                        shape = ListItemDefaults.shape(shape = MaterialTheme.shapes.extraSmall)
                    )
                }
            }
        }

        var selectedLanguageIndex by rememberSaveable { mutableStateOf(0) }
        var isSubtitlesChecked by rememberSaveable { mutableStateOf(true) }
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .onPreviewKeyEvent {
                    if (it.key == Key.Back && it.type == KeyEventType.KeyUp) {
                        // Using 'while' because AccountsScreen has a grid that has multiple items
                        // in a row for which we would need to press D-Pad Left multiple times
                        while (!isLeftColumnFocused) {
                            focusManager.moveFocus(FocusDirection.Left)
                        }
                        return@onPreviewKeyEvent true
                    }
                    false
                },
            navController = profileNavController,
            startDestination = ProfileScreens.Accounts(),
            builder = {
                composable(ProfileScreens.Accounts()) {
                    AccountsSection()
                }
                composable(ProfileScreens.About()) {
                    AboutSection()
                }
                composable(ProfileScreens.Subtitles()) {
                    SubtitlesSection(
                        isSubtitlesChecked = isSubtitlesChecked,
                        onSubtitleCheckChange = { isSubtitlesChecked = it }
                    )
                }
                composable(ProfileScreens.Language()) {
                    LanguageSection(
                        selectedIndex = selectedLanguageIndex,
                        onSelectedIndexChange = { selectedLanguageIndex = it }
                    )
                }
                composable(ProfileScreens.SearchHistory()) {
                    SearchHistorySection()
                }
                composable(ProfileScreens.HelpAndSupport()) {
                    HelpAndSupportSection()
                }
            }
        )
    }
}


@Preview(device = Devices.TV_1080p)
@Composable
fun ProfileScreenPreview() {
    JetStreamTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            ProfileScreen()
        }
    }
}