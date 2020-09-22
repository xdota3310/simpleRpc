package com.lr.simplerpc.server.core;

import com.lr.simplerpc.common.Util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author xu.shijie
 * @since 2020/9/18
 */
public class RpcDecode extends ByteToMessageDecoder {

    private Class<?> genericClass;

    public RpcDecode(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf inByteBuf, List<Object> outList) throws Exception {
        if(inByteBuf.readableBytes() < 4){
            return;
        }
        inByteBuf.markReaderIndex();
        int dataLength = inByteBuf.readInt();
        if (dataLength < 0) {
            channelHandlerContext.close();
        }
        if (inByteBuf.readableBytes() < dataLength) {
            inByteBuf.resetReaderIndex();
            return;
        }

        byte[] data = new byte[dataLength];
        inByteBuf.readBytes(data);

        Object obj = SerializationUtil.deserialize(data, genericClass);
        outList.add(obj);
    }
}
