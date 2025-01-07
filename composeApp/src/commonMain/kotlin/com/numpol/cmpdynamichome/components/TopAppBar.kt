package com.numpol.cmpdynamichome.components

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.numpol.cmpdynamichome.TopNavItem
import com.numpol.cmpdynamichome.TrueOrange

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier.background(TrueOrange),
        contentColor = Color.Red,
        containerColor = TrueOrange,
    ) {
        TopNavItem.values().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = false,
                onClick = {  },
                label = { Text(item.label) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                modifier = Modifier.background(TrueOrange)
            )
        }
    }
}


