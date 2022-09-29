
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package power.keepeersofthestones.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class PowerModTabs {
	public static CreativeModeTab TAB_BATTERIES;
	public static CreativeModeTab TAB_ENERGIUM;
	public static CreativeModeTab TAB_TECHNOLOGIES;
	public static CreativeModeTab TAB_ARTIFACTS;
	public static CreativeModeTab TAB_STONES;

	public static void load() {
		TAB_BATTERIES = new CreativeModeTab("tabbatteries") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PowerModItems.EMPTY_BATTERY.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_ENERGIUM = new CreativeModeTab("tabenergium") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PowerModItems.ENERGIUM_INGOT.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TECHNOLOGIES = new CreativeModeTab("tabtechnologies") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PowerModItems.ROCKET_ITEM.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_ARTIFACTS = new CreativeModeTab("tabartifacts") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PowerModItems.BOOK_OF_ELEMENTS.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_STONES = new CreativeModeTab("tabstones") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PowerModItems.GOLDEN_DUST_STONE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
