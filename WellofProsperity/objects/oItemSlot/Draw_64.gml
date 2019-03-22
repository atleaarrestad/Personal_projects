/// @description Insert description here
// You can write your code in this editor

if drawMe{

	//Draw GUIwindow
	if (hoveringOver){
	draw_sprite(sptHighlight, 0, startX, startY)
	}else{
	draw_sprite(sptMain, 0, startX, startY)
	}

	//Draw item icon
	if (icon != pointer_null){draw_sprite(icon, 0, startX, startY)}
}