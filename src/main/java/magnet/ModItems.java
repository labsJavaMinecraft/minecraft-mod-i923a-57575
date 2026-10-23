package magnet;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MAGNET = register(
            "magnet",
            new Item.Settings().maxCount(1)
    );

    private static Item register(String name, Item.Settings settings) {
        Identifier id = Identifier.of("magnet", name);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new Item(settings.registryKey(key))
        );
    }

    public static void initialize() {
    }
}