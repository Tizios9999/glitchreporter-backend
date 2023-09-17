package com.ds.glitchreporter.utils;

import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.User;

/**
 * Utility class for handling operations related to messages.
 */
public class MessageUtils {
	
    /**
     * Gets the sender of a message as a string.
     *
     * @param message The Message entity for which the sender is determined.
     * @return A string representation of the message sender, which can be the sender's username or "Ex User" if the sender is deleted.
     */
	public static String getMessageSender(Message message) {
			
			User sender = message.getSender();
			
			if (sender.isDeleted()) {
				return "Ex User";
			} else {
				return sender.getUsername();
			}
	}
}