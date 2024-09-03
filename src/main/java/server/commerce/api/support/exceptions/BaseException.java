package server.commerce.api.support.exceptions;

import lombok.Getter;
import lombok.Setter;
import server.commerce.api.support.response.BaseResponseStatus;

@Getter
@Setter
public class BaseException extends RuntimeException {
	private BaseResponseStatus status;

	public BaseException(BaseResponseStatus status) {
		super(status.getMessage());
		this.status = status;
	}
}