/// @description Insert description here
// You can write your code in this editor

draw = false
heightPerStat = 16
frameWidth = 128
frameHeight = heightPerStat // 1x value row
windowSprite = s_windowBorderStandard12x12

startX = device_mouse_x_to_gui(0)
startY = device_mouse_y_to_gui(0)


Name = "Not set"
value = 0
type = 0

itemStatValue = ds_list_create()
itemStatText = ds_list_create()
