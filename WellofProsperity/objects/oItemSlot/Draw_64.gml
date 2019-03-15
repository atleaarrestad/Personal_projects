/// @description Insert description here
// You can write your code in this editor


if (hoveringOver){
	//s_GUI_nineSliceTint(windowSprite, startX, startY, startX + width, startY + height, alpha, c_yellow);
	draw_sprite(s_highlight, 0, startX, startY)
}else{
	//s_GUI_nineSlice(windowSprite, startX, startY, startX + width, startY + height, alpha);
	draw_sprite(s_main, 0, startX, startY)
}

if (icon != pointer_null){draw_sprite(icon, 0, startX, startY)}