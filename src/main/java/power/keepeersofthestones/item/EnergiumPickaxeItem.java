
package power.keepeersofthestones.item;

import power.keepeersofthestones.procedures.EnergiumBlockUseProcedure;
import power.keepeersofthestones.init.PowerModTabs;
import power.keepeersofthestones.init.PowerModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class EnergiumPickaxeItem extends PickaxeItem {
	public EnergiumPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 250;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PowerModItems.ENERGIUM_INGOT.get()));
			}
		}, 1, -3f, new Item.Properties().tab(PowerModTabs.TAB_ENERGIUM));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnergiumBlockUseProcedure.execute(entity);
	}
}
