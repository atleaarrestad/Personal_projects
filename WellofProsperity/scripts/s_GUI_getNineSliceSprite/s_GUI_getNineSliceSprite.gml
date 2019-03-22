///@param sprite
///@param width
///@param height
///@param alpha
///@param tintColour
var sprite = argument0;
var width = argument1;
var height = argument2;
var alpha = argument3;
var color = argument4;

var slice_width = sprite_get_width(sprite)/3;
var slice_height = sprite_get_height(sprite)/3;

if (sprite_get_width(sprite)%3 != 0 || sprite_get_height(sprite)%3 != 0) {
	show_debug_message("WARNING: Sprite is not a multiple of 3.");
}


//Create surface
var surf = surface_create(width, height);
surface_set_target(surf);
draw_clear_alpha(c_black, 0);


// Draw sprite
// Top
draw_sprite_part_ext(sprite, 0, 0, 0, slice_width, slice_height, 0, 0, 1, 1, color, alpha); // Left
draw_sprite_part_ext(sprite, 0, slice_width, 0, slice_width, slice_height, slice_width, 0, (width-slice_width*2)/slice_width, 1, color, alpha); // Middle
draw_sprite_part_ext(sprite, 0, slice_width*2, 0, slice_width, slice_height, width-slice_width, 0, 1, 1, color, alpha); // Right

// Middle
draw_sprite_part_ext(sprite, 0, 0, slice_height, slice_width, slice_height, 0, slice_height, 1, (height-slice_height*2)/slice_height, color, alpha); // Left
draw_sprite_part_ext(sprite, 0, slice_width, slice_height, slice_width, slice_height, slice_width, slice_height, (width-slice_width*2)/slice_width, (height-slice_height*2)/slice_height, color, alpha); // Middle
draw_sprite_part_ext(sprite, 0, slice_width*2, slice_height, slice_width, slice_height, width-slice_width, slice_height, 1, (height-slice_height*2)/slice_height, color, alpha); // Right

// Bottom
draw_sprite_part_ext(sprite, 0, 0, slice_height*2, slice_width, slice_height*2, 0, height-slice_height, 1, 1, color, alpha); // Left
draw_sprite_part_ext(sprite, 0, slice_width, slice_height*2, slice_width, slice_height, slice_width, height-slice_height, (width-slice_width*2)/slice_width, 1, color, alpha); // Middle
draw_sprite_part_ext(sprite, 0, slice_width*2, slice_height*2, slice_width, slice_height, width-slice_width, height-slice_height, 1, 1, color, alpha); // Right

// Create sprite
newSprite = sprite_create_from_surface(surf, 0, 0, width, height, true, true, 0, 0);
surface_reset_target();
surface_free(surf);
show_debug_message("Sprite successfully created/returned")
return newSprite;