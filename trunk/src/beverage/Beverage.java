package beverage;

import java.util.Map;
import beverage.ArticleInfo;
public class Beverage {
	private Map<Enum, String> info;

	public Beverage(Map<Enum, String> info) {
		this.info = info;
	}
	public String getId(){
		return info.get(ArticleInfo.ID);
	}
	public String getName(){
		return info.get(ArticleInfo.NAME) + " " + info.get(ArticleInfo.NAME2);
	}
	public String getPrice(){
		return info.get(ArticleInfo.PRICE);
	}
	public String getVolume(){
		return info.get(ArticleInfo.VOLUME);
	}
	public String getType(){
		return info.get(ArticleInfo.TYPE);
	}
	public String getOrigin(){
		return info.get(ArticleInfo.ORIGIN);
	}
	public String getVintage(){
		return info.get(ArticleInfo.VINTAGE);
	}
	public String getAlcohol(){
		return info.get(ArticleInfo.ALCOHOL);
	}
	public boolean equals(Object o){
	    if (o instanceof Beverage) {
	        Beverage b = (Beverage) o;
	        return this.getId().equals(b.getId());
	      }
	      return false;
	}
}
