/// @description Insert description here
// You can write your code in this editor


//Draw button
if !(hoveringOver){
	s_GUI_nineSlice(windowSprite, startX, startY, startX + width, startY + height, 1);
}else{
	s_GUI_nineSlice(windowSprite, startX, startY, startX + width, startY + height, 0.7);
}


//Draw text
draw_set_color(textColor);
draw_set_font(font);
xOffset = width/2 - (string_width(text)/2)
yOffset = height/2 - (string_height(text)/2) + 1
draw_text(startX + xOffset, startY + yOffset, text);
