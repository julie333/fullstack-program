package service;


public interface MessageFormatter {

	default String format(String message) {
		return message;
	}

}