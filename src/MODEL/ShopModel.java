package MODEL;

public class ShopModel 
{
	private String shopid;
	private String shopname;
	private String shopinprice;
	private String shopoutprice;
	private String shopnum;
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopinprice() {
		return shopinprice;
	}
	public void setShopinprice(String shopinprice) {
		this.shopinprice = shopinprice;
	}
	public String getShopoutprice() {
		return shopoutprice;
	}
	public void setShopoutprice(String shopoutprice) {
		this.shopoutprice = shopoutprice;
	}
	public String getShopnum() {
		return shopnum;
	}
	public void setShopnum(String shopnum) {
		this.shopnum = shopnum;
	}
	public ShopModel(String shopid, String shopname, String shopinprice, String shopoutprice, String shopnum) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.shopinprice = shopinprice;
		this.shopoutprice = shopoutprice;
		this.shopnum = shopnum;
	}
	

}
