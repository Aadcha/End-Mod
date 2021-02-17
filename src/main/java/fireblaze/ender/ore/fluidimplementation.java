package fireblaze.ender.ore;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


public abstract class fluidimplementation extends abstractfluid
{
    @Override
    public Fluid getStill()
    {
        return EnderOre.STILL_ACID;
    }
 
    @Override
    public Fluid getFlowing()
    {
        return EnderOre.FLOWING_ACID;
    }
 
    @Override
    public Item getBucketItem()
    {
        return EnderOre.ACID_BUCKET;
    }
 
    @Override
    protected BlockState toBlockState(FluidState fluidState)
    {
        // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return EnderOre.ACID.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
    }
 
    public static class Flowing extends fluidimplementation
    {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
        {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }
 
        @Override
        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }
 
        @Override
        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
    }
 
    public static class Still extends fluidimplementation
    {
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }
 
        @Override
        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
    }
}