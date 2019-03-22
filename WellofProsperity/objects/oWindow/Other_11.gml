/// @description Initialize


//exitButton
if (exitButton){
	buttonExit = instance_create_layer(0, 0, "GUI", oButtonExit);
	buttonExit.startX = startX + windowWidth - buttonExit.width;
	buttonExit.startY = startY - buttonExit.height;
	buttonExit.targetEvent = event.GUI_EXIT;
	buttonExit.targetID = id;
	ds_list_add(instancesToDestroy, buttonExit.id);
}

windowSpriteSliced = s_GUI_getNineSliceSprite(windowSprite, windowWidth, windowHeight, alpha, tintColor)
