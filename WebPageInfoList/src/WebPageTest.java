import junit.framework.TestCase;

/** represents the tests for the WebPages 
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class WebPageTest extends TestCase {

	Item kevin = new Image("kevin", 400, "png");
	Item annie = new Image("annie", 230, "jpeg");
	Item jackie = new Image("jackie", 300, "png");

	Item text1 = new Text("This is Kevin");
	Item text2 = new Text("This is Annie");
	Item text3 = new Text("My friend Jackie");



	ILoItem listf = new ConsLoItem(jackie, new MtLoItem());
	ILoItem listg = new ConsLoItem(text3, listf);


	WebPage bobsfriends = new WebPage("bob-friends.org", "Bob's Friends", listg);

	Item link1 = new Link("Here are Bob's friends", bobsfriends);

	ILoItem lista = new ConsLoItem(link1, new MtLoItem());
	ILoItem listb = new ConsLoItem(kevin, lista);
	ILoItem listc = new ConsLoItem(text1, listb);
	ILoItem listd = new ConsLoItem(annie, listc);
	ILoItem liste = new ConsLoItem(text2, listd);
	ILoItem listempty = new MtLoItem();

	WebPage myWP = new WebPage("myfriends.org", "My Friends", liste);
	WebPage emptyWP = new WebPage("", "", listempty);


	/** Tests for totalImageSize */
	public void testTotalImageSize() {
		assertEquals(this.bobsfriends.totalImageSize(), 300);
		assertEquals(this.emptyWP.totalImageSize(), 0);
		assertEquals(this.myWP.totalImageSize(), 930);
	}

	/** Tests for textLength */
	public void testTextLength() {
		assertEquals(this.kevin.textLength(), 8);
		assertEquals(this.bobsfriends.textLength(), 38);
		assertEquals(this.listempty.textLength(), 0);
		assertEquals(this.link1.textLength(), 60);
		assertEquals(this.myWP.textLength(), 113);
		assertEquals(this.text1.textLength(), 13);

	}

	/** Tests for images */
	public void testImages() {
		assertEquals(this.bobsfriends.images(), "jackie.png");
		assertEquals(this.listempty.images(), "");
		assertEquals(this.link1.images(), "jackie.png");
		assertEquals(this.myWP.images(), "annie.jpeg, kevin.png, jackie.png");
		assertEquals(this.text1.images(), "");
	}

	/** Tests for isimage */
	public void testIsimage() {
		assertEquals(this.jackie.isimage(), true);
		assertEquals(this.text1.isimage(), false);
		assertEquals(this.myWP.isimage(), true);
		assertEquals(this.link1.isimage(), false);
		assertEquals(this.liste.isimage(), true);
		assertEquals(this.lista.isimage(), false);
		assertEquals(this.listempty.isimage(), false);
	}

}
