package denoflionsx.PluginsforForestry.Net.Packets;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import denoflionsx.PluginsforForestry.Net.ContainerPlayerBackup;
import denoflionsx.PluginsforForestry.Net.PfFPacketHandler;
import denoflionsx.PluginsforForestry.Plugins.LiquidRoundup.PluginLR;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class HandlerWoodenBucketSync implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        ContainerPlayerBackup.bucket = ContainerPlayerBackup.doBackup(PluginLR.woodenBucket);
        PluginLR.woodenBucket.setFluids(PfFPacketHandler.PacketMaker.getSyncDataFromPacket(packet));
        PluginLR.woodenBucket.regenerateMaps(PfFPacketHandler.PacketMaker.getFlagFromSyncPacket(packet), PfFPacketHandler.PacketMaker.getHashFromSyncPacket(packet));
    }
}
