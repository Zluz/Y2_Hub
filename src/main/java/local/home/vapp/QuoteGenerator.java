package local.home.vapp;

import java.util.Random;

public class QuoteGenerator {
	private String[] quotes = new String[20];

	public QuoteGenerator (){
		quotes[0] = "A friend asks only for your time not your money.";
		quotes[1] = "Your high-minded principles spell success.";
		quotes[2] = "Enjoy the good luck a companion brings you.";
		quotes[3] = "Hidden in a valley beside an open stream- This will be the type of place where you will find your dream.";
		quotes[4] = "What ever you're goal is in life, embrace it visualize it, and for it will be yours.";
		quotes[5] = "You will become great if you believe in yourself.";
		quotes[6] = "Never give up. You're not a failure if you don't give up.";
		quotes[7] = "It is now, and in this world, that we must live.";
		quotes[8] = "Adversity is the parent of virtue.";
		quotes[9] = "A stranger, is a friend you have not spoken to yet.";
		quotes[10] = "A new voyage will fill your life with untold memories.";
		quotes[11] = "Its amazing how much good you can do if you dont care who gets the credit.";
		quotes[12] = "Stop wishing. Start doing.";
		quotes[13] = "Your fortune is as sweet as a cookie.";
		quotes[14] = "Don't pursue happiness - create it.";
		quotes[15] = "Everything happens for a reason.";
		quotes[16] = "Rivers need springs.";
		quotes[17] = "All progress occurs because people dare to be different.";
		quotes[18] = "It is not necessary to show others you have change; the change will be obvious.";
		quotes[19] = "Next full moon brings an enchanting evening.";
	}
	
	public String getQuote(){
		Random r = new Random();
		return quotes[r.nextInt(20)];
	}
}