// ---------------------------------------------------
// Tags: ItemTag
// ---------------------------------------------------

// <--[tag]
// @attribute <ItemTag.is_ia_item>
// @returns ElementTag(Boolean)
// @description
// Returns whether the item is an ItemsAdder item.
// -->

// <--[tag]
// @attribute <ItemTag.is_ia_block>
// @returns ElementTag(Boolean)
// @description
// Returns whether the item is a placable ItemsAdder item.
// -->

// <--[tag]
// @attribute <ItemTag.ia_namespaced_id>
// @returns ElementTag
// @description
// Returns the full ItemsAdder ID (including namespace) of the ItemTag.
// -->

// <--[tag]
// @attribute <PlayerTag.mod_hash_list>
// @returns ListTag
// @description
// Returns the mod hash list of the player.
// -->

// <--[tag]
// @attribute <PlayerTag.resource_pack_hash_list>
// @returns ListTag
// @description
// Returns the resource pack hash list of the player.
// -->

// <--[tag]
// @attribute <PlayerTag.shader_pack_hash_list>
// @returns ListTag
// @description
// Returns the shader pack hash list of the player.
// -->

// ---------------------------------------------------
// Tags: LocationTag
// ---------------------------------------------------

// <--[tag]
// @attribute <LocationTag.is_ia_block>
// @returns ElementTag(Boolean)
// @group world
// @description
// Returns whether the block is made with ItemsAdder.
// -->

// <--[tag]
// @attribute <LocationTag.ia_namespaced_id>
// @returns ElementTag
// @group world
// @description
// Returns the full ItemsAdder ID (including namespace) of the block.
// -->

// ---------------------------------------------------
// Tags: PlayerTag
// ---------------------------------------------------

// <--[tag]
// @attribute <PlayerTag.hwid>
// @returns ElementTag
// @description
// Returns the HWID of the player.
// -->

// <--[tag]
// @attribute <PlayerTag.has_device_mark[<mark>]>
// @returns ElementTag(Boolean)
// @description
// Returns if the player's device has the specified mark.
// -->

// <--[tag]
// @attribute <PlayerTag.device_marks>
// @returns ListTag
// @description
// Returns player's all device marks.
// -->

// <--[tag]
// @attribute <PlayerTag.waypoints>
// @returns ListTag
// @description
// Returns player's waypoints.
// -->

// <--[tag]
// @attribute <PlayerTag.waypoints>
// @returns ListTag
// @description
// Returns player's waypoints.
// Works with offline players.
// @example
// # Narrates a list of player's waypoint ids.
// - narrate <player.waypoints>
// -->

// ---------------------------------------------------
// Tags: BinaryTag
// ---------------------------------------------------

// <--[tag]
// @attribute <BinaryTag.ed25519_sign[key=<key>]>
// @returns BinaryTag
// @description
// Returns the raw binary signature of the binary data, using the given private key.
// Key must be a BinaryTag.
// @example
// # Narrates "75366EDF8AD933D137732CDED4BCF926A90338EC33054EA7444BFFD5A936566F8B5CD48DC73FD37242C5F937DD1A8DE7F940CC8412B6BBC3BC982B30104DB908".
// - narrate <element[test].utf8_encode.ed25519_sign[key=<binary[AF9812D5558A43A38BA383E87D3E215D3273D39E9973B9E34705804D7F11B25F]>].to_hex>
// -->

// <--[tag]
// @attribute <util.waypoints>
// @returns ListTag
// @description
// Returns a list of all global waypoints.
// -->

// ---------------------------------------------------
// Tags: Util
// ---------------------------------------------------

// <--[tag]
// @attribute <util.waypoints>
// @returns ListTag
// @description
// Returns a list of all global waypoints.
// -->

// <--[tag]
// @attribute <util.waypoints>
// @returns ListTag
// @description
// Returns global waypoints.
// @example
// # Narrates a list of global waypoint ids.
// - narrate <util.waypoints>
// -->

