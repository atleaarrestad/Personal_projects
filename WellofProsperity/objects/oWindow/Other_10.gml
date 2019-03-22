/// @description GUI destroy
// You can write your code in this editor
if ds_list_size(instancesToDestroy) > 0 {
		for (i = 0; i < ds_list_size(instancesToDestroy); i++){
			instance_destroy(ds_list_find_value(instancesToDestroy, i))
			show_debug_message("Destoryed: " + string(ds_list_find_value(instancesToDestroy, i)))
		}
	}
instance_destroy();