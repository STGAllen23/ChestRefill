package io.github.aquerr.chestrefill.entities;

import com.flowpowered.math.vector.Vector3i;

import java.util.UUID;

/**
 * Created by Aquerr on 2018-02-14.
 */
public class ChestLocation
{
    private Vector3i blockPosition;
    private UUID worldUUID;

    public ChestLocation(Vector3i blockPosition, UUID worldUUID)
    {
        this.blockPosition = blockPosition;
        this.worldUUID = worldUUID;
    }

    public Vector3i getBlockPosition()
    {
        return this.blockPosition;
    }

    public UUID getWorldUUID()
    {
        return this.worldUUID;
    }
}
