package me.roxo.lifestealaddon.models;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class InfomationDataType implements PersistentDataType<byte[], Information> {
    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<Information> getComplexType() {
        return Information.class;
    }

    @NotNull
    @Override
    public byte[] toPrimitive(@NotNull Information complex, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
        return SerializationUtils.serialize(complex);
    }

    @NotNull
    @Override
    public Information fromPrimitive(@NotNull byte[] bytes, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {

        try{
            InputStream is = new ByteArrayInputStream(bytes);

            ObjectInputStream o = new ObjectInputStream(is);
            return (Information) o.readObject();


        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
}
