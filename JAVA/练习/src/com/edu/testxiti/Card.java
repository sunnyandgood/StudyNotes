package com.edu.testxiti;

/**
 * 定义一个名为 Card 的扑克牌类，该类有两个 private 访问权限的字符串变量 face 和 suit ：分别描述一张牌的牌面值
 * （如： A 、 K 、 Q 、 J 、 10 、 9 、 … 、 3 、 2 等）和花色（如：“黑桃”、“红桃”、“梅花”和“方块”）。
 * 定义 Card 类中的 public 访问权限的构造方法，为类中的变量赋值；定义 protected 访问权限的方法 getFace() ，得到扑克牌的牌面值 ; 
 * 定义 protected 访问权限的方法 getSuit() ，得到扑克牌的花色 ; 定义方法 toString() ，
 * 返回表示扑克牌的花色和牌面值字符串（如“红桃 A ”、“梅花 10 ” 等）。
 * @author sunny
 *
 */
public class Card {
	private String face;//A 、 K 、 Q 、 J 、 10 、 9 、 … 、 3 、 2 等
	private String suit;//“黑桃”、“红桃”、“梅花”和“方块”
	
	public Card() {
		
	}
	public Card(String suit,String face) {
		this.face = face;
		this.suit = suit;
	}
	
	protected String getFace() {
		return face;
	}
	protected String getSuit() {
		return suit;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return suit + face;
	}
	
	public static void main(String[] args) {
		Card card = new Card("红桃","A");
		
		String suit2 = card.getSuit();
		String face2 = card.getFace();
		
		System.out.println(suit2);
		System.out.println(face2);
		System.out.println(card);
	}
}
