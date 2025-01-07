# Dynamic Home Screen with Jetpack Compose  

This project demonstrates a dynamic and interactive home screen built using **Jetpack Compose**. The design includes smooth animations, drag-and-snap behavior, and responsive UI components. It's inspired by modern super-apps like **TrueMoney** and showcases the potential of **Compose Multiplatform** for building cross-platform apps.  

---

## Features  

- **Animated Header & Cover Section**  
  - Smooth animations using `animateFloatAsState`.  
  - Expandable and collapsible cover section with snap-to-position behavior.  

- **Drag Gesture Handling**  
  - Implemented `pointerInput` and `detectVerticalDragGestures` to provide an intuitive drag experience.  
  - Covers dynamic ratio-based snapping for responsive feedback.  

- **Responsive Design**  
  - Utilizes `BoxWithConstraints` for adaptive layout.  
  - Resizes and positions elements dynamically based on screen dimensions.  

- **Animated Visibility**  
  - Transitions UI elements in and out of view using `AnimatedVisibility`.  

---

## How It Works  

1. **Gesture Handling**  
   - Drag gestures are detected using `pointerInput` and `detectVerticalDragGestures`.  
   - Based on the drag amount, the offset is updated and mapped to a ratio for animation and snapping decisions.  

2. **Smooth Animations**  
   - The `animateFloatAsState` API ensures transitions between states are smooth and visually appealing.  

3. **Snap Behavior**  
   - Thresholds determine whether the cover expands, collapses, or snaps back.  
   - Example:  
     - Dragging beyond 30% of the height collapses the cover.  
     - Dragging below 70% when collapsed expands the cover.  

4. **Responsive Layout**  
   - `BoxWithConstraints` calculates layout dimensions dynamically, ensuring the UI adapts to various screen sizes.  

---

## Requirements  

- **Kotlin**  
- **Jetpack Compose**  
- **Android Studio Flamingo+**  

---

## How to Run  

1. Clone this repository:  
   ```bash  
   git clone https://github.com/yourusername/dynamic-home-screen.git  
   ```  

2. Open the project in **Android Studio**.  

3. Build and run the project on an Android or iOS emulator/device.  

---

## Future Enhancements  

- Add more complex animations and transitions.  
- Support landscape mode and tablet layouts.  
- Implement additional UI components inspired by super-app designs.  

---

## Contributing  

Contributions are welcome! Please fork the repository and submit a pull request with your changes.  

---

## License  

This project is licensed under the [MIT License](LICENSE).  

---

## Acknowledgments  

Special thanks to the Jetpack Compose team for enabling cross-platform UI development with robust animation support.  

---  

Happy coding! 🚀
