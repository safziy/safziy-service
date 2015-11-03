package com.lyb.client.message.protocol.segment;

import java.util.LinkedList;
import java.util.List;

import com.lyb.client.message.IMessageEncoder;
import com.lyb.client.message.handler.IMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.*;

/**
 * ${desc}
 * 
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class FactionTotalAwardArray implements IMessageEncoder {
	private List<FactionTotalAwardArrayItem> list = new LinkedList<FactionTotalAwardArrayItem>();

	public List<FactionTotalAwardArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FactionTotalAwardArrayItem item : list) {
			data.writeInt(item.getType());
			data.writeInt(item.getValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FactionTotalAwardArrayItem item = FactionTotalAwardArrayItem.create();
			item.setType(data.getInt());
			item.setValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FactionTotalAwardArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FactionTotalAwardArray create() {
		FactionTotalAwardArray array = new FactionTotalAwardArray();
		return array;
	}

	public static FactionTotalAwardArrayItem createItem() {
		FactionTotalAwardArrayItem item = new FactionTotalAwardArrayItem();
		return item;
	}

	public FactionTotalAwardArrayItem addData(int type, int value) {
		FactionTotalAwardArrayItem item = new FactionTotalAwardArrayItem();
		item.setType(type);
		item.setValue(value);
		list.add(item);
		return item;
	}

	public void addItem(FactionTotalAwardArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FactionTotalAwardArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FactionTotalAwardArrayItem implements IMessageEncoder {
		private int type;
		private int value;

		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");

		public static FactionTotalAwardArrayItem create() {
			FactionTotalAwardArrayItem item = new FactionTotalAwardArrayItem();
			return item;
		}

		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.type);
			data.writeInt(this.value);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.type = data.getInt();
			this.value = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!valueHandler.validate(value)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("type:").append(this.type).append(", ");
			bb.append("value:").append(this.value);
			return bb.toString();	
		}
	}
}