// ---------------------------------------------------
// Player Command: Waypoint
// ---------------------------------------------------

// <--[command]
// @Name Waypoint
// @Syntax waypoint [type:add/update/remove/clear] (id:<id>) (location:<location>) (compass_icon:<#>) (compass_text:<text>) (world_text:<text>|...) (view_distance:<#.#>) (targets:<player>|...)
// @Required 1
// @Maximum 8
// @Short Render a waypoint on player's client HUD screen.
// @group player
//
// @Description
// Render a waypoint on player's client HUD screen.
//
// @Tags
// None
//
// @Usage
// Use to render a waypoint to player's current location. If a line contains a string "%no_background%", it tells player's client NOT to render text's background. If a line contains a string "%scale:<#.##>%", it tells player's client to render the text at the specified scale. If a line contains a string "%distance%", it will be replaced with the distance from player's current location to the waypoint in format "0.00" in real time.
// - waypoint type:add id:test location:<player.location> "compass_text:<red>Test Waypoint" "world_text:%no_background%<red>Hello World</red>|<blue>Distance:</blue> <white>%distance%m</white>|%scale:0.60%Hi! I'm smaller than other lines."
//
// @Usage
// Use to update player's waypoint location.
// - waypoint type:update id:test location:<player.location>
//
// @Usage
// Use to remove player's waypoint.
// - waypoint type:remove id:test targets:<player>
//
// @Usage
// Use to clear all waypoints of all players.
// - waypoint type:clear targets:<player>
//
// @Usage
// If the "players" parameter was not specified, the waypoint will be displayed to everyone.
// - waypoint type:add id:global_waypoint location:<player.location> "compass_text:<red>Global Waypoint" "world_text:<red>Everyone will see this!"
//
// @Usage
// Use to remove a global waypoint.
// - waypoint type:remove id:global_waypoint
//
// @Usage
// Use to clear all of global waypoints.
// - waypoint type:clear
// -->

// ---------------------------------------------------
// Player Command: SetOptions
// ---------------------------------------------------

// <--[command]
// @Name SetOptions
// @Syntax setoptions [text:<text>] (targets:<player>|...)
// @Required 1
// @Maximum 2
// @Short Modify client's options.txt file and apply it to game.
// @group player
//
// @Description
// Modify client's options.txt file and apply it to game.
//
// @Tags
// None
//
// @Usage
// Use to set client's options for all online players.
// - setoptions text:<script.parsed_key[data.default_options]> targets:<server.online_players>
// -->

// ---------------------------------------------------
// Player Command: MarkDevice
// ---------------------------------------------------

// <--[command]
// @Name MarkDevice
// @Syntax markdevice [id:<name>] (targets:<player>|...)
// @Required 1
// @Maximum 2
// @Short Set a mark on player's device.
// @group player
//
// @Description
// Set a mark on player's device.
//
// @Tags
// <PlayerTag.has_device_mark[<mark>]>
//
// @Usage
// Use to set a mark named "blocked" on player's device.
// - markdevice id:blocked
// -->

// ---------------------------------------------------
// Player Command: UnmarkDevice
// ---------------------------------------------------

// <--[command]
// @Name UnmarkDevice
// @Syntax unmarkdevice [id:<name>] (targets:<player>|...)
// @Required 1
// @Maximum 2
// @Short Remove a mark on player's device.
// @group player
//
// @Description
// Remove a mark on player's device.
//
// @Tags
// None
//
// @Usage
// Use to remove a mark named "blocked" on player's device.
// - unmarkdevice id:blocked
// -->

// ---------------------------------------------------
// World Command: SetCustomBlock
// ---------------------------------------------------

// <--[command]
// @Name Set_Custom_Block
// @Syntax set_custom_block [<location>|...] [<id>]
// @Required 2
// @Maximum 2
// @Short Place custom blocks of ItemsAdder.
// @Group world
//
// @Description
// Place custom blocks of ItemsAdder.
//
// @Tags
// None
//
// @Usage
// Use to place a custom block at player's location.
// - set_custom_block <player.location> itemsadder:ruby_block
// -->

