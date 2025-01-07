package com.numpol.cmpdynamichome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderLogoView(modifier: Modifier = Modifier) {
    Row(
        modifier.padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(Icons.Default.Star, contentDescription = "Logo")
        OutlinedTextField("text", onValueChange = {}, modifier = Modifier.weight(1f).fillMaxHeight(.5f))
        Icon(Icons.Default.Search, contentDescription = "Search")
        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
    }
}