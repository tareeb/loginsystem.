package loginsystem;

import org.json.JSONObject;
import com.google.gson.*;
import com.mashape.unirest.http.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class HeroApi {

	private int status = 0 ;
	private ImageIcon heropicture = null ;
	private String herodata[] = null ;
	
	@SuppressWarnings("deprecation")
	public int searchhero(String heroname) {
		HttpResponse<String> response = null ;
		
		try {
			response = Unirest.get("https://superhero-search.p.rapidapi.com/api/?hero="+heroname+"")
						.header("x-rapidapi-host", "superhero-search.p.rapidapi.com")
						.header("x-rapidapi-key", "d687dcad99msh3fc9fb2e826b4b6p13a74cjsnd17623d827b1")
						.asString();
			
			this.setstatus(response.getStatus())  ;
			
		} catch (Exception e1) {
			return 1 ;
		}
		
		String data = null ;
		String picture = null ;
		
		try {
			
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 JsonParser jp = new JsonParser();
		 JsonElement je = jp.parse(response.getBody().toString());
		 data = gson.toJson(je);
		 JSONObject dataobj = new JSONObject(data);
		 JSONObject imagesobj = dataobj.getJSONObject("images");
		 picture = imagesobj.getString("md");
		
		 
		 heropicture = null ;
		 
		 URL pictureurl = null ;
		 try {
			pictureurl = new URL(picture);
		} catch (MalformedURLException e) {
			this.setstatus(2);
		}
		 
		 this.heropicture = new ImageIcon(pictureurl) ;
		 
		 this.herodata = data.split(",");
		 
		}
		catch(Exception e){
			this.setstatus(4);
		}
		
		return 0 ;
	}
	
	public int getstatus() {
		return this.status ;
	}
	
	public void setstatus(int status) {
		this.status = status ;
	}
	
	public ImageIcon getHeroImage() {
		return this.heropicture;
	}
	
	public String[] getHeroData() {
		return this.herodata;
	}
}
