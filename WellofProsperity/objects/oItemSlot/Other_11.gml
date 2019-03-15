/// @description Initialize
// You can write your code in this editor

/// @description generate cached sprite


var surf;
surf = surface_create(width, height);
surface_set_target(surf);
draw_clear_alpha(c_black, 0);
s_GUI_nineSlice(windowSprite, 0, 0, width, height, 1)
s_main = sprite_create_from_surface(surf, 0, 0, width, height, true, true, 0, 0);
surface_reset_target();
surface_free(surf);

var surf;
surf = surface_create(width, height);
surface_set_target(surf);
draw_clear_alpha(c_black, 0);
s_GUI_nineSliceTint(windowSprite, 0, 0, width, height, 1, c_yellow)
s_highlight = sprite_create_from_surface(surf, 0, 0, width, height, true, true, 0, 0);
surface_reset_target();
surface_free(surf);