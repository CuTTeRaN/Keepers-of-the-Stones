
package power.keepeersofthestones.item;

import power.keepeersofthestones.procedures.EnergiumBlockProcedure;
import power.keepeersofthestones.init.PowerModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class EnergiumIngotItem extends Item {
	public EnergiumIngotItem() {
		super(new Item.Properties().tab(PowerModTabs.TAB_TECHNOLOGIES_AND_ARTIFACTS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnergiumBlockProcedure.execute(entity);
	}
}
