///@param itemMap
///@param inventoryID

item = argument0
inv = argument1


//GJØRR check her om inventory slotten e free brother
ds_map_copy(inv.invSlot[0].itemStatsMap, item)