package com.numpol.cmpdynamichome

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Transfer: TopNavItem("Transfer", Icons.Default.KeyboardArrowUp, "Transfer")
    data object Receive: TopNavItem("Receive", Icons.Default.KeyboardArrowDown, "Receive")
    data object Scan: TopNavItem("Scan", Icons.Default.Search, "Scan")
    data object Pay: TopNavItem("Pay", Icons.Default.Share, "Pay")

    companion object {
        fun values(): List<TopNavItem> {
            return listOf(Transfer, Receive, Scan, Pay)
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Main: BottomNavItem("Home", Icons.Default.Home, "Home")
    data object Financial: BottomNavItem("Financial", Icons.Default.Lock, "Financial")
    data object History: BottomNavItem("History", Icons.Default.Menu, "History")
    data object Rewards: BottomNavItem("Rewards", Icons.Default.Favorite, "Rewards")
    data object Account: BottomNavItem("Account", Icons.Default.AccountCircle, "Account")

    companion object {
        fun values(): List<BottomNavItem> {
            return listOf(Main, Financial, History, Rewards, Account)
        }
    }
}