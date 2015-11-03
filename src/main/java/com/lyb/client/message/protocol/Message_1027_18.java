package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 已领奖的id
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_18 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 18;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 18);

	private int huoyuedu;
	private IDArray iDArray;

	private static IntMessageParameterHandler huoyueduHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Huoyuedu");

	public static Message_1027_18 create() {
		return new Message_1027_18();
	}

	/**
	 * @return the huoyuedu
	 */
	public int getHuoyuedu() {
		return huoyuedu;
	}

	/**
	 * @param huoyuedu
	 *            the huoyuedu to set
	 */
	public void setHuoyuedu(int huoyuedu) {
		this.huoyuedu = huoyuedu;
	}

	/**
	 * @return the iDArray
	 */
	public IDArray getIDArray() {
		return iDArray;
	}

	/**
	 * @param iDArray
	 *            the iDArray to set
	 */
	public void setIDArray(IDArray iDArray) {
		this.iDArray = iDArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.huoyuedu);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.huoyuedu = data.getInt();
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!huoyueduHandler.validate(huoyuedu)) {
			return false;
		}
		if (!iDArray.validate()) {
			return false;
		}
		return true;
	}

	@Override
	public int getMain() {
		return MAIN;
	}

	@Override
	public int getSub() {
		return SUB;
	}

	@Override
	public String getMessageKey() {
		return MESSAGE_KEY;
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("huoyuedu:").append(this.huoyuedu).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}