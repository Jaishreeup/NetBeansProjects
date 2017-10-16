package servlets;
import com.simplewire.sms.*;

public class send_text
{
	public static void main(String[] args) throws Exception
	{
		SMS sms = new SMS();

		// Subscriber Settings
		sms.setSubscriberID("123-456-789-12345");
		sms.setSubscriberPassword("Password Goes Here");

		// Optional Message Settings
		// Specify source and destination ports that will appear
		// in the GSM User-Data-Header
		//sms.setSourcePort((short)0x0000);
		//sms.setDestPort((short)0x0000);
		//
		// Specify a network type "hint" - helps Simplewire
		// choose between a TDMA vs. GSM network for example.
		// Only useful for certain types of messages such as
		// WAP push or MIDP Java WMA messages and if the destination
		// operator runs both TDMA and GSM networks.
		// sms.setNetworkType(SMS.NETWORK_TYPE_GSM);

		// Message Settings
		sms.setMsgPin("+11005101234");
		sms.setMsgFrom("Demo");
		sms.setMsgCallback("+11005551212");
		sms.setMsgText("Hello World From Simplewire!");

		System.out.println("Sending message to Simplewire...");

		// Send Message
		sms.msgSend();

		// Check For Errors
		if(sms.isSuccess())
		{
			System.out.println("Message was sent!");
		}
		else
		{
			System.out.println("Message was not sent!");
			System.out.println("Error Code: " + sms.getErrorCode());
			System.out.println("Error Description: " + sms.getErrorDesc());
			System.out.println("Error Resolution: " + sms.getErrorResolution() + "\n");
		}
	}
}
