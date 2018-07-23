package test;

import java.io.*;

class Rectangle  implements Serializable{

	private static final long serialVersionUID = 1710022455003682613L;

	private Integer width;
	private Integer height;
	private transient Integer area;

	public Rectangle (Integer width, Integer height){
		this.width = width;
		this.height = height;
		this.area = width * height;
	}

	public void setArea(){
		this.area = this.width * this.height;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		sb.append("width : ");
		sb.append(this.width);
		sb.append("\nheight : ");
		sb.append(this.height);
		sb.append("\narea : ");
		sb.append(this.area);

		return sb.toString();
	}
}

public class TransientExample{

	public static void main(String[] args) throws Exception{
		Rectangle rectangle = new Rectangle(3, 4);
		System.out.println("原始对象 ：" + rectangle);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("rectangle")));
		out.writeObject(rectangle);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("rectangle")));
		Rectangle rectangle1 = (Rectangle) in.readObject();
		System.out.println("序列化之后对象 : " + rectangle1);
		rectangle1.setArea();
		System.out.println("序列化之后对象 : " + rectangle1);
	}
}