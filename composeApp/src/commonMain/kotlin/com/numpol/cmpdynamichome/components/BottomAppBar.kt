package com.numpol.cmpdynamichome.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.numpol.cmpdynamichome.BottomNavItem

@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        BottomNavItem.values().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = false,
                onClick = {  },
                label = { Text(item.label) },
                icon = { Icon(item.icon, contentDescription = item.label) }
            )
        }
    }
}