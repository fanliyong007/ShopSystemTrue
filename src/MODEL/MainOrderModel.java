package MODEL;

public class MainOrderModel 
{
	private String orderid;
	private String ordernumber ;
	private String orderprice ;
	private String paymoney ;
	private String changemoney; 
	private String buytime ;
	private String vcode ;
	private String seller ;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}
	public String getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}
	public String getChangemoney() {
		return changemoney;
	}
	public void setChangemoney(String hangemoney) {
		this.changemoney = changemoney;
	}
	public String getBuytime() {
		return buytime;
	}
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public MainOrderModel(String orderid, String ordernumber, String orderprice, String paymoney, String changemoney,
			String buytime, String vcode, String seller) {
		super();
		this.orderid = orderid;
		this.ordernumber = ordernumber;
		this.orderprice = orderprice;
		this.paymoney = paymoney;
		this.changemoney = changemoney;
		this.buytime = buytime;
		this.vcode = vcode;
		this.seller = seller;
	}
	
	
}
