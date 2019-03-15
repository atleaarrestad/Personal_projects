///@param self
var caller = argument0
var m = caller.itemStatsMap
var cstartX = caller.startX
var cstartY = caller.startY
var cwidth = caller.width
var cheight = caller.height

obj = instance_create_layer(0, 0, "GUI", oItemStats)

with (obj){
	draw = true;
	name = ds_map_find_value(m, stat.NAME)
	value = ds_map_find_value(m, stat.VALUE)
	type = ds_map_find_value(m, stat.TYPE)
	
	var result = ds_map_find_value(m, stat.CRITICAL_CHANCE); if result != undefined{ds_list_add(itemStatText, "Critical Chance: "); ds_list_add(itemStatValue, result)}
	var result = ds_map_find_value(m, stat.CRITICAL_DAMAGE); if result != undefined{ds_list_add(itemStatText, "Critical Dmg: "); ds_list_add(itemStatValue, result)}
	var result = ds_map_find_value(m, stat.REACH); if result != undefined{ds_list_add(itemStatText, "Reach: "); ds_list_add(itemStatValue, result)}
	var result = ds_map_find_value(m, stat.ARMOR_PEN); if result != undefined{ds_list_add(itemStatText, "Armor Pen: "); ds_list_add(itemStatValue, result)}
	var result = ds_map_find_value(m, stat.VITALITY); if result != undefined{ds_list_add(itemStatText, "Vitality: "); ds_list_add(itemStatValue, result)}
	
	frameHeight += ds_list_size(itemStatValue) * heightPerStat
	
	startX = ((cstartX + cwidth/2) - frameWidth/2)
	startY = cstartY - frameHeight
	
}


return obj