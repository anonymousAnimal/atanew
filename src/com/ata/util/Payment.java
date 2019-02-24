package com.ata.util;

import com.ata.bean.PaymentBean;

public interface Payment {
	boolean findByCardNumber(String userID, String cardNumber);   
	String process(PaymentBean payment) ;        

}
