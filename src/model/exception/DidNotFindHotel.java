package model.exception;

public class DidNotFindHotel extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DIDNT = "We can not find that hotel";

	public DidNotFindHotel() {
		super(DIDNT);
	}
}
