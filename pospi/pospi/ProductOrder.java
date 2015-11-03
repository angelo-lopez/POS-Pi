package pospi;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Holds the product model that includes the VAT rate and quantity ordered. Used to display
 * product information on the item display TextArea.
 * */
public class ProductOrder{
	private int productID;
	private String barcode;
	private int uomID;
	private String uomCode;
	private String description;
	private double price;
	private byte vatRate;
	private double quantity;/*
	 						*declared as double, quantity can also depend on 
	 						*unit of measurement such as gram eg. 0.5grams.
	 						*/
	
	/**
	 * Constructor.
	 **/
	public ProductOrder(){
		productID = 0;
		barcode = "";
		uomID = 0;
		uomCode = "";
		description = "";
		price = 0D;
		vatRate = 0;
		quantity = 0d;
	}//end constructor
	
	/**
	 * Constructor, overloaded
	 * @param productID int
	 * @param barcode String
	 * @param uomID uomID
	 * @param uomCode uomCode
	 * @param description String
	 * @param price double
	 * @param vatRate byte
	 * @param quantity quantity
	 **/
	public ProductOrder(int productID, String barcode, int uomID, String uomCode, String description, 
			       double price, byte vatRate, double quantity){
		this.productID = productID;
		this.barcode = barcode;
		this.uomID = uomID;
		this.uomCode = uomCode;
		this.description = description;
		this.price = price;
		this.vatRate = vatRate;
		this.quantity = quantity;
	}//end constructor

	//Getters.
	public int getProductID() {
		return productID;
	}

	public String getBarcode() {
		return barcode;
	}

	public int getUomID() {
		return uomID;
	}
	
	public String getUomCode(){
		return this.uomCode;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	public byte getVatRate(){
		return vatRate;
	}
	
	public double getQuantity(){
		return quantity;
	}

	//Setters.
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setUomID(int uomID) {
		this.uomID = uomID;
	}
	
	public void setUomCode(String uomCode){
		this.uomCode = uomCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setVatRate(byte vatRate){
		this.vatRate = vatRate;
	}
	
	public void setQuantity(double quantity){
		this.quantity = quantity;
	}

}//end class
