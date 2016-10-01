package productPaymentRepository;

public class ProductOrderRepository {

	// variable
	static private int totalPrice = 0;
	static private int realPrice = 0;
	
	// setter and getter
	public static int getTotalPrice() {
		return totalPrice;
	}
	
	public static void setTotalPrice(int totalPrice) {
		ProductOrderRepository.totalPrice = totalPrice;
	}
	
	public static int getRealPrice() {
		return realPrice;
	}
	
	public static void setRealPrice(int realPrice) {
		ProductOrderRepository.realPrice = realPrice;
	}
					
}
