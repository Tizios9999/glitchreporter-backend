package com.ds.glitchreporter.utils;

import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.User;

public class MessageUtils {

public static String getMessageSender(Message message) {
		
		User sender = message.getSender();
		
		if (sender.isDeleted()) {
			return "Ex User";
		} else {
			return sender.getUsername();
		}
}
}