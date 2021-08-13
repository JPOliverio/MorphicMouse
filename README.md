# MorphicMouse

MorphicMouse moves the mouse in such a way that it appears anthropomorphic. Meaning an observer wont be able to distinguish if its an actual person or not.

It accomplishes this by generating a Bezier-curve path. Starting where the mouse is currently located to where you want the mouse to move. When the Bezier-curve path is being generated there is a method that ensures there are no gaps or duplicate positions between pixels. Meaning when the mouse follows the path it will move one pixel at a time (no more and no less). The mouse path moves in a curved like path and it also will overshoot the target. This is to make it look anthropomorphic.

![Screen Shot 2021-08-12 at 4 36 13 PM](https://user-images.githubusercontent.com/88540433/129266164-81957c06-2935-4464-914a-ea38c3c71ba0.png)



Future work includes adding static noise, perfecting overshoot, and mouse speed.
