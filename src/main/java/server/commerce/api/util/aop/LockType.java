package server.commerce.api.util.aop;

public enum LockType {
	DECREASE_STOCK {
		@Override
		public String getKey(Long orderId) {
			return "PRODUCT:".concat(orderId.toString());
		}
	};

	public abstract String getKey(Long orderId);
}