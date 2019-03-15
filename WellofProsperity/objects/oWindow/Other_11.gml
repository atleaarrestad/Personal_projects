/// @description Initialize


//exitButton
if (exitButton){
	buttonExit = instance_create_layer(0, 0, "GUI", oButtonExit);
	buttonExit.startX = startX + width - buttonExit.width;
	buttonExit.startY = startY;
	buttonExit.targetEvent = event.GUI_EXIT;
	buttonExit.targetID = id;
	ds_list_add(instancesToDestroy, buttonExit.id);
}
