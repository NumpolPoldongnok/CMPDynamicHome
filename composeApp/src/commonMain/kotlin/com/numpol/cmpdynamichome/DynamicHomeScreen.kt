package com.numpol.cmpdynamichome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.numpol.cmpdynamichome.components.BottomAppBar
import com.numpol.cmpdynamichome.components.HeaderLogoView
import com.numpol.cmpdynamichome.components.TopAppBar
import kotlin.math.roundToInt

@Composable
fun DynamicHomeScreen() {
    // Constants
    val headerHeight = 120.dp
    val headerOffset = 140f
    val bottomBarHeight = 80.dp

    // Animated offset for smooth snapping
    var offsetY by remember { mutableStateOf(0f) }
    var ratio by remember { mutableStateOf(0f) } // Ratio represents the relative position of the cover section between its expanded and collapsed states.
    var isCoverExpanded by remember { mutableStateOf(true) }
    var isDragging by remember { mutableStateOf(false) }

    val animatedOffsetY by animateFloatAsState(
        targetValue = offsetY,
        animationSpec = tween(durationMillis = if (isDragging) 0 else 300)
    )

    val animatedHeaderOffsetY by animateFloatAsState(
        targetValue = if (isDragging) -headerOffset * ratio else (-headerOffset * if (isCoverExpanded) 0f else 1f),
        animationSpec = tween(durationMillis = if (isDragging) 0 else 300)
    )

    val density = LocalDensity.current // Get the density for DP-to-PX conversion

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val boxHeightPx = with(density) { maxHeight.toPx() } // Convert Dp to Px
        val headerHeightPx = with(density) { headerHeight.toPx() }
        val bottomBarHeightPx = with(density) { bottomBarHeight.toPx() }
        val maxDragHeightPx = boxHeightPx - bottomBarHeightPx - headerHeightPx

        // Background view
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(TrueOrange)
        ) {
            // BG view
            Box(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.8f)
                    .align(Alignment.Center)
            )
        }

        // Top bar moves out based on the ratio
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
                .offset {
                    IntOffset(0, animatedHeaderOffsetY.roundToInt())
                }
                .background(Color.White)
        ) {
            Column(Modifier.fillMaxSize()) {
                HeaderLogoView(Modifier.fillMaxWidth().height(50.dp))
                TopAppBar()
            }
        }

        // Cover section
        Box(
            Modifier
                .offset {
                    IntOffset(0, (headerHeightPx + animatedOffsetY).roundToInt())
                }
                .fillMaxSize()
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onDragStart = { isDragging = true },
                        onDragCancel = { isDragging = false },
                        onDragEnd = {
                            // Update state and offset when drag ends

                            // If cover is expanded and ratio is greater than 0.3, collapse the cover section
                            // If cover is expanded and ratio is less than 0.3, snap back to expanded state
                            // If cover is collapsed and ratio is less than 0.7, expand the cover section
                            // If cover is collapsed and ratio is greater than 0.7, snap back to collapsed state

                            // The threshold value (e.g., 0.3 for expanded state and 0.7 for collapsed state)
                            // provides a balance between user intent and accidental gestures. Adjusting these
                            // values can make the snapping behavior feel more natural or strict based on design needs.
                            if (isCoverExpanded) {
                                when {
                                    ratio > 0.3 -> isCoverExpanded = false // User pulled down sufficiently to collapse
                                    else -> ratio = if (isCoverExpanded) {
                                        0.0f // Snap back to fully expanded
                                    } else 1f
                                }
                            } else {
                                when {
                                    ratio < 0.7 -> isCoverExpanded = true // User pulled up sufficiently to expand
                                    else -> ratio = if (isCoverExpanded) {
                                        0.0f // Snap back to fully collapsed
                                    } else 1f
                                }
                            }
                            offsetY = if (isCoverExpanded) 0f else maxDragHeightPx
                            isDragging = false
                        }
                    ) { _, dragAmount ->
                        // Update offset during drag
                        val originalY = offsetY
                        val newValue = (originalY + dragAmount)
                            .coerceIn(0f, maxDragHeightPx) // Ensure the offset stays within bounds
                        offsetY = newValue

                        // Ratio determines the state of the cover (0 = fully expanded, 1 = fully collapsed)
                        ratio = newValue / maxDragHeightPx

                        // This ratio is used to animate the position and state of the cover section.
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(isCoverExpanded, enter = fadeIn(), exit = fadeOut()) {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Pull down", modifier = Modifier.padding(16.dp))
                }
            }
        }

        // Bottom bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(bottomBarHeight)
                .background(Color.White, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                isCoverExpanded,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                BottomAppBar()
            }
            AnimatedVisibility(
                !isCoverExpanded,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text("Pull up")
            }
        }
    }
}