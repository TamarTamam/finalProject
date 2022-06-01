package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CouponPage extends BasePage{
	@FindBy(css="button > span")
	WebElement newList;
	@FindBy(css="[name='coupon-list-name']")
	WebElement listName;
	@FindBy(css="[name='coupon-platform']")
	WebElement couponPlatform;
	@FindBy(css="[name='coupon-type']")
	WebElement couponType;
	@FindBy(css="[name='coupon-code']")
	WebElement couponCode;
	@FindBy(css="[rows='10']")
	WebElement couponCodes;
	@FindBy(css="[type='number']")
	WebElement couponLimit;
	@FindBy(css="button.relative.py-2.px-4 span")
	WebElement createBtn;

	public CouponPage(WebDriver driver) {
		super(driver);
	}
	//Create a list of single coupons
	public void couponSingleList(String name, String Platform, String code, String num) {
		click(newList);
		fillText(listName, name);
		select(couponPlatform, Platform);
		select(couponType, "single");
		sleep(500);
		fillText(couponCode, code);
		fillText(couponLimit, num);
		click(createBtn);
		sleep(500);
	}
	//Create a list of multiple coupons
	public void couponMultipleList(String name, String Platform, String codes) {
		click(newList);
		fillText(listName, name);
		select(couponPlatform, Platform);
		select(couponType, "multiple");
		sleep(500);
		fillText(couponCodes, codes);
		click(createBtn);
		sleep(500);
	}
}
