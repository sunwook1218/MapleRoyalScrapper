package scrap.sun.maple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RoyalScrapper {

	public static List<Product> getList() throws IOException {

		List<Product> list = new ArrayList<Product>();

		Document doc = Jsoup.connect("https://maplestory.nexon.com/Guide/CashShop/Probability/RoyalStyle").get();

		Elements elements = doc.select(".my_page_tb2 td");

		int idx = 0;

		String name = "Default Value";
		double proability = 0;

		for (Element element : elements) {

			if (idx % 2 == 1) {
				name = element.text();
			}

			if (idx != 0 && idx % 2 == 0) {
				proability += Double.parseDouble(element.text().replace("%", "").trim());
				Product product = new Product(name, proability);
				list.add(product);
			}

			idx++;
		}

		if (list.get(list.size() - 1).getProability() == 100.0) {
			System.out.println("machine.RoyalScrapper ------> " + "정상적으로 확률이 적용되었습니다.");
		} else {

		}
		return list;

	}

}
