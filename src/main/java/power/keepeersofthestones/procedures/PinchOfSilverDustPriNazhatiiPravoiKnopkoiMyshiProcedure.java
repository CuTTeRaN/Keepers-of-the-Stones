package power.keepeersofthestones.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class PinchOfSilverDustPriNazhatiiPravoiKnopkoiMyshiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
			SoundGUIProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
			CultPlantProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 3) {
			SpawnGUIProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 4) {
			OpenRedstoneBundleProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 5) {
			OpenBuildingGUIProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 6) {
			EclipseUseProcedure.execute(world, entity, itemstack);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 7) {
			StormUseProcedure.execute(world, entity, itemstack);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 8) {
			SunRegenOnMeProcedure.execute(world, entity, itemstack);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 9) {
			SunRayUseProcedure.execute(world, entity, itemstack);
		} else if (Mth.nextInt(RandomSource.create(), 1, 10) == 10) {
			AccelerationTimeUseProcedure.execute(world, x, y, z, entity, itemstack);
		}
	}
}