// ---------------------------------------------------
// External Command: Waypoint
// ---------------------------------------------------

// <--[command]
// @Name Waypoint
// @Syntax waypoint [type:add/update/remove/clear] (id:<id>) (location:<location>) (compass_icon:<#>) (compass_text:<text>) (world_text:<text>|...) (view_distance:<#.#>) (targets:<player>|...)
// @Required 1
// @Maximum 8
// @Short Render a waypoint on player's client HUD screen.
// @group player
//
// @Description
// Render a waypoint on player's client HUD screen.
//
// @Tags
// None
//
// @Usage
// Use to render a waypoint to player's current location. If a line contains a string "%no_background%", it tells player's client NOT to render text's background. If a line contains a string "%scale:<#.##>%", it tells player's client to render the text at the specified scale. If a line contains a string "%distance%", it will be replaced with the distance from player's current location to the waypoint in format "0.00" in real time.
// - waypoint type:add id:test location:<player.location> "compass_text:<red>Test Waypoint" "world_text:%no_background%<red>Hello World</red>|<blue>Distance:</blue> <white>%distance%m</white>|%scale:0.60%Hi! I'm smaller than other lines."
//
// @Usage
// Use to update player's waypoint location.
// - waypoint type:update id:test location:<player.location>
//
// @Usage
// Use to remove player's waypoint.
// - waypoint type:remove id:test targets:<player>
//
// @Usage
// Use to clear all waypoints of all players.
// - waypoint type:clear targets:<player>
//
// @Usage
// If the "players" parameter was not specified, the waypoint will be displayed to everyone.
// - waypoint type:add id:global_waypoint location:<player.location> "compass_text:<red>Global Waypoint" "world_text:<red>Everyone will see this!"
//
// @Usage
// Use to remove a global waypoint.
// - waypoint type:remove id:global_waypoint
//
// @Usage
// Use to clear all of global waypoints.
// - waypoint type:clear
// -->

// ---------------------------------------------------
// External Command: SetFmVariable
// ---------------------------------------------------

// <--[command]
// @Name SetFmVariable
// @Syntax setfmvariable [name:<name>] [value:<value>] (targets:<player>|...)
// @Required 2
// @Maximum 3
// @Short Set a FancyMenu variable for the client.
// @Group player
//
// @Description
// Set a FancyMenu variable for the client.
//
// @Tags
// None
//
// @Usage
// Use to set a FancyMenu variable for the player.
// - setfmvariable name:test_variable value:<empty>
// -->

// ---------------------------------------------------
// External Command: OpenGui
// ---------------------------------------------------

// <--[command]
// @Name OpenGui
// @Syntax opengui [id:<id>] (targets:<player>|...)
// @Required 1
// @Maximum 2
// @Short Open a screen for the client.
// @Group player
//
// @Description
// Open a screen for the client.
//
// @Tags
// None
//
// @Usage
// Use to open a screen for the player.
// - opengui id:net.minecraft.client.gui.screens.inventory.HorseInventoryScreen
// -->

// ---------------------------------------------------
// External Command: CloseGui
// ---------------------------------------------------

// <--[command]
// @Name CloseGui
// @Syntax closegui (targets:<player>|...)
// @Required 0
// @Maximum 1
// @Short Close current screen for the client.
// @Group player
//
// @Description
// Close current screen for the client.
//
// @Tags
// None
//
// @Usage
// Use to close current screen for the player.
// - closegui
// -->

// ---------------------------------------------------
// Player Event: PlayerChangesOptions
// ---------------------------------------------------

// <--[event]
// @Events
// player changes options
//
// @Regex ^player changes options$
//
// @Group Player
//
// @Triggers when player modifies any option of the client.
//
// @Context
// <context.options_text> returns the new text of the options.txt file.
//
// @Player Always.
//
// @Example
// after player changes options:
// - narrate "You just modified the game options!"
// -->
