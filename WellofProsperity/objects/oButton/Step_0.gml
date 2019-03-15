/// @description Insert description here
// You can write your code in this editor

mX = device_mouse_x_to_gui(0)
mY = device_mouse_y_to_gui(0)
	
//Hovering over
if (mX <= startX + width && mX >= startX && mY <= startY + height && mY >= startY){
		hoveringOver = true;
		if (mouse_check_button_pressed(mb_left)){
			var ev = targetEvent
			with (targetID){event_user(ev)}
		}
	}else{
		hoveringOver = false;
	}