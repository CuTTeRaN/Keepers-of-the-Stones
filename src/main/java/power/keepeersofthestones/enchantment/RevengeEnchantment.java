
package power.keepeersofthestones.enchantment;

import power.keepeersofthestones.init.PowerModItems;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class RevengeEnchantment extends Enchantment {
	public RevengeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List
				.of(Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.SWEEPING_EDGE, Enchantments.FIRE_ASPECT,
						Enchantments.KNOCKBACK, Enchantments.MOB_LOOTING, Enchantments.MENDING, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE)
				.contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(PowerModItems.ENERGIUM_SWORD.get(), PowerModItems.ENERGIUM_PICKAXE.get(), PowerModItems.ENERGIUM_AXE.get(),
				PowerModItems.ENERGIUM_SHOVEL.get(), PowerModItems.ENERGIUM_HOE.get()).contains(item);
	}
}
