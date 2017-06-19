package MODEL;

public class DetailOrderModel
{
	private String timeid; 
	private String shopid; 
	private String orderid; 
	private String shopprice;
	public DetailOrderModel(String timeid, String shopid, String orderid, String shopprice) {
		super();
		this.timeid = timeid;
		this.shopid = shopid;
		this.orderid = orderid;
		this.shopprice = shopprice;
	}
	public String getTimeid() {
		return timeid;
	}
	public void setTimeid(String timeid) {
		this.timeid = timeid;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getShopprice() {
		return shopprice;
	}
	public void setShopprice(String shopprice) {
		this.shopprice = shopprice;
	}
	
}
