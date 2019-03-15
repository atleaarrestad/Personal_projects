/// @description Insert description here
// You can write your code in this editor



//Create slots
padding = 4
for(v = 0; v < invSlotsV; v++){
	for (h = 0; h < invSlotsH; h++){
		var i = h + invSlotsH*v
		invSlot[i] = instance_create_layer(0, 0, "GUI", oItemSlot)
		with (invSlot[i]){event_user(event.GUI_INIT)}
		ds_list_add(instancesToDestroy, invSlot[i])
		
		invSlot[i].startX = startX + h*invSlot[i].width + padding
		invSlot[i].startY = startY + v*invSlot[i].height + padding
	}
}

//Set window size to fit the inventory
width = invSlot[0].width * invSlotsH + padding*2
height = invSlot[0].height * invSlotsV + padding*2
invSize = invSlotsH * invSlotsV


//set slots to be empty
for (i = 0; i < invSize; i++){
	invSlotFree[i] = 0
}



//Init window with no exitbutton
exitButton = false;
event_inherited()

show_debug_message("Inventory created! (userEventInventory)")


