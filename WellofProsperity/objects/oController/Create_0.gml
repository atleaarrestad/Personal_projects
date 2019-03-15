/// @description Insert description here
// You can write your code in this editor

//Setup
width = 1920
height = 1080
window_set_size(width, height)
display_set_gui_size(width, height)
instance_create_depth(0, 0, 0, oEnumerators);




show_debug_overlay(true)

//TEST
testInv = instance_create_depth(0, 0, 0, oInventory); with (testInv){event_user(event.GUI_INIT)}

testitem = instance_create_layer(0, 0, "INSTANCES", oSteelKnife)
sct_inv_AddItem(testitem.itemStatsMap, testInv)

show_debug_overlay(true)
