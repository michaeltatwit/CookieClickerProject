package Application;
public class Upgrades {
	
	//class variables
	private int number_unlocked, price_of_item;
	private boolean unlocked;
	
	/*
	 * Constructor to call a new upgradable item
	 * 
	 * @param n number of 
	 * 
	 */
	public Upgrades(int n, int p, boolean u) {
		this.number_unlocked = n;
		this.price_of_item = p;
		this.unlocked = u;
	}
	
	/*
	 * @return current number of unlocked items
	 */
	public int getNumber() {
		return number_unlocked;
	}
	/*
	 * @return current price of item to be unlocked 
	 */
	public int getPrice() {
		return price_of_item;
	}
	/*
	 * @return current state of item 
	 */
	public boolean getUnlocked() {
		return unlocked;
	}
	/*
	 * changes state of item
	 * @param b state of item
	 */
	public void setStatus(boolean b) {
		this.unlocked = b;
	}
	/*
	 * increases the price of the item after upgrading
	 * @param p increase to current price 
	 */
	public void increasePrice(int p) {
		this.price_of_item = price_of_item + p;
	}
	
	/*
	 * increments number of unlocked items by 1
	 */
	public void increaseNumber() {
		this.number_unlocked++;
	}
}
