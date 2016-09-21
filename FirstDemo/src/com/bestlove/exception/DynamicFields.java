package com.bestlove.exception;

/**
 * 异常链
 * 捕获一个异常后抛出另一个异常，
 * 并且希望把原始的信息保存下来，这称为异常链。
 * 
 * 所有的Throwable的子类在构造器中都可以接受一个
 * cause(因由)对象作为参数。这个cause就用来表示原始异常，
 * 这样通过把原始异常传递给新的异常，使得即使在当前位置创建
 * 并抛出了新的异常，也能通过这个异常链追踪到异常最初发生的位置
 * @author think
 *
 */

class DynamicFieldsException extends Exception {
	
}

public class DynamicFields {
	//多维数组
	private Object[][] fields;
	public DynamicFields(int initialSize) {
		//初始化数组大小
		fields = new Object[initialSize][2];
		for (int i = 0; i < initialSize; i++) {
			fields[i] = new Object[] {null, null};
		}
	}
	//toString方法
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Object[] obj : fields) {
			result.append(obj[0]);
			result.append("：");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}
	//是否存在
	private int hasField(String id){
		for (int i = 0; i < fields.length; i++) {
			if(id.equals(fields[i][0])){
				return i;
			}
		}
		//不存在
		return -1;
	}
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if(fieldNum == -1){//不存在，抛出异常
			throw new NoSuchFieldException();
		}
		//存在返回值
		return fieldNum;
	}
	private int makeField(String id){
		for (int i = 0; i < fields.length; i++) {
			if(fields[i][0] == null){
				fields[i][0] = id;
				return i;
			}
		}
		Object[][] tmp = new Object[fields.length + 1][2];
		for (int i = 0; i < fields.length; i++) {
			tmp[i] = fields[i];
		}
		for (int i = fields.length; i < tmp.length; i++) {
			tmp[i] = new Object[] {null, null};
		}
		fields = tmp;
		//回调
		return makeField(id);
	}
	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}
	public Object setField(String id, Object value) throws DynamicFieldsException {
		if(value == null){
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int fieldNumber = hasField(id);
		if(fieldNumber == -1){
			fieldNumber = makeField(id);
		}
		Object result = null;
		try {
			result = getField(id);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try {
			df.setField("d", "A value for d");
			df.setField("number", 47);
			df.setField("number2", 48);
			System.out.println(df);
			df.setField("d", "A new value for d");
			df.setField("number3", 11);
			System.out.println("df:" + df);
			System.out.println("df.getField(\"d\") : " + df.getField("d"));
			Object field = df.setField("d", null);
		} catch (NoSuchFieldException e) {
			System.out.println("one");
			e.printStackTrace(System.out);
		} catch (DynamicFieldsException e) {
			System.out.println("two");
			e.printStackTrace(System.out);
		}
	}
}
