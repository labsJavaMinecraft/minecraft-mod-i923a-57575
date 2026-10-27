package magnet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Magnet implements ModInitializer {
	public static final String MOD_ID = "magnet";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.initialize();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
				.register(entries -> entries.add(ModItems.MAGNET));
		UseItemCallback.EVENT.register((player, world, hand) -> {
			if (!player.getStackInHand(hand).isOf(ModItems.MAGNET)) {
				return ActionResult.PASS;
			}

			if (!world.isClient()) {
				player.sendMessage(
						Text.literal("Магнит активирован!"),
						false
				);
			}

			return ActionResult.SUCCESS;
		});

		LOGGER.info("Проект загружен успешно");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
