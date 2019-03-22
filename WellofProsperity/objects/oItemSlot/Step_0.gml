/// @description Insert description here
// You can write your code in this editor
mX = device_mouse_x_to_gui(0)
mY = device_mouse_y_to_gui(0)

if (point_in_rectangle(mX, mY, startX + 1, startY + 1, startX + windowWidth - 1, startY + windowHeight - 1)){
		hoveringOver = true;
		//Create show stats object
		if (statsObject == pointer_null) && !ds_map_empty(itemStatsMap){
			statsObject = s_GUI_createShowItemStatsObj(self)
			show_debug_message("Created stats object for id: " + string(id))
		}
	}else{
		hoveringOver = false;
		if statsObject != pointer_null{
			instance_destroy(statsObject)
			statsObject = pointer_null
			show_debug_message("Destroyed stats object for: " + string(id))
		}
	}
