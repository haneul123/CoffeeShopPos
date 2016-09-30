package productOrder.repository;

public class ProductOrderRepository {

	// variable
	private static int totalPrice;
	private static int RealPrice;
	
	
	// constructor
	public ProductOrderRepository() {
		
		
	}
	
	
	// getter and setter
	public static int getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(int totalPrice) {
		ProductOrderRepository.totalPrice = totalPrice;
	}

	public static int getRealPrice() {
		return RealPrice;
	}

	public static void setRealPrice(int realPrice) {
		RealPrice = realPrice;
	}

}
